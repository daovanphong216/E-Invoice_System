package dao;

import java.util.List;

import model.Account;

public interface AccountDAO {
	
	public void create(Account account);
	public Account findbyId(long id);
	public void remove(long id);
	public List<Account> searchAccount(String username, String type);
	public List<Account> getAll();
	public void update(Account account);
	public Account findbyUserName(String userName);
}
