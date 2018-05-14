package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity(name="invoices")
public class Invoice {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
		
	@ManyToOne(fetch = FetchType.EAGER)
	@PrimaryKeyJoinColumn
	private User owner;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@PrimaryKeyJoinColumn
	private InvoiceType type;
	
//	public InvoiceType getType() {
//		return type;
//	}

	public void setType(InvoiceType type) {
		this.type = type;
	}

	@Column(name = "customerCode")
	private long customerCode;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "dateTime")
	private Date dateTime;
	
	
	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	@Column(name = "amountOfMoney")
	private double amountOfMoney;
	
	@Column(name = "VAT")
	private double VAT;
	
	@Column(name = "invoiceNo")
	private String invoiceNo;
	
	/**
	 * @return
	 */
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public long getCustomerCode() {
		return customerCode;
	}
	
	public void setCustomerCode(long customerCode) {
		this.customerCode = customerCode;
	}
	
//	public User getOwner() {
//		return owner;
//	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	public double getAmountOfMoney() {
		return amountOfMoney;
	}
	
	public void setAmountOfMoney(double amountOfMoney) {
		this.amountOfMoney = amountOfMoney;
	}
	
	public double getVAT() {
		return VAT;
	}
	
	public void setVAT(double vAT) {
		VAT = vAT;
	}
	
	public String getInvoiceNo() {
		return invoiceNo;
	}
	
	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}
	
}
