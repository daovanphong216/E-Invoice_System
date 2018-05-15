package service;

import java.util.Date;
import java.util.List;
import java.util.Set;

import model.Invoice;
import model.InvoiceType;
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
			String invoiceNo, InvoiceType type, User owner, int firstResult, int maxResults);
	
	
	public List<Invoice> SearchAllByDateTime(Date dateTime,
			InvoiceType type, User owner);


	public List<model.Invoice> Search(Date datemin, Date datemax, double moneyMin, double moneyMax, long cCode,
			String invoiceNo, User currentUser, int firstResult, int maxResults);

	
	public int count(Date datemin, Date datemax, double moneyMin, double moneyMax, long cCode,
			String invoiceNo, User currentUser);
	
	public int count(Date datemin, Date datemax, double moneyMin, double moneyMax, long cCode,
			String invoiceNo, InvoiceType type, User owner);



	public model.Invoice removeInvoice(long id, User user);


}
