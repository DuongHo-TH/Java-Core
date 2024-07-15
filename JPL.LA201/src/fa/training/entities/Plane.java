package fa.training.entities;

interface Flying{
	String FlyMethod();
}
public abstract  class Plane implements Flying {
	private String Plane_ID;
	private String Plane_Model;
	private String Cruise_Speed;
	private int Empty_Weight;
	private int MaxTakeoff_Weight;
	
	
	
	public abstract String showme();
	
	public Plane() {
		this.Plane_ID = "";
		this.Plane_Model = "";
		this.Cruise_Speed = "";
		this.Empty_Weight = 0;
		this.MaxTakeoff_Weight = 0;
		
	}
	public Plane(String plane_ID, String plane_Model, String cruise_Speed, int empty_Weight, int maxTakeoff_Weight,
			 String flymethod) {
		
		this.Plane_ID = plane_ID;
		this.Plane_Model = plane_Model;
		this.Cruise_Speed = cruise_Speed;
		this.Empty_Weight = empty_Weight;
		this.MaxTakeoff_Weight = maxTakeoff_Weight;
		
	}
	@Override
	public String toString() {
		return "Plane [Plane_ID=" + getPlane_ID() + ", Plane_Model=" + getPlane_Model()
				+ ", Cruise_Speed=" + getCruise_Speed() + ", Empty_Weight=" + getEmpty_Weight()
				+ ", MaxTakeoff_Weight=" + getMaxTakeoff_Weight() + FlyMethod() + showme() +"]";
	}
	public String getPlane_ID() {
		return Plane_ID;
	}
	public void setPlane_ID(String plane_ID) {
		Plane_ID = plane_ID;
	}
	public String getPlane_Model() {
		return Plane_Model;
	}
	public void setPlane_Model(String plane_Model) {
		Plane_Model = plane_Model;
	}
	public String getCruise_Speed() {
		return Cruise_Speed;
	}
	public void setCruise_Speed(String cruise_Speed) {
		Cruise_Speed = cruise_Speed;
	}
	public int getEmpty_Weight() {
		return Empty_Weight;
	}
	public void setEmpty_Weight(int empty_Weight) {
		Empty_Weight = empty_Weight;
	}
	public int getMaxTakeoff_Weight() {
		return MaxTakeoff_Weight;
	}
	public void setMaxTakeoff_Weight(int maxTakeoff_Weight) {
		MaxTakeoff_Weight = maxTakeoff_Weight;
	}

	
	
	
}
