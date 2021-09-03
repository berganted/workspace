package board;

import java.io.File;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import comment.CommentService;
import comment.CommentVo;
import user.UserVo;



@Controller
public class AdminBoardController {

	@Autowired
	BoardService service;
	@Autowired
	CommentService cService;
	
	static final String TALBENAME = "board";
	
	@RequestMapping("/admin/board/index.do")
	public String index(Model model,BoardVo vo) {
		model.addAttribute("list",service.selectAll(vo));		
		return "admin/board/index";
	}
	@RequestMapping("/admin/board/detail.do")
	public String detail(Model model , BoardVo vo, HttpServletRequest req,CommentVo cv) {
		
		model.addAttribute("vo",service.detail(vo));
		cv.setBoard_no(vo.getNo());
		cv.setTablename(TALBENAME);
		model.addAttribute("list",cService.selectAll(cv));
		return "admin/board/view";
	}
	@RequestMapping("/admin/board/write.do") 
	public String write(BoardVo vo , Model model,HttpSession sess ) {
		
		return "admin/board/write";
	}
	@RequestMapping("/admin/board/insert.do")
	public String insert(Model model , BoardVo vo, @RequestParam("filename") MultipartFile filename, HttpServletRequest req , HttpServletResponse res,HttpSession sess) {
		  
			if(!filename.isEmpty()) {
				try {
				String org = filename.getOriginalFilename();//원본 파일명
				String ext ="";
				ext = org.substring(org.lastIndexOf("."));
				String real = new Date().getTime()+ext;//서버에 저장할 파일명
				String path = req.getRealPath("/upload/");
				System.out.println(path);
				filename.transferTo(new File(path+real));
				vo.setFilename_org(org);
				vo.setFilename_real(real);
				}catch (Exception e) {}
			}
			int r = service.insert(vo);
			if(r > 0) {
				model.addAttribute("msg", "정상적으로 등록 되었습니다.");
				model.addAttribute("url", "index.do");
						
			}else {
				model.addAttribute("msg", "등록실패.");
				model.addAttribute("url", "write.do");
			}
			return "include/alert";			
	}
	@RequestMapping("/admin/board/edit.do")
	public String edit(Model model , BoardVo vo) {
			model.addAttribute("vo", service.edit(vo));
			
		return "admin/board/edit";
	}
	@RequestMapping("/admin/board/update.do")
	public String update(Model model , BoardVo vo, @RequestParam("filename") MultipartFile filename, HttpServletRequest req , HttpServletResponse res) {
			//service.insert(vo);
			if(!filename.isEmpty()) {
				try {
				String org = filename.getOriginalFilename();//원본 파일명
				String ext ="";
				ext = org.substring(org.lastIndexOf("."));
				String real = new Date().getTime()+ext;//서버에 저장할 파일명
				String path = req.getRealPath("/upload/");
				System.out.println(path);
				filename.transferTo(new File(path+real));
				vo.setFilename_org(org);
				vo.setFilename_real(real);
				}catch (Exception e) {}
			}
			int r = service.update(vo);
			if(r > 0) {
				model.addAttribute("msg", "정상적으로 수정 되었습니다.");
				model.addAttribute("url", "index.do");
						
			}else {
				model.addAttribute("msg", "수정실패.");
				model.addAttribute("url", "edit.do?no="+vo.getNo());
			}
			return "include/alert";			
	}
	@RequestMapping("/admin/board/delete.do")
	public String delete(Model model, BoardVo vo) {
		int r = service.delete(vo);
		if(r > 0) {
			model.addAttribute("result", "true");				
		}else {
			model.addAttribute("result", "false");
		}
		return "include/result";			
	}
	@RequestMapping("admin/board/grouDelete.do")
	public String deleteg(Model model, HttpServletRequest req) {
		String[] no = req.getParameterValues("no");
		int count = 0;
		for(int i = 0; i<no.length; i++) {
			System.out.println(no[i]);
			BoardVo vo= new BoardVo();
			vo.setNo(Integer.parseInt(no[i]));
			count+=service.delete(vo);
		}
		model.addAttribute("msg", "총" +count+"건이 삭제되었습니다.");
		model.addAttribute("url", "index.do");
		return "include/alert";		
	}
	@RequestMapping("admin/board/grouDelete2.do")
	public String deleteg2(Model model,BoardVo vo, HttpServletRequest req) {
		int count = service.deleteGroup(vo);
		model.addAttribute("msg", "총" +count+"건이 삭제되었습니다.");
		model.addAttribute("url", "index.do");
		return "include/alert";		
	}
}