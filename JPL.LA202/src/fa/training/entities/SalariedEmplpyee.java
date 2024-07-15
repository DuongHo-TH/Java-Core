package fa.training.entities;

import java.time.LocalDate;

public class SalariedEmplpyee extends Employee {
	private double commissionRate;
	private double grossSales;
	private double basicSalary;

	public SalariedEmplpyee(double commissionRate, double grossSales, double basicSalary) {
		super();
		this.commissionRate = commissionRate;
		this.grossSales = grossSales;
		this.basicSalary = basicSalary;
	}

	public double getCommissionRate() {
		return commissionRate;
	}

	public void setCommissionRate(double commissionRate) {
		this.commissionRate = commissionRate;
	}

	public double getGrossSales() {
		return grossSales;
	}

	public void setGrossSales(double grossSales) {
		this.grossSales = grossSales;
	}

	public double getBasicSalary() {
		return basicSalary;
	}

	public void setBasicSalary(double basicSalary) {
		this.basicSalary = basicSalary;
	}

	public SalariedEmplpyee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SalariedEmplpyee(String ssn, String firstName, String lastName, LocalDate birthDate, String phone,
			String email) {
		super(ssn, firstName, lastName, birthDate, phone, email);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "SalariedEmplpyee [getCommissionRate()=" + getCommissionRate() + ", getGrossSales()=" + getGrossSales()
				+ ", getBasicSalary()=" + getBasicSalary() + ", getFirstName()=" + getFirstName() + ", getLastName()="
				+ getLastName() + ", getBirthDate()=" + getBirthDate() + ", getPhone()=" + getPhone() + ", getEmail()="
				+ getEmail() + "]";
	}

	@Override
	public String showme() {
		return "SalariedEmplpyee [getCommissionRate()=" + getCommissionRate() + ", getGrossSales()=" + getGrossSales()
				+ ", getBasicSalary()=" + getBasicSalary() + "]";
	}

	@Override
	public String showwriter() {
		
		return  this.getCommissionRate() + ", " + this.getGrossSales()
		+ ", " + this.getBasicSalary()+ "," + getFirstName() + "," + getLastName() + ","
				+ getBirthDate() + "," + getPhone() + "," + getEmail() ;
	}

}
