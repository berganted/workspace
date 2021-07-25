package reply;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReplyServiceimpl implements ReplyService {
	@Autowired
	ReplyDao dao ;
	@Override
	public List<ReplyVo> selectAll(ReplyVo vo) {
		int totCount = dao.count(vo);	
		int totPage = totCount/vo.getPageRow();
		if(totCount % vo.getPageRow()>0) totPage++;
		int strPage = (vo.getReqPage()-1)/vo.getPageRange()*vo.getPageRange()+1;
		int endPage = strPage + (vo.getPageRange()-1);
		if(endPage>totPage) {
			endPage = totPage;
		}
		vo.setStrPage(strPage);
		vo.setEndPage(endPage);
		vo.setTotCount(totCount);
		vo.setTotPage(totPage);
		return dao.selectAll(vo);
	}
	@Override
	public ReplyVo detail(ReplyVo vo) {
		dao.updateReadCount(vo);
		return dao.detail(vo);
	}
	@Override
	public ReplyVo edit(ReplyVo vo) {
		return dao.detail(vo);
	}
	@Override
	public int insert(ReplyVo vo) {
		if(dao.insert(vo) > 0) {
			dao.gno(vo.getNo());
			return 1;
		}else {
			return 0;
		}
	}
	@Override
	public int update(ReplyVo vo) {
		if("1".equals(vo.getIsDel())) {
			dao.delFilename(vo);
		}
		return dao.update(vo);
		
	}
	@Override
	public int delete(ReplyVo vo) {
		return dao.delete(vo);
		 
	}
	@Override
	public int insertReply(ReplyVo vo) {
		dao.onoupdate(vo);
		vo.setOno(vo.getOno()+1);
		vo.setNested(vo.getNested()+1);
		return dao.insertReply(vo);
	}
	@Override
	public int onoupdate(ReplyVo vo) {
		return dao.onoupdate(vo);
	}
	

}
