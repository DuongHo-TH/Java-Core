package fa.training.entities;

public class Product {
	private int productID;
	private String productName;
	private double listPrice;

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getListPrice() {
		return listPrice;
	}

	public void setListPrice(double listPrice) {
		this.listPrice = listPrice;
	}

	public Product(int productID, String productName, double listPrice) {
		super();
		this.productID = productID;
		this.productName = productName;
		this.listPrice = listPrice;
	}

	public Product() {
		this.productID = 0;
		this.productName = "";
		this.listPrice = 0;
	}
}
