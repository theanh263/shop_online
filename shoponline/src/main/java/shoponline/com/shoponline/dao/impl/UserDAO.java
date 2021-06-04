package shoponline.com.shoponline.dao.impl;

import java.util.List;

import shoponline.com.shoponline.dao.IUserDAO;
import shoponline.com.shoponline.mapper.UserMapper;
import shoponline.com.shoponline.model.UserModel;


public class UserDAO extends AbstractDAO<UserModel> implements IUserDAO  {

	@Override
	public UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer status) {
		StringBuilder sql = new StringBuilder("SELECT * FROM user AS u");
		sql.append(" INNER JOIN role AS r ON r.id = u.roleid");
		sql.append(" WHERE username = ? AND password = ? AND status = ?");
		List<UserModel> users = query(sql.toString(), new UserMapper(), userName, password, status);
		return users.isEmpty() ? null : users.get(0);
	}

	@Override
	public Long save(String userName, String fullName, String password, Integer status) {
		StringBuilder sql = new StringBuilder("INSERT INTO user(username, fullname, password, status,roleid) VALUES (?,?,?,?,2)");
		return insert(sql.toString(), userName,fullName,password,status);
	}
	
}
