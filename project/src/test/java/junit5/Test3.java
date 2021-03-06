package junit5;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import board.BoardDao;
import board.BoardVo;
import user.UserVo;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"classpath:config/context-servlet.xml"})
@TestMethodOrder(MethodOrderer.OrderAnnotation.class) // 순서지정
@WebAppConfiguration
public class Test3 {
	
	@Autowired
	BoardDao dao;
	//가상mvc객체
	MockMvc mockMvc;
	@Autowired
	WebApplicationContext ctx;
	MockHttpSession sess;
	
	@BeforeEach
	void init() {
		mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
		
		//세션
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		UserVo vo = new UserVo();
		vo.setNo(999);
		sess = new MockHttpSession();
		sess.setAttribute("userInfo", vo);
		request.setSession(sess);
	}
	@Test
	@Order(1)
	void selectAllTest() {
		BoardVo bv = new BoardVo();
		bv.setReqPage(2);
		List<BoardVo> list = dao.selectAll(bv);
		for(BoardVo vo : list) {
			System.out.println(vo.getTitle());
		}
	}
	@Test
	@Order(2)
	void detailTest() {
		BoardVo bv = new BoardVo();
		bv.setNo(10);
		BoardVo vo = dao.detail(bv);
		
			System.out.println(vo.getTitle());
		
	}
	// /board/index.do로 접속 테스트
	@Test
	@Order(3)
	void boardIndex() throws Exception {
		RequestBuilder req = MockMvcRequestBuilders.get("/board/index.do");
		mockMvc.perform(req);
	}
	@Test
	@Order(4)
	void boardIndex2() throws Exception {
		RequestBuilder req = MockMvcRequestBuilders.get("/board/index.do").param("reqPage", "2");
		mockMvc.perform(req);
	}
	@Test
	@Order(5)
	void mypage() throws Exception {
		RequestBuilder req = MockMvcRequestBuilders.get("/user/mypage.do").session(sess);
		mockMvc.perform(req);
	}
	@Test
	@Order(6)
	void login() throws Exception {
		RequestBuilder req = MockMvcRequestBuilders.post("/user/login.do").param("id", "aaa").param("pwd", "bbb");
		mockMvc.perform(req);
	}
	
}
