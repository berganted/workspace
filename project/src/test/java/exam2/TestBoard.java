package exam2;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import board.BoardDao;
import board.BoardVo;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/context-servlet.xml"})
public class TestBoard {
	@Autowired
	BoardDao dao;
	
	@Test
	public void cntTest() {
		BoardVo vo = new BoardVo();
		int r = dao.count(vo);
		assertTrue(r>0);
		System.out.println(r);
	}
	@Test
	public void selectAllTest() {
		BoardVo vo = new BoardVo();
		List<BoardVo> list = dao.selectAll(vo);
		assertNotNull(list);
	}
	
	
}
