package fa.training.entities;

public class Customer {
	private int customerID;
	private String customerName;

	@Override
	public String toString() {
		return "Customer [getCustomerID()=" + getCustomerID() + ", getCustomerName()=" + getCustomerName() + "]";
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Customer(int customerID, String customerName) {
		super();
		this.customerID = customerID;
		this.customerName = customerName;
	}

	public Customer() {
		this.customerID = 0;
		this.customerName = "";

	}

}
