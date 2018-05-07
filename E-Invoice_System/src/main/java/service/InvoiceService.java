package service;

import java.util.Date;
import java.util.Set;

import model.Invoice;
import model.User;

	public interface InvoiceService {
	public void saveOrUpdate(Invoice Invoice);
	
	
	public void createInvoice(String description, Date dateTime, double amountOfMoney, long customerCode, String invoiceNo, double VAT, User owner);
	
	public Set<Invoice> getAll();
	public Set<Invoice> getAllFromUser(User user);

}
