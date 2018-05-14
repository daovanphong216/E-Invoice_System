package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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

@Entity(name="invoicetypes")
public class InvoiceType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "logo", columnDefinition="ntext")
	private String logo;
	
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
	
	public String getLogo() {
		return logo;
	}
	
	public void setLogo(String logo) {
		this.logo = logo;
	}	
	
	public List<Invoice> getInvoices() {
		return invoices;
	}

	public void setInvoices(List<Invoice> invoices) {
		this.invoices = invoices;
	}

	@OneToMany(mappedBy="type", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Invoice> invoices = new ArrayList<Invoice>(	0);
	
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@PrimaryKeyJoinColumn
	private User owner;

	public void setOwner(User owner) {
		this.owner = owner;
	}
	
	public boolean isDeleteAble() {
		return isDeleteAble;
	}

	public void setDeleteAble(boolean isDeleteAble) {
		this.isDeleteAble = isDeleteAble;
	}
	
	@Column(name = "isDeleteAble")
	private boolean isDeleteAble;
}
