package fa.training.house;

import java.time.LocalDate;

public class Apartment extends House {
	private int Floor;
	private String View;

	public Apartment(int floor, String view) {
		super();
		this.Floor = floor;
		this.View = view;
	}

	public Apartment() {
		super();
		this.Floor = 0;
		this.View = "";
	}

	public Apartment(int type, String houseID, double square, String direction, LocalDate starDate,
			LocalDate completionDate, String rightCertificate, double price, double actualPrice) {
		super(type, houseID, square, direction, starDate, completionDate, rightCertificate, price, actualPrice);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Apartment [getFloor()=" + getFloor() + ", getView()=" + getView() + ", getType()=" + getType()
				+ ", getHouseID()=" + getHouseID() + ", getSquare()=" + getSquare() + ", getDirection()="
				+ getDirection() + ", getStarDate()=" + getStarDate() + ", getCompletionDate()=" + getCompletionDate()
				+ ", getRightCertificate()=" + getRightCertificate() + ", getPrice()=" + getPrice()
				+ ", getActualPrice()=" + getActualPrice() + "]";
	}

	public int getFloor() {
		return Floor;
	}

	public void setFloor(int floor) {
		Floor = floor;
	}

	public String getView() {
		return View;
	}

	public void setView(String view) {
		View = view;
	}

	@Override
	public String showme() {
		// TODO Auto-generated method stub
		return "Apartment [getFloor()=" + getFloor() + ", getView()=" + getView() + "]";
	}

}
