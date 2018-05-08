package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import dao.AccountDAO;
import dao.UserDAO;
import model.Account;
import model.User;


@Service
public class UserServiceImp implements UserService {

	@Autowired
	@Qualifier("userDAO")
	UserDAO userDao;
	
	@Autowired
	@Qualifier("accountDAO")
	AccountDAO accountDao;
	

	/*public UserDAO getU() {
		return userDao;
	}*/

	
	/*public void setU(UserDAO u) {
		this.u = u;
	}*/
	
	public void create(User user) {
		userDao.create(user);
	}
	
	
	public boolean checkDuplicatedUser(String username){
		User user  = this.userDao.findbyUserName(username);
		if (user !=null) {
			return true;
		} else {
			return false;
		}
	}
	
	public void createMember(String userName, String hashPassword, String name, String phoneNumber, String email, String address) {
				
		User newUser = new User();
		Account newAccount = new Account();
		newAccount.setActive(true);
		newAccount.setRole("ROLE_MEMBER");
		newAccount.setUserName(userName);
		newAccount.setHashPassword(hashPassword);
		newUser.setAccount(newAccount);
		this.accountDao.create(newAccount);
		
		newUser.setAddress(address);
		newUser.setEmail(email);
		newUser.setName(name);
		newUser.setLimitedMoney(0.0);
		newUser.setPhoneNumber(phoneNumber);
		this.userDao.create(newUser);
	}

	
	public void update(User user) {
		userDao.update(user);
	}

	public List<User> getAll() {
		return userDao.getAll();
	}
	
	
	public List<Account> getAllAccount() {
		return accountDao.getAll();
	}


	@Override
	public User findbyUserName(String userName) {
		return this.userDao.findbyUserName(userName);
	}
	
	@Override
	public User findbyId(long id){
		return this.userDao.findbyId(id);
		
	}
}
