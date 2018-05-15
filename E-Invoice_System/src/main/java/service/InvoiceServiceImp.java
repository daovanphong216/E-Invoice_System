package service;

import java.util.Date;
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

public class InvoiceServiceImp implements InvoiceService{
	
	@Autowired
	@Qualifier("invoiceDAO")
	InvoiceDAO invoiceDAO;
	
	
	@Autowired
	@Qualifier("userDAO")
	UserDAO userDao;

	@Autowired
	@Qualifier("invoiceTypeDAO")
	InvoiceTypeDAO InvoiceTypeDao;
	
	@Override
	public void saveOrUpdate(Invoice Invoice) {
		
		
	}

	@Override
	public Set<Invoice> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createInvoice(String description, Date dateTime, double amountOfMoney, long customerCode,
			String invoiceNo, double VAT, User owner) {
		
		Invoice newInvoice = new Invoice();
		newInvoice.setDescription(description);
		newInvoice.setAmountOfMoney(amountOfMoney);
		newInvoice.setDateTime(dateTime);
		newInvoice.setInvoiceNo(invoiceNo);
		newInvoice.setCustomerCode(customerCode);
		newInvoice.setVAT(VAT);
		newInvoice.setOwner(owner);
		this.invoiceDAO.create(newInvoice);
		
	}

	@Override
	public Set<Invoice> getAllFromUser(User user) {
		return user.getInvoices();
	}

	@Override
	public void remove(long id, User user) {
		Invoice invoice = this.invoiceDAO.findbyId(id);
		user.getInvoices().remove(invoice);
		this.userDao.update(user);
		this.invoiceDAO.remove(id, user);
		
	}

	@Override
	public void Invoice(String description, Date dateTime, double amountOfMoney, long customerCode, String invoiceNo,
			double VAT, User owner) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Invoice MakeInvoice(String description, Date dateTime, double amountOfMoney, long customerCode,
			String invoiceNo, double VAT, User owner) {
		Invoice newInvoice = new Invoice();
		newInvoice.setDescription(description);
		newInvoice.setAmountOfMoney(amountOfMoney);
		newInvoice.setDateTime(dateTime);
		newInvoice.setInvoiceNo(invoiceNo);
		newInvoice.setCustomerCode(customerCode);
		newInvoice.setVAT(VAT);
		newInvoice.setOwner(owner);
		this.invoiceDAO.create(newInvoice);
		return newInvoice;
	}

	@Override
	public void createInvoice(String description, Date date, double money, long cCode, String invoiceNo, double vat,
			User currentuser, String type) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Invoice MakeInvoice(String description, Date dateTime, double amountOfMoney, long customerCode,
			String invoiceNo, double VAT, User owner, long typeId) {
		Invoice newInvoice = new Invoice();
		newInvoice.setDescription(description);
		newInvoice.setAmountOfMoney(amountOfMoney);
		newInvoice.setDateTime(dateTime);
		newInvoice.setInvoiceNo(invoiceNo);
		newInvoice.setCustomerCode(customerCode);
		newInvoice.setVAT(VAT);
		newInvoice.setOwner(owner);
		
		InvoiceType type = this.InvoiceTypeDao.findbyId(typeId);
		newInvoice.setType(type);
		this.invoiceDAO.create(newInvoice);
		return newInvoice;
	}

	@Override
	public List<Invoice> Search(Date datemin, Date datemax, double moneyMin, double moneyMax, long cCode,
			String invoiceNo, InvoiceType type, User owner, int firstResult, int maxResults) {
		return this.invoiceDAO.search(datemin, datemax, moneyMin, moneyMax, cCode, invoiceNo, type, owner, firstResult, maxResults);
	}

	@Override
	public List<model.Invoice> SearchAllByDateTime(Date dateTime, InvoiceType type, User owner) {
		return this.invoiceDAO.SearchAllByDateTime(dateTime, type, owner);
	}

	@Override
	public List<model.Invoice> Search(Date datemin, Date datemax, double moneyMin, double moneyMax, long cCode,
			String invoiceNo, User currentUser, int firstResult, int maxResults) {
		return this.invoiceDAO.search(datemin, datemax, moneyMin, moneyMax, cCode, invoiceNo, currentUser, firstResult, maxResults);
	}

	@Override
	public int count(Date datemin, Date datemax, double moneyMin, double moneyMax, long cCode,
			String invoiceNo, User currentUser){
		return this.invoiceDAO.count(datemin, datemax, moneyMin, moneyMax, cCode, invoiceNo, currentUser);
	}

	@Override
	public int count(Date datemin, Date datemax, double moneyMin, double moneyMax, long cCode,
			String invoiceNo, InvoiceType type, User owner){
		return this.invoiceDAO.count(datemin, datemax, moneyMin, moneyMax, cCode, invoiceNo, type, owner);
	}
}
