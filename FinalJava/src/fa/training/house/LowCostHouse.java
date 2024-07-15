package fa.training.house;

import java.time.LocalDate;

public class LowCostHouse extends House {
	private String TransferYear;

	public LowCostHouse(String transferYear) {
		super();
		this.TransferYear = transferYear;
	}

	public LowCostHouse() {
		super();
		this.TransferYear = "";
	}

	public LowCostHouse(int type, String houseID, double square, String direction, LocalDate starDate,
			LocalDate completionDate, String rightCertificate, double price, double actualPrice) {
		super(type, houseID, square, direction, starDate, completionDate, rightCertificate, price, actualPrice);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "LowCostHouse [getTransferYear()=" + getTransferYear() + ", getType()=" + getType() + ", getHouseID()="
				+ getHouseID() + ", getSquare()=" + getSquare() + ", getDirection()=" + getDirection()
				+ ", getStarDate()=" + getStarDate() + ", getCompletionDate()=" + getCompletionDate()
				+ ", getRightCertificate()=" + getRightCertificate() + ", getPrice()=" + getPrice()
				+ ", getActualPrice()=" + getActualPrice() + "]";
	}

	public String getTransferYear() {
		return TransferYear;
	}

	public void setTransferYear(String transferYear) {
		TransferYear = transferYear;
	}

	@Override
	public String showme() {
		// TODO Auto-generated method stub
		return "LowCostHouse [getTransferYear()=" + getTransferYear() + "]";
	}

}
