package fa.training.dao;

import java.util.Scanner;

import fa.training.entities.Employee;

public class EmployeeSevices  {
public static Employee CreateEmployee(Scanner sc) {
	Employee emp = new Employee();
	System.out.println("Nhập EmployeeID");
	emp.setEmployeeID(Integer.parseInt(sc.nextLine()));
	System.out.println("Nhập EmployeeName");
	emp.setEmployeeName(sc.nextLine());
	System.out.println("Nhập Salary");
	emp.setSalary(Double.parseDouble(sc.nextLine()));
	System.out.println("Nhập Spvrld");
	emp.setSpvrld(Integer.parseInt(sc.nextLine()));
	return emp;
}

}
