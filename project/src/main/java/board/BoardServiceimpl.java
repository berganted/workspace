package board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceimpl implements BoardService {
	@Autowired
	BoardDao dao ;
	@Override
	public List<BoardVo> selectAll(BoardVo vo) {
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
	public BoardVo detail(BoardVo vo) {
		dao.updateReadCount(vo);
		return dao.detail(vo);
	}
	@Override
	public BoardVo edit(BoardVo vo) {
		return dao.detail(vo);
	}
	@Override
	public int insert(BoardVo vo) {
		return dao.insert(vo);
		
	}
	@Override
	public int update(BoardVo vo) {
		if("1".equals(vo.getIsDel())) {
			dao.delFilename(vo);
		}
		return dao.update(vo);
		
	}
	@Override
	public int delete(BoardVo vo) {
		return dao.delete(vo);
		 
	}

}
