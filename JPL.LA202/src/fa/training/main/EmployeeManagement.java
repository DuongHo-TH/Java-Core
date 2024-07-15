package fa.training.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fa.training.entities.Department;
import fa.training.services.DepartmentServices;

public class EmployeeManagement {
	public static void main(String[] agrs) {
		Scanner sc = new Scanner(System.in);
		List<Department> depar = new ArrayList<Department>();
		int key;
		do {
			System.out.println("MENU");
			System.out.println("====== EMPLOYEE MANAGEMENT SYSTEM ======");
			System.out.println("1.	Add an employee");
			System.out.println("2.	Display employees");
			System.out.println("3.	Classify employees ");
			System.out.println("4.	Search book by (department, emp’s name)");
			System.out.println("4.	Search book by (emp's , department name)");
			System.out.println("6, 	Create Department");
			System.out.println("7,   Insert File ");
			System.out.println("8,    Kết Thúc Chương Trình");
			key = Integer.parseInt(sc.nextLine());
			switch (key) {
			case 1: {
				DepartmentServices.addEmploy(depar, sc);
				break;
			}
			case 2: {
				DepartmentServices.showinfoEmployee(depar);
				break;
			}
			case 3: {
				DepartmentServices.phanloai(depar);
				break;
			}
			case 4: {
				DepartmentServices.displayDepar(depar);
				break;
			}
			case 5: {
				DepartmentServices.selectDepar(depar, sc);
				break;
			}
			case 6: {
				depar.add(DepartmentServices.createDepar(sc));
				break;
			}case 7: {
				DepartmentServices.insertFile(depar);
				break;
			}
			}
		} while (key < 8);
	}
}
