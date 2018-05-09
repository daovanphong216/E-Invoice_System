package model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;


@Entity(name="users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "name")
	private String name;
	
	public Set<Invoice> getInvoices() {
		return invoices;
	}
	
	public Set<Invoice> getInvoices(Date dateTime) {
		System.out.println(dateTime.toString());
		Set<Invoice> results = new HashSet<Invoice>(	0);
		for(Invoice i: this.getInvoices()) {
			System.out.println(i.getDateTime().toString());
			if(i.getDateTime().compareTo(dateTime)==0) {
				results.add(i);
			}
		}
		
		return results;
	}

	public void setInvoices(Set<Invoice> invoices) {
		this.invoices = invoices;
	}


	
	@Column(name = "limitedMoney")
	public double limitedMoney;

	public double getLimitedMoney() {
		return limitedMoney;
	}

	public void setLimitedMoney(double limitedMoney) {
		this.limitedMoney = limitedMoney;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@OneToMany(mappedBy="owner", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Invoice> invoices = new HashSet<Invoice>(	0);
		
	@ManyToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private Account account;
	
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "phoneNumber")
	private String phoneNumber;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
