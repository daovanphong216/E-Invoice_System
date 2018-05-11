package service;

import java.util.List;
import java.util.Set;

import model.InvoiceType;

public interface InvoiceTypeService {
	public void create(InvoiceType type);
	public void update(InvoiceType type);
	public List<InvoiceType> getAll();
	public List<InvoiceType> getAllType();
	public InvoiceType findbyId(long id);
	public void create(String name, byte[]logo);
	public Set<Object> getAlltypeInfor();

}
