package bookapi;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceimpl implements BookService {
	@Autowired
	BookDao dao ;
	
	@Override
	public int insert(BookVo vo) {
		return dao.insert(vo);
		
	}
	

}
