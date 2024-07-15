package fa.training.entities;

import java.time.LocalDate;

public class Order {
	private int orderID;
	private LocalDate date;
	private int customerID;
	private int employeeID;
	private double total;

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Order(int orderID, LocalDate date, int customerID, int employeeID, double total) {
		super();
		this.orderID = orderID;
		this.date = date;
		this.customerID = customerID;
		this.employeeID = employeeID;
		this.total = total;
	}

	public Order() {
		this.orderID = 0;
		this.date = null;
		this.customerID = 0;
		this.employeeID = 0;
		this.total = 0;
	}
}
