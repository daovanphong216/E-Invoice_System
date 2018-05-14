package service;

import java.util.Date;
import java.util.List;
import java.util.Set;

import model.Invoice;
import model.User;

	public interface InvoiceService {
	public void saveOrUpdate(Invoice Invoice);
	
	
	public void createInvoice(String description, Date dateTime, double amountOfMoney, long customerCode, String invoiceNo, double VAT, User owner);
	public void Invoice (String description, Date dateTime, double amountOfMoney, long customerCode, String invoiceNo, double VAT, User owner);
	public Invoice MakeInvoice (String description, Date dateTime, double amountOfMoney, long customerCode, String invoiceNo, double VAT, User owner);
	public Invoice MakeInvoice (String description, Date dateTime, double amountOfMoney, long customerCode, String invoiceNo, double VAT, User owner, long typeId);

	public Set<Invoice> getAll();
	public Set<Invoice> getAllFromUser(User user);


	public void remove(long id, User user);


	public void createInvoice(String description, Date date, double money, long cCode, String invoiceNo, double vat,
			User currentuser, String type);
	
	public List<Invoice> Search(Date datemin, Date datemax, double moneyMin, double moneyMax, long cCode,
			String invoiceNo, long typeId, long ownerId, int firstResult, int maxResults);

}
