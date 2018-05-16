package service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import dao.InvoiceDAO;
import dao.InvoiceTypeDAO;
import dao.UserDAO;
import model.Invoice;
import model.InvoiceType;
import model.User;



public class InvoiceTypeServiceImp implements InvoiceTypeService {

	@Autowired
	@Qualifier("invoiceTypeDAO")
	InvoiceTypeDAO invoiceTypeDao;

	@Autowired
	@Qualifier("invoiceDAO")
	InvoiceDAO invoiceDao;
	
	
	@Autowired
	@Qualifier("userDAO")
	UserDAO userDao;
	
	@Override
	public InvoiceType create(InvoiceType type) {
		return this.invoiceTypeDao.create(type);

	}

	@Override
	public void update(InvoiceType type) {
		this.invoiceTypeDao.update(type);

	}

	@Override
	public List<InvoiceType> getAll() {
		return this.invoiceTypeDao.getAll();
	}

	@Override
	public List<InvoiceType> getAllType() {
		return this.invoiceTypeDao.getAll();
	}

	@Override
	public InvoiceType findbyId(long id) {
		return this.invoiceTypeDao.findbyId(id);
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
	public void deleteByName(String invoiceTypeName){
		List<InvoiceType> list = this.invoiceTypeDao.findbyInvoiceTypeName(invoiceTypeName);
		for (int i=0; i<list.size(); i++){
			list.get(i).setDeleteAble(true);
			invoiceTypeDao.update(list.get(i));
		}
	}

	@Override
	public InvoiceType createTypeByAdmin(String name, String file) {
		List<User> list = this.userDao.getAll();
		for(User user : list) {
			InvoiceType newtype = new InvoiceType();
			newtype.setLogo(file);
			newtype.setName(name);
			newtype.setOwner(user);
			newtype.setDeleteAble(false);
			this.invoiceTypeDao.create(newtype);
		}
		InvoiceType defaultType = new InvoiceType();
		defaultType.setName(name);
		defaultType.setLogo(file);
		return defaultType;
	}

	@Override
	public InvoiceType createTypeByMember(String name, String file, User user) {
		InvoiceType newtype = new InvoiceType();
		newtype.setLogo(file);
		newtype.setName(name);
		newtype.setOwner(user);
		newtype.setDeleteAble(true);
		return this.invoiceTypeDao.create(newtype);
		
	}

	@Override
	public InvoiceType findbyInvoiceTypeName(String invoiceTypeName, User user) {
		return this.invoiceTypeDao.findbyInvoiceTypeName(invoiceTypeName, user);
	}

	@Override
	public void DeleteInvoiceType(long invoiceTypeId, User user){
		InvoiceType it = invoiceTypeDao.findbyInvoiceId(invoiceTypeId, user);
		if (it!=null){
			//Set <InvoiceType> its = user.getTypes();
			//if (its.contains(it)){
				for(Invoice i : it.getInvoices()) {
					 invoiceDao.remove(i.getId());
				 }
				invoiceTypeDao.remove(invoiceTypeId);
			//}
		}
	}
	
	@Override
	public List<InvoiceType> getAll(User user){
		return this.invoiceTypeDao.getAll(user);
	}
}
