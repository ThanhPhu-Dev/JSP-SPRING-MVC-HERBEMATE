package cf.dinhthanhphu.service.impl;



import javax.inject.Inject;

import cf.dinhthanhphu.dao.IUserDAO;
import cf.dinhthanhphu.model.UserModel;
import cf.dinhthanhphu.service.IUserService;

public class UserService implements IUserService{

	@Inject
	private IUserDAO userDao;
	@Override
	public UserModel findUserNameAndPasswordAndStatus(String userName, String password, Integer status) {
		return userDao.findUserNameAndPasswordAndStatus(userName, password, status);
	}

}
