package dao;

import java.util.List;

import model.User;

public interface UserDAO {
	public void saveOrUpdate(User u);
	public List<User> getAll();
}
