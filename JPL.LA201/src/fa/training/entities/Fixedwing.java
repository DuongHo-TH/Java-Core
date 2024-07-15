package fa.training.entities;

public class Fixedwing extends Plane {
	private String Plane_Type;
	private int MinNeeded_RunwaySize;
	private String Fly_Type;

	public String FlyMethod() {
		return "fixed wing";
	}

	public Fixedwing(String plane_Type, int minNeeded_RunwaySize, String flyMethod) {
		super();
		Plane_Type = plane_Type;
		MinNeeded_RunwaySize = minNeeded_RunwaySize;

	}

	public Fixedwing() {
		super();
		Plane_Type = "";
		MinNeeded_RunwaySize = 0;

	}

	public Fixedwing(String plane_ID, String plane_Model, String cruise_Speed, int empty_Weight, int maxTakeoff_Weight,
			String flymethod) {
		super(plane_ID, plane_Model, cruise_Speed, empty_Weight, maxTakeoff_Weight, flymethod);
		// TODO Auto-generated constructor stub
	}

	public String getPlane_Type() {
		return Plane_Type;
	}

	public void setPlane_Type(String plane_Type) {
		Plane_Type = plane_Type;
	}

	public int getMinNeeded_RunwaySize() {
		return MinNeeded_RunwaySize;
	}

	public void setMinNeeded_RunwaySize(int minNeeded_RunwaySize) {
		MinNeeded_RunwaySize = minNeeded_RunwaySize;
	}

	public String getFly_Type() {
		return Fly_Type;
	}

	public void setFly_Type(String fly_Type) {
		Fly_Type = fly_Type;
	}

	@Override
	public String showme() {
 
		return "Fixedwing [Plane_Type = " + getPlane_Type() + ", MinNeeded_RunwaySize = " + getMinNeeded_RunwaySize()
				+ "FlyMethod()=" + FlyMethod()  + "]";
	}

	@Override
	public String toString() {
		return "Fixedwing [FlyMethod()=" + FlyMethod() + ", getPlane_Type()=" + getPlane_Type()
				+ ", getMinNeeded_RunwaySize()=" + getMinNeeded_RunwaySize() + ", getFly_Type()=" + getFly_Type() + "]";
	}

}
