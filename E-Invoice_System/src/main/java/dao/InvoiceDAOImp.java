package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import model.Invoice;


@Repository
public class InvoiceDAOImp implements InvoiceDAO{
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	@Override
	public void create(Invoice invoice) {
		Session session = getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.save(invoice);
		tx.commit();
		session.close();
		
	}
	
	@Override
	public Invoice findbyId(long id){
		Session session = getSessionFactory().openSession();
		Invoice user = (Invoice) session.get(Invoice.class, id);
		session.close();
		return user;
	}	
	
	@Override
	public void remove(long id) {
		Session session = getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		Invoice invoice = (Invoice) session.get(Invoice.class, id);
		session.delete(invoice);
		tx.commit();
		session.close();
	}
	
	@Override
	public void update(Invoice invoice) {
		Session session = getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(invoice);;
		tx.commit();
		session.close();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Invoice> getAll() {
		Session session = getSessionFactory().openSession();
        List<Invoice> list = session.createQuery("from invoices").list();
        session.close();
        return list;
	}
	
	
	
}
