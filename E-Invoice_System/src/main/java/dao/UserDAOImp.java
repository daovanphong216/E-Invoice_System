package dao;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import model.User;

@Transactional(readOnly = false)
public class UserDAOImp extends HibernateDaoSupport implements UserDAO{
	
	public User findbyId(long id){
		return getHibernateTemplate().get(User.class, id);
	}	
	
	public void remove(long id) {
		getHibernateTemplate().delete(findbyId(id));
	}
	
	@Override
	public void saveOrUpdate(User u) {
		getHibernateTemplate().save(u);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAll() {
		return ((List<User>) getHibernateTemplate().find("from users"));
	}
	
}
