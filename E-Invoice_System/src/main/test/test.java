import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.UserDAOImp;
import model.Account;
import model.User;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDAOImp userDAO = context.getBean(UserDAOImp.class);
		User u = new User();
		u.setName("Tu");
		u.setEmail("levantu.13139@gmail.com");
		u.setPhoneNumber("01699687376");
		u.setAddress("HCM");
		Account acc = new Account();
		acc.setActive(false);
		acc.setUserName("levantu");
		acc.setHashPassword("admin");
		acc.setRole("admin");
		u.setAccount(acc);
		SessionFactory set = userDAO.getSessionFactory();
		Session ss = set.openSession();
		ss.save(acc);
		System.out.println(ss.save(u));
		
	}

}
