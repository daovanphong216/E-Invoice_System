package service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import dao.InvoiceDAO;
import dao.UserDAO;
import model.Invoice;
import model.User;

public class InvoiceServiceImp implements InvoiceService{
	
	@Autowired
	@Qualifier("invoiceDAO")
	InvoiceDAO invoiceDAO;
	
	
	@Autowired
	@Qualifier("userDAO")
	UserDAO userDao;

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




}
