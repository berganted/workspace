package admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminCotroller {
	@RequestMapping("/admin")
	public String index() {
		return "admin/index";
	}
	@RequestMapping("admin/board/index.do")
	public String boardIndex() {
		return "admin/board/index";
	}
	@RequestMapping("admin/board/view.do")
	public String boardview() {
		return "admin/board/view";
	}
	@RequestMapping("admin/board/write.do")
	public String boardwrite() {
		return "admin/board/write";
	}
}
