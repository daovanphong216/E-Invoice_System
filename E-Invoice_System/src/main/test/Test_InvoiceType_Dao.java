import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import model.InvoiceType;
import model.User;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import dao.InvoiceTypeDAO;
import dao.UserDAO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/dispatcher-servlet.xml")
public class Test_InvoiceType_Dao {
	@Autowired
	@Qualifier("invoiceTypeDAO")
	InvoiceTypeDAO invoiceTypeDao;	
	
	
	@Autowired
	@Qualifier("userDAO")
	UserDAO userDao;
	
	@BeforeClass
    public static void setUp() {
        System.out.println("-----> SETUP <-----");
    }
	
	@Test
    public void b_testGetInvoiceType(){
        try{
        List<InvoiceType> invoiceTypes = invoiceTypeDao.getAll();
        Assert.assertNotNull(invoiceTypes);
        
        System.out.println("List invoiceType with size: " + invoiceTypes.size());
        }
        catch(Exception e){
            e.printStackTrace();
            Assert.fail();
        }
	}
	
	
	
	
	
	@Test
    public void a_testCreateInvoiceType(){
        try{
        	User user= userDao.findbyUserName("admin");
        	InvoiceType newInvoiceType = new InvoiceType();
        	newInvoiceType.setInvoices(null);
    		newInvoiceType.setLogo(null);
    		newInvoiceType.setName("testType");
    		newInvoiceType.setOwner(user);
    		newInvoiceType.setDeleteAble(false);
    		this.invoiceTypeDao.create(newInvoiceType);
    		
    		InvoiceType invoiceType = invoiceTypeDao.findbyInvoiceTypeName("testType").get(0); 		
    		Assert.assertNotNull(newInvoiceType);
        }
        catch(Exception e){
            e.printStackTrace();
            Assert.fail();
        }
	}
	
	
	@Test
    public void c_testUpdateInvoiceType(){
        try{
        	InvoiceType invoiceType = invoiceTypeDao.findbyInvoiceTypeName("testType").get(0); 	
        	invoiceType.setDeleteAble(true);
        	invoiceTypeDao.update(invoiceType);
        	
            invoiceType = invoiceTypeDao.findbyInvoiceTypeName("testType").get(0); 
        	Assert.assertEquals(invoiceType.isDeleteAble(),true);
        }
        catch(Exception e){
            e.printStackTrace();
            Assert.fail();
        }
	}
	
	@Test
    public void d_deleteInvoiceType(){
        try{
              
        	InvoiceType invoiceType = invoiceTypeDao.findbyInvoiceTypeName("testType").get(0); 	
        	invoiceTypeDao.remove(invoiceType.getId());
        	
            List<InvoiceType> invoiceTypes = invoiceTypeDao.findbyInvoiceTypeName("testType"); 
        	Assert.assertNull(invoiceTypes);
        	
        }
        catch(Exception e){
            e.printStackTrace();
            Assert.fail();
        }
	}
}
