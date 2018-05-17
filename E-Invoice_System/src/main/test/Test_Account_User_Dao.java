import java.util.List;







import model.Account;
import model.User;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import dao.AccountDAO;
import dao.UserDAO;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/dispatcher-servlet.xml")
public class Test_Account_User_Dao {
	
	@Autowired
	@Qualifier("accountDAO")
	AccountDAO accountDao;	
	
	
	@Autowired
	@Qualifier("userDAO")
	UserDAO userDao;
	
	@BeforeClass
    public static void setUp() {
        System.out.println("-----> SETUP <-----");
    }
	
	@Test
    public void b_testGetAccount(){
        try{
        List<Account> accounts = accountDao.getAll();
        Assert.assertNotNull(accounts);
        
        System.out.println("List account with size: " + accounts.size());
        }
        catch(Exception e){
            e.printStackTrace();
            Assert.fail();
        }
	}
	
	
	@Test
    public void c_testGetUser(){
        try{
        List<User> users = userDao.getAll();
        Assert.assertNotNull(users);
        
        System.out.println("List account with size: " + users.size());
        }
        catch(Exception e){
            e.printStackTrace();
            Assert.fail();
        }
	}
	
	
	@Test
    public void a_testCreateAccountanduser(){
        try{
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        Account account = new Account();
             
        
        User newUser = new User();
		Account newAccount = new Account();
		newAccount.setActive(true);
		newAccount.setRole("ROLE_MEMBER");
		newAccount.setUserName("testJunit");
		newAccount.setHashPassword(passwordEncoder.encode("testJunit"));
		newUser.setAccount(newAccount);
		this.accountDao.create(newAccount);
		
		newUser.setAddress("address");
		newUser.setEmail("email");
		newUser.setName("testJunit");
		newUser.setLimitedMoney(10000.0);
		newUser.setPhoneNumber("0123456789");
		this.userDao.create(newUser);
		
		
        Account accountResult = accountDao.findbyUserName("testJunit");
        User userResult = userDao.findbyUserName("testJunit");
        Assert.assertNotNull(accountResult);
        Assert.assertNotNull(userResult);
        }
        catch(Exception e){
            e.printStackTrace();
            Assert.fail();
        }
	}
	
	
	@Test
    public void d_testUpdateAccount(){
        try{
              
        Account account = accountDao.findbyUserName("testJunit");
        
        account.setActive(false);
        
        accountDao.update(account);
        
        account = accountDao.findbyUserName("testJunit");
        Assert.assertEquals(account.isActive(),false);
        }
        catch(Exception e){
            e.printStackTrace();
            Assert.fail();
        }
	}
	
	
	@Test
    public void e_testUpdateUser(){
        try{
              
        User user = userDao.findbyUserName("testJunit");
        
        user.setName("hihi");
        
        userDao.update(user);
        
        user = userDao.findbyUserName("testJunit");
        Assert.assertEquals(user.getName(),"hihi");
        }
        catch(Exception e){
            e.printStackTrace();
            Assert.fail();
        }
	}
	
	@Test
    public void f_deleteUser(){
        try{
              
        User user = userDao.findbyUserName("testJunit");
        userDao.remove(user.getId());
        
        user = userDao.findbyUserName("testJunit");
        Assert.assertNull(user);
        }
        catch(Exception e){
            e.printStackTrace();
            Assert.fail();
        }
	}
	
	@Test
    public void g_deleteAccount(){
        try{
              
        Account account = accountDao.findbyUserName("testJunit");
        accountDao.remove(account.getId());
        
        account = accountDao.findbyUserName("testJunit");
        Assert.assertNull(account);
        }
        catch(Exception e){
            e.printStackTrace();
            Assert.fail();
        }
	}
	
	
}
