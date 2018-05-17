import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import model.Invoice;
import model.User;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import dao.InvoiceDAO;
import dao.UserDAO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/dispatcher-servlet.xml")
public class Test_Invoice_Dao {
	@Autowired
	@Qualifier("invoiceDAO")
	InvoiceDAO invoiceDao;	
	
	
	@Autowired
	@Qualifier("userDAO")
	UserDAO userDao;
	
	@BeforeClass
    public static void setUp() {
        System.out.println("-----> SETUP <-----");
    }
	
	@Test
    public void b_testGetInvoice(){
        try{
        List<Invoice> invoices = invoiceDao.getAll();
        Assert.assertNotNull(invoices);
        
        System.out.println("List invoice with size: " + invoices.size());
        }
        catch(Exception e){
            e.printStackTrace();
            Assert.fail();
        }
	}
	
	
	
	
	
	@Test
    public void a_testCreateInvoice(){
        try{
        	Invoice newInvoice = new Invoice();
    		newInvoice.setDescription("description");
    		newInvoice.setAmountOfMoney(1000);
    		newInvoice.setDateTime(new Date());
    		newInvoice.setInvoiceNo("1000");
    		newInvoice.setCustomerCode(1000);
    		newInvoice.setVAT(10);
    		User user= userDao.findbyUserName("admin");
    		newInvoice.setOwner(user);
    		this.invoiceDao.create(newInvoice);
        Assert.assertNotNull(newInvoice);
        }
        catch(Exception e){
            e.printStackTrace();
            Assert.fail();
        }
	}
	
	

	@Test
    public void c_testUpdateInvoice(){
        try{
        	User user= userDao.findbyUserName("admin");
        	Set<Invoice> invoices = user.getInvoices();
        	
        	Iterator iter = invoices.iterator();

        	Object first = iter.next();
        
        	Invoice invoice = (Invoice) first;
        	invoice.setDescription("hihi");
        
        	invoiceDao.update(invoice);
        
        	
        	user= userDao.findbyUserName("admin");
        	invoices = user.getInvoices();
        	
        	iter = invoices.iterator();

        	first = iter.next();
        
        	invoice = (Invoice) first;
        	Assert.assertEquals(invoice.getDescription(),"hihi");
        }
        catch(Exception e){
            e.printStackTrace();
            Assert.fail();
        }
	}
	
	@Test
    public void d_deleteInvoice(){
        try{
              
        	User user= userDao.findbyUserName("admin");
        	Set<Invoice> invoices = user.getInvoices();
        	
        	Iterator iter = invoices.iterator();

        	Object first = iter.next();
        
        	Invoice invoice = (Invoice) first;
        	invoiceDao.remove(invoice.getId());
        	
        	user= userDao.findbyUserName("admin");
        	invoices = user.getInvoices();
        	Assert.assertEquals(invoices.size(),0);
        	
        }
        catch(Exception e){
            e.printStackTrace();
            Assert.fail();
        }
	}
	
}
