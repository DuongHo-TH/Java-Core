package fa.training.entities;

import java.util.ArrayList;
import java.util.List;



public class Airports {
	private String Airports_ID;
	private String Airports_Name;
	private int Runway_Size;
	private int MaxFixedwingParkingPlace;
	private List<Fixedwing> listofFixedwingID;
	private int MaxRotatedwingParkingPlace;
	private List<Helicopter> listofHelicopterID;

	@Override
	public String toString() {
		return "Airports [Airports_ID : " + getAirports_ID() + ", Airports_Name : " + getAirports_Name()
				+ ", Runway_Size :" + getRunway_Size() + ", MaxFixedwingParkingPlace : "
				+ getMaxFixedwingParkingPlace() + ", ListofFixedwingID : " + getListofFixedwingID()
				+ ", MaxRotatedwingParkingPlace : " + getMaxRotatedwingParkingPlace() + ", ListofHelicopterID :"
				+ getListofHelicopterID() + "]";
	}

	public Airports() {
		super();
		this.Airports_ID = "";
		this.Airports_Name = "";
		this.Runway_Size = 0;
		this.MaxFixedwingParkingPlace = 0;
		this.listofFixedwingID = new ArrayList<Fixedwing>();
		this.MaxRotatedwingParkingPlace = 0;
		this.listofHelicopterID = new ArrayList<Helicopter>();

	}

	public Airports(String airports_ID, String airports_Name, int runway_Size, int maxFixedwingParkingPlace,
			List<Fixedwing> listofFixedwingID, int maxRotatedwingParkingPlace, List<Helicopter> listofHelicopterID) {
		super();
		this.Airports_ID = airports_ID;
		this.Airports_Name = airports_Name;
		this.Runway_Size = runway_Size;
		this.MaxFixedwingParkingPlace = maxFixedwingParkingPlace;
		this.listofFixedwingID = listofFixedwingID;
		this.MaxRotatedwingParkingPlace = maxRotatedwingParkingPlace;
		this.listofHelicopterID = listofHelicopterID;
	}

	public String getAirports_ID() {
		return Airports_ID;
	}

	public void setAirports_ID(String airports_ID) {
		Airports_ID = airports_ID;
	}

	public String getAirports_Name() {
		return Airports_Name;
	}

	public void setAirports_Name(String airports_Name) {
		Airports_Name = airports_Name;
	}

	public int getRunway_Size() {
		return Runway_Size;
	}

	public void setRunway_Size(int runway_Size) {
		Runway_Size = runway_Size;
	}

	public int getMaxFixedwingParkingPlace() {
		return MaxFixedwingParkingPlace;
	}

	public void setMaxFixedwingParkingPlace(int maxFixedwingParkingPlace) {
		MaxFixedwingParkingPlace = maxFixedwingParkingPlace;
	}

	public List<Fixedwing> getListofFixedwingID() {
		return listofFixedwingID;
	}

	public void setListofFixedwingID(List<Fixedwing> listofFixedwingID) {
		this.listofFixedwingID = listofFixedwingID;
	}

	public int getMaxRotatedwingParkingPlace() {
		return MaxRotatedwingParkingPlace;
	}

	public void setMaxRotatedwingParkingPlace(int maxRotatedwingParkingPlace) {
		MaxRotatedwingParkingPlace = maxRotatedwingParkingPlace;
	}

	public List<Helicopter> getListofHelicopterID() {
		return listofHelicopterID;
	}

	public void setListofHelicopterID(List<Helicopter> listofHelicopterID) {
		this.listofHelicopterID = listofHelicopterID;
	}
}
