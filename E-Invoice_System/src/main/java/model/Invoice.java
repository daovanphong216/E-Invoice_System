package model;

import org.springframework.beans.factory.annotation.Autowired;

public class Invoice {
	
	private long id;
	
	private long customerCode;
	
	private String description;
	
	private long typeId;
	
	private double amountOfMoney;
	
	private double VAT;
	
	private String invoiceNo;
	
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
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public long getTypeId() {
		return typeId;
	}
	
	public void setTypeId(long typeId) {
		this.typeId = typeId;
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
