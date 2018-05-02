package dao;

import java.util.List;

import model.User;

public interface UserDAO {
	
	public void create(User user);
	public User findbyId(long id);
	public void remove(long id);
	public List<User> getAll();
	public void update(User user);
}
