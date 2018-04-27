package service;

import java.util.List;

import org.springframework.stereotype.Service;

import dao.UserDAO;
import model.User;


@Service
public class UserServiceImp implements UserService {

	UserDAO u;
	

	public UserDAO getU() {
		return u;
	}

	
	public void setU(UserDAO u) {
		this.u = u;
	}

	public void saveOrUpdate(User u) {
		getU().saveOrUpdate(u);
	}

	public List<User> getAll() {
		return getU().getAll();
	}

}
