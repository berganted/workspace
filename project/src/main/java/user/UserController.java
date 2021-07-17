package user;

import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import board.BoardService;
import board.BoardVo;



@Controller
public class UserController {

	@Autowired
	UserService service;
	@Autowired
	BoardService boardService;
	
//	@RequestMapping("/user/index.do")
//	public String index(Model model,UserVo vo) {
//		model.addAttribute("list",service.selectAll(vo));		
//		return "admin/user/index";
//	}
//	@RequestMapping("/user/detail.do")
//	public String detail(Model model , UserVo vo, HttpServletRequest req) {
//		
//		model.addAttribute("vo",service.detail(vo));
//		return "/user/detail";
//	}
	@RequestMapping("/user/join.do")
	public String write() {
		return "user/join";
	}
	@RequestMapping("/user/insert.do")
	public String insert(Model model , UserVo vo,  HttpServletRequest req , HttpServletResponse res) {
			int r = service.insert(vo);
			if(r > 0) {
				model.addAttribute("msg", "정상적으로 등록 되었습니다.");
				model.addAttribute("url", "/project/board/index.do");
			}else {
				model.addAttribute("msg", "등록실패.");
				model.addAttribute("url", "join.do");
			}
			return "include/alert";			
	}
	@RequestMapping("/user/edit.do")
	public String edit(Model model , UserVo vo) {
			model.addAttribute("vo", service.edit(vo));
			
		return "/user/edit";
	}
	@RequestMapping("/user/insertAjex.do")
	public String insertAjax(Model model , UserVo vo,  HttpServletRequest req , HttpServletResponse res) {
			int r = service.insert(vo);
			if(r > 0) {
				model.addAttribute("result", "true");
			}else {
				model.addAttribute("result", "false.");
			}
			return "include/result";			
	}

	@RequestMapping("/user/update.do")
	public String update(Model model , UserVo vo, @RequestParam("filename") MultipartFile filename, HttpServletRequest req , HttpServletResponse res) {
			int r = service.update(vo);
			if(r > 0) {
				model.addAttribute("msg", "정상적으로 수정 되었습니다.");
				model.addAttribute("url", "index.do");
						
			}else {
				model.addAttribute("msg", "수정실패.");
				
			}
			return "include/alert";			
	}
	@RequestMapping("/user/delete.do")
	public String delete(Model model, UserVo vo) {
		int r = service.delete(vo);
		if(r > 0) {
			model.addAttribute("result", "true");				
		}else {
			model.addAttribute("result", "false");
		}
		return "include/result";
	}
	
	@RequestMapping("/user/isDuplicateld.do")
	public String isDuplicateld(Model model, @RequestParam String id ) {
			int r = service.isDuplicateld ( id );
			if(r == 0) {
				model.addAttribute("result","false");
			}else {
				model.addAttribute("result","true");
			}
			return "include/result";
	}
	@RequestMapping(value = "/user/login.do", method = RequestMethod.GET)
	public String login() {
		
		return "user/login";
	}
	@RequestMapping(value = "/user/login.do", method = RequestMethod.POST)
	public String loginexe(UserVo vo,HttpSession sess,HttpServletResponse res, HttpServletRequest req,Model model) throws Exception {
		UserVo u = service.login(vo);
		if(u != null) {
			 sess.setAttribute("userInfo", u);
			 
			 return"redirect:/board/index.do";			 
		 }else {
			 	model.addAttribute("msg", "아이디와 비밀번호를 확인해 주세요");
				model.addAttribute("url", "login.do");
				return "include/alert";
		 }
	}
	@RequestMapping("/user/logout.do")
	public String logout(HttpSession sess, Model model) {
		sess.invalidate();
		model.addAttribute("msg", "로그아웃");
		model.addAttribute("url", "/project/board/index.do");
		return "include/alert";
	}
	@RequestMapping("/user/mypage.do")
	public String mypage( BoardVo vo , Model model , HttpSession sess) {
		
			vo.setUser_no(((UserVo)sess.getAttribute("userInfo")).getNo());
			model.addAttribute("list", boardService.selectAll(vo));
			
		return "/user/mypage";
	}
	@RequestMapping(value = "user/searchId.do",method = RequestMethod.GET)
	public String searchid(Model model , UserVo vo) {
		return "user/searchId";
	}
	@RequestMapping(value = "user/searchId.do",method = RequestMethod.POST)
	public String searchid2(Model model , UserVo vo) {
		UserVo uv = service.searchid(vo);
		String id = "";
		if(uv!=null) {
			id = uv.getId();
		}
		model.addAttribute("result", id);
		return "include/result";
	}
	@RequestMapping(value = "user/searchPwd.do",method = RequestMethod.GET)
	public String searchpwd(Model model , UserVo vo) {
		
		return "user/searchPwd";
	}
	@RequestMapping(value = "user/searchPwd.do",method = RequestMethod.POST)
	public String searchpwd2(Model model , UserVo vo) {
		UserVo uv = service.searchpwd(vo);
		if(uv!=null) {
			model.addAttribute("result", "ok");
		}else {
			model.addAttribute("result", "no");
		}
		return "include/result";
	}
	
}