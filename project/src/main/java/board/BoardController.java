package board;

import java.io.File;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;



@Controller
public class BoardController {

	@Autowired
	BoardService service;
	
	@RequestMapping("/board/index.do")
	public String index(Model model,BoardVo vo) {
		model.addAttribute("list",service.selectAll(vo));		
		return "board/index";
	}
	@RequestMapping("/board/detail.do")
	public String detail(Model model , BoardVo vo, HttpServletRequest req) {
		
		model.addAttribute("vo",service.detail(vo));
		return "/board/detail";
	}
	@RequestMapping("/board/write.do")
	public String write() {
		return "/board/write";
	}
	@RequestMapping("/board/insert.do")
	public String insert(Model model , BoardVo vo, @RequestParam("filename") MultipartFile filename, HttpServletRequest req , HttpServletResponse res) {
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
	@RequestMapping("/board/edit.do")
	public String edit(Model model , BoardVo vo) {
			model.addAttribute("vo", service.edit(vo));
			
		return "/board/edit";
	}
	@RequestMapping("/board/update.do")
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
	@RequestMapping("/board/delete.do")
	public String delete(Model model, BoardVo vo) {
		int r = service.delete(vo);
		if(r > 0) {
			model.addAttribute("reulst", "true");				
		}else {
			model.addAttribute("reulst", "false");
		}
		return "board/result";			
	}
	
}