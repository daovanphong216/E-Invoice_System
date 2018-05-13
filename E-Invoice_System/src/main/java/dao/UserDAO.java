package dao;

import java.util.Date;
import java.util.List;

import model.User;

public interface UserDAO {
	
	public void create(User user);
	public User findbyId(long id);
	public User findbyUserName(String userName);
	public void remove(long id);
	public List<User> getAll();
	public void update(User user);
	public List<String> getAllEmails();
}
