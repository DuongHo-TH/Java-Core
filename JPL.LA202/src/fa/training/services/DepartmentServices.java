package fa.training.services;

import java.io.FileWriter;
import java.util.List;
import java.util.Scanner;

import fa.training.entities.Department;
import fa.training.entities.Employee;

public class DepartmentServices {
	public static Department createDepar(Scanner sc) {
		Department depar = new Department();
		System.out.println("Nhập DepartName");
		depar.setDepartName(sc.nextLine());
		EmployeeServices.createEmployee(depar.getListofEmployee(), sc);
		return depar;
	}

	public static void selectDepar(List<Department> depar, Scanner sc) {
		System.out.println("Nhập Tên Phòng Ban Muốn Tìm Kiếm");
		String deparName = sc.nextLine();
		for (Department department : depar) {
			if (department.getDepartName().equalsIgnoreCase(deparName)) {
				for (Employee empDepar : department.getListofEmployee()) {
					System.out.println(empDepar.toString());
				}
			}
		}
	}

	public static void displayDepar(List<Department> depar) {
		for (Department department : depar) {
			System.out.println(department.getDepartName() + "Số Lượng Nhân Viên : " + department.getListofEmployee().size());
		}
	}
	public static void addEmploy(List<Department> depar, Scanner sc) {
		System.out.println("Nhập Tên Phòng Ban Muốn Thêm Nhân Viên");
		String departName = sc.nextLine();
		for (Department department : depar) {
			if(department.getDepartName().equalsIgnoreCase(departName)) {
				EmployeeServices.createEmployee(department.getListofEmployee(), sc);
			}else {
				System.out.println("Không Tìm Thấy Tên Phòng Ban Trong Danh Sách");
			}
		}
	}
	public static void showinfoEmployee(List<Department> depart) {
		for (Department department : depart) {
			EmployeeServices.showinfo(department.getListofEmployee());
		}
	}
	public static void phanloai(List<Department> dep) {
		for (Department department : dep) {
			EmployeeServices.classification(department.getListofEmployee());
		}
	}
	public static void insertFile(List<Department> list) {
		try (FileWriter Writer = new FileWriter("D://Data_CSV//department.txt")){
			for (Department department : list) {
				for (Employee department2 : department.getListofEmployee()) {
					Writer.write(department.showwriter() + "," + department2.showwriter());
				}
			}
		} catch (Exception e) {
			
		}
	}
}
