package fa.training.entities;

import java.time.LocalDate;

public class HourlyEmployee extends Employee {
	private double rate;
	private double workingHours;

	public HourlyEmployee(double rate, double workingHours) {
		super();
		this.rate = rate;
		this.workingHours = workingHours;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public double getWorkingHours() {
		return workingHours;
	}

	public void setWorkingHours(double workingHours) {
		this.workingHours = workingHours;
	}

	public HourlyEmployee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HourlyEmployee(String ssn, String firstName, String lastName, LocalDate birthDate, String phone,
			String email) {
		super(ssn, firstName, lastName, birthDate, phone, email);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String showme() {
		return "HourlyEmployee [getRate()=" + getRate() + ", getWorkingHours()=" + getWorkingHours() + "]";
	}

	@Override
	public String toString() {
		return "HourlyEmployee [getRate()=" + getRate() + ", getWorkingHours()=" + getWorkingHours()
				+ ", getFirstName()=" + getFirstName() + ", getLastName()=" + getLastName() + ", getBirthDate()="
				+ getBirthDate() + ", getPhone()=" + getPhone() + ", getEmail()=" + getEmail() + "]";
	}

	@Override
	public String showwriter() {
		return getRate() + "," + getWorkingHours()+ "," + getFirstName() + "," + getLastName() + ","
				+ getBirthDate() + "," + getPhone() + "," + getEmail() ;
	}

}
