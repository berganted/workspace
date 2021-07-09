package news;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class NewsDao {
	@Autowired
	SqlSessionTemplate sessionTemplate;
	
	public List<NewsVo> selectAll(NewsVo vo){
		return sessionTemplate.selectList("news.selectAll",vo);
		
	}
	
	public int count(NewsVo vo) {
		return sessionTemplate.selectOne("news.count",vo);
	}
	public NewsVo detail(NewsVo vo) {
		return sessionTemplate.selectOne("news.detail",vo);
	}
	public void updateReadCount(NewsVo vo) {
		 sessionTemplate.update("news.updateReadCount",vo);
	}
	public int insert(NewsVo vo) {
		return sessionTemplate.insert("news.insert",vo);
	}
	public int update(NewsVo vo) {
		return sessionTemplate.update("news.update",vo);
	}
	public int delFilename(NewsVo vo) {
		return sessionTemplate.update("news.delFilename",vo);
	}
	public int delete(NewsVo vo) {
		return sessionTemplate.delete("news.delete", vo);
	}
}
