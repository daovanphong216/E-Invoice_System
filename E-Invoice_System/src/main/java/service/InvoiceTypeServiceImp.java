package service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import dao.InvoiceTypeDAO;
import model.InvoiceType;



public class InvoiceTypeServiceImp implements InvoiceTypeService {

	@Autowired
	@Qualifier("invoiceTypeDAO")
	InvoiceTypeDAO InvoiceTypeDao;
	
	@Override
	public void create(InvoiceType type) {
		this.InvoiceTypeDao.create(type);

	}

	@Override
	public void update(InvoiceType type) {
		this.InvoiceTypeDao.update(type);

	}

	@Override
	public List<InvoiceType> getAll() {
		return this.InvoiceTypeDao.getAll();
	}

	@Override
	public List<InvoiceType> getAllType() {
		return this.InvoiceTypeDao.getAll();
	}

	@Override
	public InvoiceType findbyId(long id) {
		return this.InvoiceTypeDao.findbyId(id);
	}

	@Override
	public void create(String name, String logo) {
		InvoiceType newtype = new InvoiceType();
		newtype.setName(name);
		newtype.setLogo(logo);
		this.create(newtype);
		
	}

	@Override
	public Set<Object> getAlltypeInfor() {
		Set<Object> infors = new HashSet<Object>(0);
		for(InvoiceType type: this.getAll()) {
		}
		return infors;
	}
	
	@Override
	public InvoiceType findbyInvoiceTypeName(String invoiceTypeName){
		return this.InvoiceTypeDao.findbyInvoiceTypeName(invoiceTypeName);
	}

}
