package reply;

import java.util.List;


public interface ReplyService {
	List<ReplyVo>selectAll(ReplyVo vo);
	ReplyVo detail(ReplyVo vo);
	int insert(ReplyVo vo);
	int insertReply(ReplyVo vo);
	ReplyVo edit(ReplyVo vo);
	int update(ReplyVo vo);
	int delete(ReplyVo vo);
	int onoupdate(ReplyVo vo);
	 
}
