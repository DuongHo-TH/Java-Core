package fa.training.entities;

public class Employee {
	private int employeeID;
	private String employeeName;
	private double salary;
	private int spvrID;

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public int getSpvrID() {
		return spvrID;
	}

	public void setSpvrld(int spvrld) {
		this.spvrID = spvrld;
	}

	public Employee(int employeeID, String employeeName, double salary, int spvrld) {
		super();
		this.employeeID = employeeID;
		this.employeeName = employeeName;
		this.salary = salary;
		this.spvrID = spvrld;
	}

	public Employee() {
		this.employeeID = 0;
		this.employeeName = "";
		this.salary = 0;
		this.spvrID = 0;
	}

}
