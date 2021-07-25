package junit4;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
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
// 4 에서는 RunWith
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/context-servlet.xml"})
@WebAppConfiguration
public class Test3 {
	
	@Autowired
	BoardDao dao;
	//가상mvc객체
	MockMvc mockMvc;
	@Autowired
	WebApplicationContext ctx;
	MockHttpSession sess;
	
	@Before
	public void init() {
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
	public void selectAllTest() {
		BoardVo bv = new BoardVo();
		bv.setReqPage(2);
		List<BoardVo> list = dao.selectAll(bv);
		for(BoardVo vo : list) {
			System.out.println(vo.getTitle());
		}
	}
	@Test
	public void detailTest() {
		BoardVo bv = new BoardVo();
		bv.setNo(10);
		BoardVo vo = dao.detail(bv);
		
			System.out.println(vo.getTitle());
		
	}
	// /board/index.do로 접속 테스트
	@Test
	public void boardIndex() throws Exception {
		RequestBuilder req = MockMvcRequestBuilders.get("/board/index.do");
		mockMvc.perform(req);
	}
	@Test
	public void boardIndex2() throws Exception {
		RequestBuilder req = MockMvcRequestBuilders.get("/board/index.do").param("reqPage", "2");
		mockMvc.perform(req);
	}
	@Test
	public void mypage() throws Exception {
		RequestBuilder req = MockMvcRequestBuilders.get("/user/mypage.do").session(sess);
		mockMvc.perform(req);
	}
	@Test
	public void login() throws Exception {
		RequestBuilder req = MockMvcRequestBuilders.post("/user/login.do").param("id", "aaa").param("pwd", "bbb");
		mockMvc.perform(req);
	}
	
}
