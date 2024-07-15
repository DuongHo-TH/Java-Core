package fa.training.entities;

public class Helicopter extends Plane {
	private String Ranger;
	

	public Helicopter(String ranger) {
		Ranger = ranger;
	}

	public Helicopter() {
		super();
		Ranger = "";
	}

	public Helicopter(String plane_ID, String plane_Model, String cruise_Speed, int empty_Weight, int maxTakeoff_Weight,
			 String flymethod) {
		super(plane_ID, plane_Model, cruise_Speed, empty_Weight, maxTakeoff_Weight, flymethod);
		// TODO Auto-generated constructor stub
	}

	public String getRanger() {
		return Ranger;
	}

	public void setRanger(String ranger) {
		Ranger = ranger;
	}

	@Override
	public String showme() {
		
		return "Helicopter [Ranger=" + getRanger() + "]";
	}

	@Override
	public String FlyMethod() {
		
		return "Rotated Wing";
	}
}
