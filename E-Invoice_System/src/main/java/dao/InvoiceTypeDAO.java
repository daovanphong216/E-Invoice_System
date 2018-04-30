package dao;

import java.util.List;

import model.InvoiceType;

public interface InvoiceTypeDAO {
	
	public void create(InvoiceType invoiceType);
	public InvoiceType findbyId(long id);
	public void remove(long id);
	public List<InvoiceType> getAll();
	public void update(InvoiceType invoiceType);
}
