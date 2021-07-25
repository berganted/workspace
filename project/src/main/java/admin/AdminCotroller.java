package admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminCotroller {
	@RequestMapping("/admin")
	public String index() {
		return "admin/index";
	}
	
}
