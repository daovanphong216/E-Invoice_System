package service;

import java.util.List;

import model.Account;


public interface AccountService {
	public void create(Account account);
	public void update(Account account);
	public List<Account> getAll();
}
