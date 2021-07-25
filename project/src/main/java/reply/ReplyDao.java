package reply;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class ReplyDao {
	@Autowired
	SqlSessionTemplate sessionTemplate;
	
	public List<ReplyVo> selectAll(ReplyVo vo){
		return sessionTemplate.selectList("reply.selectAll",vo);
		
	}
	
	public int count(ReplyVo vo) {
		return sessionTemplate.selectOne("reply.count",vo);
	}
	public ReplyVo detail(ReplyVo vo) {
		return sessionTemplate.selectOne("reply.detail",vo);
	}
	public void updateReadCount(ReplyVo vo) {
		 sessionTemplate.update("reply.updateReadCount",vo);
	}
	public int insert(ReplyVo vo) {
		return sessionTemplate.insert("reply.insert",vo);
	}
	public int insertReply(ReplyVo vo) {
		return sessionTemplate.insert("reply.insertReply",vo);
	}
	public int gno(int no) {
		return sessionTemplate.update("reply.gno",no);
	}
	public int onoupdate(ReplyVo vo) {
		return sessionTemplate.update("reply.onoupdate", vo);
	}
	public int update(ReplyVo vo) {
		return sessionTemplate.update("reply.update",vo);
	}
	public int delFilename(ReplyVo vo) {
		return sessionTemplate.update("reply.delFilename",vo);
	}
	public int delete(ReplyVo vo) {
		return sessionTemplate.delete("reply.delete", vo);
	}
}
