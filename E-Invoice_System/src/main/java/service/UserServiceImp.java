package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import dao.UserDAO;
import model.User;


@Service
public class UserServiceImp implements UserService {

	@Autowired
	@Qualifier("userDAO")
	UserDAO userDao;
	

	/*public UserDAO getU() {
		return userDao;
	}*/

	
	/*public void setU(UserDAO u) {
		this.u = u;
	}*/
	
	public void create(User user) {
		userDao.create(user);
	}

	
	public void update(User user) {
		userDao.update(user);
	}

	public List<User> getAll() {
		return userDao.getAll();
	}

}
