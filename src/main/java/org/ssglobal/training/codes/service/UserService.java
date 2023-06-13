package org.ssglobal.training.codes.service;

import java.util.List;

import org.ssglobal.training.codes.dao.UserDao;
import org.ssglobal.training.codes.model.User;
import org.ssglobal.training.codes.response.Response;

public interface UserService {
	List<UserDao> getAllUsers();
	UserDao getUserById(Integer userId);
	Response isEmailValid(User user);
	Response addUser(User user);
	Response updateUser(Integer userId, User user);
	Response deleteUser(Integer userId);
}
