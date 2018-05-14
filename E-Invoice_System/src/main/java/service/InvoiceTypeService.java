package service;

import java.util.List;
import java.util.Set;

import model.InvoiceType;
import model.User;

public interface InvoiceTypeService {
	public void create(InvoiceType type);
	public void update(InvoiceType type);
	public List<InvoiceType> getAll();
	public List<InvoiceType> getAllType();
	public InvoiceType findbyId(long id);
	public void create(String name, String logo);
	public Set<Object> getAlltypeInfor();
	public void createTypeByAdmin(String name, String file);
	public void createTypeByMember(String name, String file, User user);

}
