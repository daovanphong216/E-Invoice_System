package dao;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import model.InvoiceType;

public class InvoiceTypeDAO extends HibernateDaoSupport{
	public InvoiceType findbyId(long id){
		return getHibernateTemplate().get(InvoiceType.class, id);
	}
	
	public void add(InvoiceType type) {
		getHibernateTemplate().save(type);
	}
	
	public void remove(long id) {
		getHibernateTemplate().delete(findbyId(id));
	}
	
}
