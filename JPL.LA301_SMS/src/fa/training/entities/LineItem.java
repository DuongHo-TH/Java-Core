package fa.training.entities;

public class LineItem {
	private int orderID;
	private int productID;
	private int quantity;
	private double price;

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public LineItem(int orderID, int productID, int quantity, double price) {
		super();
		this.orderID = orderID;
		this.productID = productID;
		this.quantity = quantity;
		this.price = price;
	}

	public LineItem() {
		this.orderID = 0;
		this.productID = 0;
		this.quantity = 0;
		this.price = 0;
	}

}
