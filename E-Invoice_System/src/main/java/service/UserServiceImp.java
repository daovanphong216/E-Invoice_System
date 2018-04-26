package service;

import org.springframework.stereotype.Service;

import dao.UserDAO;
import model.User;


@Service
public class UserServiceImp implements UserService {

	UserDAO u;
	
	@Override
	public void saveOrUpdate(User u) {
		// TODO Auto-generated method stub
		
	}

}
