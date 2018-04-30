package dao;

import java.util.List;

import model.Invoice;

public interface InvoiceDAO {
	
	public void create(Invoice invoice);
	public Invoice findbyId(long id);
	public void remove(long id);
	public List<Invoice> getAll();
	public void update(Invoice invoice);
}
