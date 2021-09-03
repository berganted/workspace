package exam;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import board.BoardDao;
import board.BoardVo;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"classpath:config/context-servlet.xml"})
public class TestBoard {
	
	@Autowired
	BoardDao dao;

	@Test
	void cntTest() {
		BoardVo vo = new BoardVo();
		int r = dao.count(vo);
		assertTrue(r>0);
		System.out.println(r);
	}
	@Test
	void selectAllTest() {
		BoardVo vo = new BoardVo();
		List<BoardVo> list = dao.selectAll(vo);
		assertNotNull(list);
	}
}
