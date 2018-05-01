package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import dao.AccountDAO;
import model.Account;


@Service
public class AccountServiceImp implements AccountService {

	@Autowired
	@Qualifier("accountDAO")
	AccountDAO accountDao;
	

	/*public UserDAO getU() {
		return userDao;
	}*/

	
	/*public void setU(UserDAO u) {
		this.u = u;
	}*/
	
	public void create(Account account) {
		accountDao.create(account);
	}

	
	public void update(Account account) {
		accountDao.update(account);
	}

	public List<Account> getAll() {
		return accountDao.getAll();
	}

}