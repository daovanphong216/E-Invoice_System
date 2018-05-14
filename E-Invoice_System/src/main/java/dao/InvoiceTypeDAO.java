package dao;

import java.util.List;

import model.InvoiceType;
import model.User;

public interface InvoiceTypeDAO {
	
	public void create(InvoiceType invoiceType);
	public InvoiceType findbyId(long id);
	public void remove(long id);
	public List<InvoiceType> getAll();
	public void update(InvoiceType invoiceType);
	public List<InvoiceType> getAll(User user);
	public InvoiceType findbyInvoiceTypeName(String invoiceTypeName);
}
