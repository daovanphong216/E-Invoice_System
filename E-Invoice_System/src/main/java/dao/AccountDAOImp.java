package dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import model.Account;
import model.User;

@Repository
@Transactional(readOnly = false)
public class AccountDAOImp implements AccountDAO{
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	@Override
	public void create(Account account) {
		Session session = getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.save(account);
		tx.commit();
		session.close();
		
	}
	
	@Override
	public Account findbyId(long id){
		Session session = getSessionFactory().openSession();
		Account user = (Account) session.get(Account.class, id);
		session.close();
		return user;
	}	
	
		
	@Override
	public void remove(long id) {
		Session session = getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		Account account = (Account) session.get(Account.class, id);
		session.delete(account);
		tx.commit();
		session.close();
	}
	
	@Override
	public void update(Account account) {
		Session session = getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(account);
		tx.commit();
		session.close();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Account> getAll() {
		Session session = getSessionFactory().openSession();
        List<Account> list = session.createQuery("from accounts").list();
        session.close();
        return list;
	}
	
	
	@Override
	public List<Account> searchAccount(String username, String type){
		Session session = getSessionFactory().openSession();
		Query query=null;
		if (type.equals("all")){
	        query= session.createQuery("select ac from accounts ac where lower(ac.userName) LIKE lower(:username) and ac.role= :role");
	        query.setParameter("username", "%"+username+"%");
	        query.setParameter("role", "ROLE_MEMBER");
		} else {
			query= session.createQuery("select ac from accounts ac where lower(ac.userName) LIKE lower(:username) and ac.isActive = :type and ac.role= :role");
	        query.setParameter("username", "%"+username+"%");
	        switch (type){
		        case "active":
		        	query.setParameter("type", true);
		        	break;
		        case "deactive":
		        	query.setParameter("type", false);
		        	break;
	        }
	        query.setParameter("role", "ROLE_MEMBER");
		}
        List<Account> list = query.list();
        session.close();
        return list;
	}
	
	@Override
	public List<Account> getAllAdmins(){
		Session session = getSessionFactory().openSession();
		Query query= session.createQuery("select ac from accounts ac where ac.role= :role");
	    query.setParameter("role", "ROLE_ADMIN");
        List<Account> list = query.list();
        session.close();
        return list;
	}
	
	
	@Override
	public Account findbyUserName(String userName) {
		Session session = getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		Criteria query = session.createCriteria(Account.class);
		query.add(Restrictions.eq("userName", userName));
		List<Account> results = query.list();
		tx.commit();
		session.close();
		if (results.isEmpty()) {
			return null;
		}else{
				return results.get(0);
			}
	}
	
}
