package dao;

import java.util.Date;
import java.util.List;

import model.Invoice;
import model.InvoiceType;
import model.User;

public interface InvoiceDAO {
	
	public void create(Invoice invoice);
	public Invoice findbyId(long id);
	public void remove(long id, User user);
	public List<Invoice> getAll();
	public void update(Invoice invoice);
	
	public List<Invoice> search(Date datemin, Date datemax, double moneyMin, double moneyMax, long cCode,
			String invoiceNo, InvoiceType type, User owner, int firstResult, int maxResults);
	public List<Invoice> SearchAllByDateTime(Date dateTime, InvoiceType type, User owner);
	public List<Invoice> search(Date datemin, Date datemax, double moneyMin, double moneyMax, long cCode,
			String invoiceNo, User currentUser, int firstResult, int maxResults);
	public int count(Date datemin, Date datemax, double moneyMin, double moneyMax, long cCode,
			String invoiceNo, User currentUser);
	public int count(Date datemin, Date datemax, double moneyMin, double moneyMax, long cCode,
			String invoiceNo, InvoiceType type, User owner);
	
}
