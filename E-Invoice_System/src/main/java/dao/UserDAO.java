package dao;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import model.User;

@Repository
@Transactional
public class UserDAO extends HibernateDaoSupport{
	public User findbyId(long id){
		return getHibernateTemplate().get(User.class, id);
	}
	
	public void add(User user) {
		getHibernateTemplate().save(user);
	}
	
	public void remove(long id) {
		getHibernateTemplate().delete(findbyId(id));
	}
	
	@SuppressWarnings("unchecked")
	public List<User> getAllUser(){
		return ((List<User>) getHibernateTemplate().find("from users"));
		
	}
	
}
