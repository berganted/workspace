package news;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewsServiceimpl implements NewsService {
	@Autowired
	NewsDao dao ;
	@Override
	public List<NewsVo> selectAll(NewsVo vo) {
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
	public NewsVo detail(NewsVo vo) {
		dao.updateReadCount(vo);
		return dao.detail(vo);
	}
	@Override
	public NewsVo edit(NewsVo vo) {
		return dao.detail(vo);
	}
	@Override
	public int insert(NewsVo vo) {
		return dao.insert(vo);
		
	}
	@Override
	public int update(NewsVo vo) {
		if("1".equals(vo.getIsDel())) {
			dao.delFilename(vo);
		}
		return dao.update(vo);
		
	}
	@Override
	public int delete(NewsVo vo) {
		return dao.delete(vo);
		 
	}

}
