package book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class bookController {
	@Autowired
	BookService service;
	
	@RequestMapping("/book/book.do")
	public String book(Model model , BookVo vo) {
		return "/book/book";
	}
	@RequestMapping("/book/bookapi.do")
	public String bookapi(Model model , BookVo vo) {
		int r = service.insert(vo);
		if(r > 0) {
			model.addAttribute("msg", "정상적으로 등록 되었습니다.");
			
					
		}else {
			model.addAttribute("msg", "등록실패.");
			
		}
		return "include/alert2";			
		
		
	}
}
