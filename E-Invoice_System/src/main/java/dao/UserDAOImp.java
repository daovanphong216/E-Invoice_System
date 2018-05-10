package dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import model.Account;
import model.Invoice;
import model.User;

@Repository
@Transactional(readOnly = false)
public class UserDAOImp implements UserDAO{
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	@Override
	public void create(User user) {
		Session session = getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.save(user);
		tx.commit();
		session.close();
		
	}
	
	@Override
	public User findbyId(long id){
		Session session = getSessionFactory().openSession();
		User user = (User) session.get(User.class, id);
		session.close();
		return user;
	}	
	
	@Override
	public void remove(long id) {
		Session session = getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		User user = (User) session.get(User.class, id);
		session.delete(user);
		tx.commit();
		session.close();
	}
	
	@Override
	public void update(User user) {
		Session session = getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(user);
		tx.commit();
		session.close();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAll() {
		Session session = getSessionFactory().openSession();
        List<User> list = session.createQuery("from users").list();
        session.close();
        return list;
	}

	@Override
	public User findbyUserName(String userName) {
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
				return results.get(0).getUser();
			}
	}


	
}
