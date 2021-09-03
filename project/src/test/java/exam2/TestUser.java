package exam2;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import user.UserDao;
import user.UserVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/context-servlet.xml"})
public class TestUser {
	@Autowired
	UserDao dao;
	@Test
	public void cntTest() {
		UserVo vo = new UserVo();
		int r = dao.count(vo);
		assertTrue(r>0);
		System.out.println(r);
	}
	@Test
	public void selectAllTest() {
		UserVo vo = new UserVo();
		List<UserVo> list = dao.selectAll(vo);
		assertNotNull(list);
	}
	
	
}
