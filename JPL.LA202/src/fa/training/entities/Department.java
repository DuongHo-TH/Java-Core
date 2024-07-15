package fa.training.entities;

import java.util.ArrayList;
import java.util.List;

public class Department {
	private String DepartName;
	private List<Employee> listofEmployee;

	public String showwriter() {
		return  this.getDepartName() ;
	}

	@Override
	public String toString() {
		return "Department [getDepartName()=" + getDepartName() + ", getListofEmployee()=" + getListofEmployee() + "]";
	}

	public Department() {
		this.DepartName = "";
		this.listofEmployee = new ArrayList<Employee>();
	}

	public Department(String departName, List<Employee> listofEmployee) {
		super();
		DepartName = departName;
		this.listofEmployee = listofEmployee;
	}

	public String getDepartName() {
		return DepartName;
	}

	public void setDepartName(String departName) {
		DepartName = departName;
	}

	public List<Employee> getListofEmployee() {
		return listofEmployee;
	}

	public void setListofEmployee(List<Employee> listofEmployee) {
		this.listofEmployee = listofEmployee;
	}

}
