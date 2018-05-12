package service;

import java.util.List;

import model.Account;
import model.User;


public interface AccountService {
	public void create(String username, String password, String role);
	public void update(Account account);
	public Account findbyId(long id);
	public List<Account> getAll();
	public void updateActive(long id, boolean status);
	public List<Account> searchAccount(String username, String type, String role, int offset, int limit);
	public List<Account> getAllAdmins();
	public Account findbyUserName(String userName);
	public int countAccount(String status, String role);
}
