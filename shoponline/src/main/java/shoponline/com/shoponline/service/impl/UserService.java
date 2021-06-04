package shoponline.com.shoponline.service.impl;

import shoponline.com.shoponline.dao.IUserDAO;
import shoponline.com.shoponline.dao.impl.UserDAO;
import shoponline.com.shoponline.model.UserModel;
import shoponline.com.shoponline.service.IUserService;

public class UserService implements IUserService {

	private IUserDAO userDAO;

	public UserService() {
		userDAO = new UserDAO();
	}
	
	@Override
	public UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer status) {
		return userDAO.findByUserNameAndPasswordAndStatus(userName, password, status);
	}

	@Override
	public Long save(String userName, String fullName, String password, Integer status) {
		return userDAO.save(userName, fullName, password, status);
	}
	
}
