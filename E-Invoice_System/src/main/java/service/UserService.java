package service;

import java.util.List;


import model.User;

public interface UserService {
	public void saveOrUpdate(User u);
	public List<User> getAll();
}
