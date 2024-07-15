package fa.training.house;

import java.time.LocalDate;

public class LuxuryHouse extends House {
	private String ProjectName;
	private String Investor;
	private String View;

	public LuxuryHouse(String projectName, String investor, String view) {
		super();
		this.ProjectName = projectName;
		this.Investor = investor;
		this.View = view;
	}

	@Override
	public String toString() {
		return "LuxuryHouse [getProjectName()=" + getProjectName() + ", getInvestor()=" + getInvestor() + ", getView()="
				+ getView() + ", getType()=" + getType() + ", getHouseID()=" + getHouseID() + ", getSquare()="
				+ getSquare() + ", getDirection()=" + getDirection() + ", getStarDate()=" + getStarDate()
				+ ", getCompletionDate()=" + getCompletionDate() + ", getRightCertificate()=" + getRightCertificate()
				+ ", getPrice()=" + getPrice() + ", getActualPrice()=" + getActualPrice() + "]";
	}

	public LuxuryHouse() {
		super();
		this.ProjectName = "";
		this.Investor = "";
		;
		this.View = "";
	}

	public LuxuryHouse(int type, String houseID, double square, String direction, LocalDate starDate,
			LocalDate completionDate, String rightCertificate, double price, double actualPrice) {
		super(type, houseID, square, direction, starDate, completionDate, rightCertificate, price, actualPrice);

	}

	public String getProjectName() {
		return ProjectName;
	}

	public void setProjectName(String projectName) {
		ProjectName = projectName;
	}

	public String getInvestor() {
		return Investor;
	}

	public void setInvestor(String investor) {
		Investor = investor;
	}

	public String getView() {
		return View;
	}

	public void setView(String view) {
		View = view;
	}

	@Override
	public String showme() {

		return "LuxuryHouse [getProjectName()=" + getProjectName() + ", getInvestor()=" + getInvestor() + ", getView()="
				+ getView() + "]";
	}

}
