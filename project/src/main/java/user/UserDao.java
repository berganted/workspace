package user;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class UserDao {
	@Autowired
	SqlSessionTemplate sessionTemplate;
	
	public List<UserVo> selectAll(UserVo vo){
		return sessionTemplate.selectList("user.selectAll",vo);
		
	}
	
	public int count(UserVo vo) {
		return sessionTemplate.selectOne("user.count",vo);
	}
	public UserVo detail(UserVo vo) {
		return sessionTemplate.selectOne("user.detail",vo);
	}
	public int insert(UserVo vo) {
		return sessionTemplate.insert("user.insert",vo);
	}
	public int update(UserVo vo) {
		return sessionTemplate.update("user.update",vo);
	}
	public int delete(UserVo vo) {
		return sessionTemplate.delete("user.delete", vo);
	}
	public int isDuplicateld(String id) {
		return sessionTemplate.selectOne("user.isDuplicateld", id);

	}
	public UserVo login(UserVo vo) {
		return sessionTemplate.selectOne("user.login",vo);
	}
	public UserVo searchid(UserVo vo) {
		return sessionTemplate.selectOne("user.searchId",vo);
	}
	public UserVo searchpwd(UserVo vo) {
		return sessionTemplate.selectOne("user.searchPwd",vo);
	}
	public int updateTempPwd(UserVo vo) {
		return sessionTemplate.update("user.updateTempPwd",vo);
	}
	
}
