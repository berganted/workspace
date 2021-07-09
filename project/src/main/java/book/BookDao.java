package book;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class BookDao {
	@Autowired
	SqlSessionTemplate sessionTemplate;
	public int insert(BookVo vo) {
		return sessionTemplate.insert("book.insert",vo);
	}
}
