package comment;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CommentDao {
	@Autowired
	SqlSessionTemplate sessionTemplate;
	public List<CommentVo> selectAll(CommentVo vo){
		return sessionTemplate.selectList("comment.selectAll",vo);
		
	}
	public int count(CommentVo vo) {
		return sessionTemplate.selectOne("comment.count",vo);
	}
	public int insert(CommentVo vo) {
		return sessionTemplate.insert("comment.insert",vo);
	}
	public int delete(CommentVo vo) {
		return sessionTemplate.delete("comment.delete", vo);
	}

}
