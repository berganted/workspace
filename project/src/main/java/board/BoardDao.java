package board;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class BoardDao {
	@Autowired
	SqlSessionTemplate sessionTemplate;
	
	public List<BoardVo> selectAll(BoardVo vo){
		return sessionTemplate.selectList("board.selectAll",vo);
		
	}
	
	public int count(BoardVo vo) {
		return sessionTemplate.selectOne("board.count",vo);
	}
	public BoardVo detail(BoardVo vo) {
		return sessionTemplate.selectOne("board.detail",vo);
	}
	public void updateReadCount(BoardVo vo) {
		 sessionTemplate.update("board.updateReadCount",vo);
	}
	public int insert(BoardVo vo) {
		return sessionTemplate.insert("board.insert",vo);
	}
	public int update(BoardVo vo) {
		return sessionTemplate.update("board.update",vo);
	}
	public int delFilename(BoardVo vo) {
		return sessionTemplate.update("board.delFilename",vo);
	}
	public int delete(BoardVo vo) {
		return sessionTemplate.delete("board.delete", vo);
	}
}
