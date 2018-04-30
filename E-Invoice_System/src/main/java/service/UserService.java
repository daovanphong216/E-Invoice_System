package service;

import java.util.List;


import model.User;

public interface UserService {
	public void create(User u);
	public void update(User u);
	public List<User> getAll();
}
