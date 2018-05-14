package service;

import java.util.List;

import model.Account;
import model.User;

public interface UserService {
	public void create(User u);
	public void update(User u);
	public List<User> getAll();
	public List<Account> getAllAccount();
	public List<String> getAllEmails();
	public User findbyUserName(String userName);
	public User findbyId(long id);
	public boolean checkDuplicatedUser(String username);
	public void createMember(String userName, String hashPassword, String name, String phoneNumber, String email, String address);
	public void createAdmin(String string, String encode, String string2, String string3, String string4,
			String string5);
	
}
