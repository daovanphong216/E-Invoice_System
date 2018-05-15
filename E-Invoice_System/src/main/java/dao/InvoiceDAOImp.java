package dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import model.Invoice;
import model.InvoiceType;
import model.User;


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
	public void remove(long id, User user) {
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

	@Override
	public List<Invoice> search(Date datemin, Date datemax, double moneyMin, double moneyMax, long cCode,
			String invoiceNo, InvoiceType type, User owner, int firstResult, int maxResults) {
		
		
		Session session = getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		Criteria query = session.createCriteria(Invoice.class);
		query.add(Restrictions.between("dateTime", datemin, datemax));
		query.add(Restrictions.between("amountOfMoney", moneyMin, moneyMax));
		query.add(Restrictions.eqOrIsNull("type", type));
		query.add(Restrictions.ilike("invoiceNo", invoiceNo, MatchMode.ANYWHERE));
		query.add(Restrictions.eq("customerCode", cCode));
		query.add(Restrictions.eq("owner", owner));
		query.setFirstResult(firstResult);
		query.setMaxResults(maxResults);
		
		@SuppressWarnings("unchecked")
		List<Invoice> results = query.list();
		
		tx.commit();
		session.close();
		
		return results;
		
	}

	@Override
	public List<Invoice> SearchAllByDateTime(Date dateTime, InvoiceType type, User owner) {
		Session session = getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		Criteria query = session.createCriteria(Invoice.class);
		query.add(Restrictions.eq("dateTime", dateTime));
		query.add(Restrictions.eqOrIsNull("type", type));
		query.add(Restrictions.eq("owner", owner));
		
		@SuppressWarnings("unchecked")
		List<Invoice> results = query.list();
		
		tx.commit();
		session.close();
		
		return results;
	}

	@Override
	public List<Invoice> search(Date datemin, Date datemax, double moneyMin, double moneyMax, long cCode,
			String invoiceNo, User currentUser, int firstResult, int maxResults) {
		Session session = getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		Criteria query = session.createCriteria(Invoice.class);
		query.add(Restrictions.between("dateTime", datemin, datemax));
		query.add(Restrictions.between("amountOfMoney", moneyMin, moneyMax));
		if(!invoiceNo.equals("none"))
			query.add(Restrictions.ilike("invoiceNo", invoiceNo, MatchMode.ANYWHERE));
		query.add(Restrictions.eq("owner", currentUser));
		query.setFirstResult(firstResult);
		query.setMaxResults(maxResults);
		if (cCode!=-999999)
			query.add(Restrictions.eq("customerCode", cCode));
		@SuppressWarnings("unchecked")
		List<Invoice> results = query.list();
		
		tx.commit();
		session.close();
		
		return results;
	}
	
	
	
}
