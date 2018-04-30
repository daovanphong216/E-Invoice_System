package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import model.Account;

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
		session.save(account);;
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
		session.saveOrUpdate(account);;
		tx.commit();
		session.close();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Account> getAll() {
		Session session = getSessionFactory().openSession();
        List<Account> list = session.createQuery("from Account").list();
        session.close();
        return list;
	}
	
}
