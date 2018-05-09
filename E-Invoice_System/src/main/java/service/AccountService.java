package service;

import java.util.List;

import model.Account;
import model.User;


public interface AccountService {
	public void create(Account account);
	public void update(Account account);
	public Account findbyId(long id);
	public List<Account> getAll();
	public boolean updateActive(int id, boolean status);
	public List<Account> searchAccount(String username, String type);
}
