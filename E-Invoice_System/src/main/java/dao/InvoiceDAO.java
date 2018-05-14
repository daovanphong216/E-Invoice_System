package dao;

import java.util.Date;
import java.util.List;

import model.Invoice;
import model.User;

public interface InvoiceDAO {
	
	public void create(Invoice invoice);
	public Invoice findbyId(long id);
	public void remove(long id, User user);
	public List<Invoice> getAll();
	public void update(Invoice invoice);
	
	public List<Invoice> search(Date datemin, Date datemax, double moneyMin, double moneyMax, long cCode,
			String invoiceNo, long typeId, long ownerId, int firstResult, int maxResults);
	
}
