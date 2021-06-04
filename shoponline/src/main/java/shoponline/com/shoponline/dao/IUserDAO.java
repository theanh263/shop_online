package shoponline.com.shoponline.dao;

import shoponline.com.shoponline.model.UserModel;

public interface IUserDAO extends GenericDAO<UserModel> {
	UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer status);
	Long save(String userName,String fullName ,String password, Integer status);
}
