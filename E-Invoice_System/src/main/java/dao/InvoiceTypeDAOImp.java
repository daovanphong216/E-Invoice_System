package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import model.InvoiceType;


@Repository
public class InvoiceTypeDAOImp implements InvoiceTypeDAO{
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	@Override
	public void create(InvoiceType invoiceType) {
		Session session = getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.save(invoiceType);;
		tx.commit();
		session.close();
		
	}
	
	@Override
	public InvoiceType findbyId(long id){
		Session session = getSessionFactory().openSession();
		InvoiceType user = (InvoiceType) session.get(InvoiceType.class, id);
		session.close();
		return user;
	}	
	
	@Override
	public void remove(long id) {
		Session session = getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		InvoiceType invoiceType = (InvoiceType) session.get(InvoiceType.class, id);
		session.delete(invoiceType);
		tx.commit();
		session.close();
	}
	
	@Override
	public void update(InvoiceType invoiceType) {
		Session session = getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(invoiceType);;
		tx.commit();
		session.close();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<InvoiceType> getAll() {
		Session session = getSessionFactory().openSession();
        List<InvoiceType> list = session.createQuery("from InvoiceType").list();
        session.close();
        return list;
	}
	
}
