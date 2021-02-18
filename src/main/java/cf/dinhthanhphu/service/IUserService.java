package cf.dinhthanhphu.service;

import cf.dinhthanhphu.model.UserModel;

public interface IUserService {
	UserModel findUserNameAndPasswordAndStatus(String userName,  String password, Integer status);
}
