package reply;

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
public class ReplyController {

	@Autowired
	ReplyService service;
	@Autowired
	CommentService cService;
	
	static final String TALBENAME = "reply";
	
	@RequestMapping("/reply/index.do")
	public String index(Model model,ReplyVo vo) {
		model.addAttribute("list",service.selectAll(vo));		
		return "reply/index";
	}
	@RequestMapping("/reply/detail.do")
	public String detail(Model model , ReplyVo vo, HttpServletRequest req,CommentVo cv) {
		
		model.addAttribute("vo",service.detail(vo));
		cv.setBoard_no(vo.getNo());
		cv.setTablename(TALBENAME);
		model.addAttribute("list",cService.selectAll(cv));
		return "reply/detail";
	}
	@RequestMapping("/reply/write.do") 
	public String write(ReplyVo vo , Model model,HttpSession sess ) {
		
		return "reply/write";
	}
	@RequestMapping("/reply/reply.do") 
	public String reply(ReplyVo vo , Model model,HttpSession sess ) {
		model.addAttribute("vo",service.detail(vo));
		return "reply/reply";
	}
	@RequestMapping("/reply/insert.do")
	public String insert(Model model , ReplyVo vo, @RequestParam("filename") MultipartFile filename, HttpServletRequest req , HttpServletResponse res,HttpSession sess) {
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
	@RequestMapping("/reply/insertReply.do")
	public String insertReply(Model model , ReplyVo vo, @RequestParam("filename") MultipartFile filename, HttpServletRequest req , HttpServletResponse res,HttpSession sess) {
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
			int r = service.insertReply(vo);
			if(r > 0) {
				model.addAttribute("msg", "정상적으로 등록 되었습니다.");
				model.addAttribute("url", "index.do");
						
			}else {
				model.addAttribute("msg", "등록실패.");
				model.addAttribute("url", "write.do");
			}
			return "include/alert";			
	}
	@RequestMapping("/reply/edit.do")
	public String edit(Model model , ReplyVo vo) {
			model.addAttribute("vo", service.edit(vo));
			
		return "/reply/edit";
	}
	@RequestMapping("/reply/update.do")
	public String update(Model model , ReplyVo vo, @RequestParam("filename") MultipartFile filename, HttpServletRequest req , HttpServletResponse res) {
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
	@RequestMapping("/reply/delete.do")
	public String delete(Model model, ReplyVo vo) {
		int r = service.delete(vo);
		if(r > 0) {
			model.addAttribute("result", "true");				
		}else {
			model.addAttribute("result", "false");
		}
		return "include/result";			
	}
	@RequestMapping("/reply/comment/insert.do")
	public String commentinsert(Model model , CommentVo vo) {
			vo.setTablename(TALBENAME);
			int r = cService.insert(vo);
			if(r > 0) {
				model.addAttribute("result", "true");
						
			}else {
				model.addAttribute("result", "false");
			}
			return "include/result";			
	}
	@RequestMapping("/reply/comment/list.do")
	public String commentlist(Model model , CommentVo cv) {
		cv.setTablename(TALBENAME);
		model.addAttribute("list",cService.selectAll(cv));
		return "/include/comment";
}
	@RequestMapping("/reply/comment/delete.do")
	public String delete(Model model, CommentVo vo) {
		int r = cService.delete(vo);
		if(r > 0) {
			model.addAttribute("result", "true");				
		}else {
			model.addAttribute("result", "false");
		}
		return "include/result";
	}
	
}