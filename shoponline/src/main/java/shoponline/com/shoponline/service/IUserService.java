package shoponline.com.shoponline.service;

import shoponline.com.shoponline.model.UserModel;

public interface IUserService {
	UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer status);
	Long save (String userName, String fullName, String password, Integer status);
}
