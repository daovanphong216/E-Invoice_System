package model;

public class TypeReport {
	private String name;
	private int noOfInvoice;
	private double totalMonney;
	
	public TypeReport(String name, int noOfInvoice, double totalMonney) {
		super();
		this.name = name;
		this.noOfInvoice = noOfInvoice;
		this.totalMonney = totalMonney;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNoOfInvoice() {
		return noOfInvoice;
	}
	public void setNoOfInvoice(int noOfInvoice) {
		this.noOfInvoice = noOfInvoice;
	}
	public double getTotalMonney() {
		return totalMonney;
	}
	public void setTotalMonney(double totalMonney) {
		this.totalMonney = totalMonney;
	}
}
