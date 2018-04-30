package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
	public void create(User u) {
		Session session = getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.save(u);;
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
	public void update(User u) {
		Session session = getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(u);;
		tx.commit();
		session.close();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAll() {
		Session session = getSessionFactory().openSession();
        List<User> list = session.createQuery("from User").list();
        session.close();
        return list;
	}
	
}
