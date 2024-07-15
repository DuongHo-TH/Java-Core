package fa.training.house;

import java.time.LocalDate;

public abstract class House {
	private int type;
	private String HouseID;
	private double Square;
	private String Direction;
	private LocalDate StarDate;
	private LocalDate CompletionDate;
	private String RightCertificate;
	private double Price;
	private double ActualPrice;

	public abstract String showme();

	@Override
	public String toString() {
		return "House [Type = " + getType() + ", getHouseID()=" + getHouseID() + ", getSquare()=" + getSquare()
				+ ", getDirection()=" + getDirection() + ", getStarDate()=" + getStarDate() + ", getCompletionDate()="
				+ getCompletionDate() + ", getRightCertificate()=" + getRightCertificate() + ", getPrice()="
				+ getPrice() + ", getActualPrice()=" + getActualPrice() + showme() + "]";
	}

	public House() {
		this.type = 0;
		this.HouseID = "";
		this.Square = 0;
		this.Direction = "";
		this.StarDate = null;
		this.CompletionDate = null;
		this.RightCertificate = "";
		this.Price = 0;
		this.ActualPrice = 0;
	}

	public House(int type, String houseID, double square, String direction, LocalDate starDate,
			LocalDate completionDate, String rightCertificate, double price, double actualPrice) {
		this.type = type;
		this.HouseID = houseID;
		this.Square = square;
		this.Direction = direction;
		this.StarDate = starDate;
		this.CompletionDate = completionDate;
		this.RightCertificate = rightCertificate;
		this.Price = price;
		this.ActualPrice = actualPrice;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getHouseID() {
		return HouseID;
	}

	public void setHouseID(String houseID) {
		HouseID = houseID;
	}

	public double getSquare() {
		return Square;
	}

	public void setSquare(double square) {
		Square = square;
	}

	public String getDirection() {
		return Direction;
	}

	public void setDirection(String direction) {
		Direction = direction;
	}

	public LocalDate getStarDate() {
		return StarDate;
	}

	public void setStarDate(LocalDate starDate) {
		StarDate = starDate;
	}

	public LocalDate getCompletionDate() {
		return CompletionDate;
	}

	public void setCompletionDate(LocalDate completionDate) {
		CompletionDate = completionDate;
	}

	public String getRightCertificate() {
		return RightCertificate;
	}

	public void setRightCertificate(String rightCertificate) {
		RightCertificate = rightCertificate;
	}

	public double getPrice() {
		return Price;
	}

	public void setPrice(double price) {
		Price = price;
	}

	public double getActualPrice() {
		return ActualPrice;
	}

	public void setActualPrice(double actualPrice) {
		ActualPrice = actualPrice;
	}

}
