package service;

import java.util.List;


import model.User;

public interface UserService {
	public void create(User u);
	public void update(User u);
	public List<User> getAll();
	public User findbyUserName(String userName);
	public User findbyId(long id);
	public boolean checkDuplicatedUser(String username);
	public void createMember(String userName, String hashPassword, String name, String phoneNumber, String email, String address);
}
