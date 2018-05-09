package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import dao.AccountDAO;
import model.Account;
import model.User;


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

	@Override
	public Account findbyId(long id){
		return this.accountDao.findbyId(id);
		
	}
	
	public List<Account> getAll() {
		return accountDao.getAll();
	}
	
	@Override
	public void updateActive(long id, boolean status){
		Account account = accountDao.findbyId(id);	
		if (account!=null){
			account.setActive(status);
			accountDao.update(account);
		}
	}
	
	@Override
	public List<Account> searchAccount(String username, String type){
		return accountDao.searchAccount(username, type);
	}

}
