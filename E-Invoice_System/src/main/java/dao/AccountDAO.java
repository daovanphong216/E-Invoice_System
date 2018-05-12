package dao;

import java.util.List;

import model.Account;

public interface AccountDAO {
	
	public void create(Account account);
	public Account findbyId(long id);
	public void remove(long id);
	public List<Account> searchAccount(String username, String type, String role, int offset, int limit);
	public List<Account> getAll();
	public int countAccount(String status, String role);
	public void update(Account account);
	public Account findbyUserName(String userName);
	public List<Account> getAllAdmins();
}
