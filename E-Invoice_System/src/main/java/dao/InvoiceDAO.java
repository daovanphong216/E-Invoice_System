package dao;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import model.Invoice;

public class InvoiceDAO extends HibernateDaoSupport {
	
	public Invoice findbyId(long id){
		return getHibernateTemplate().get(Invoice.class, id);
	}
	
	public void add(Invoice invoice) {
		getHibernateTemplate().save(invoice);
	}
	
	public void remove(long id) {
		getHibernateTemplate().delete(findbyId(id));
	}
	
	
	
}
