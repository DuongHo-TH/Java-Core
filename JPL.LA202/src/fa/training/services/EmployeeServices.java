package fa.training.services;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fa.training.entities.Employee;
import fa.training.entities.HourlyEmployee;
import fa.training.entities.SalariedEmplpyee;

public class EmployeeServices {
	public static void createEmployee(List<Employee> listofEmploy, Scanner sc) {
		do {
			System.out.println("Chọn Nhân Viên Muốn Thêm Vào Danh Sách");
			System.out.println("1, SalariedEmployee || 2, HourlyEmployee ");
			int key = Integer.parseInt(sc.nextLine());
			switch (key) {
			case 1: { SalariedEmplpyee empSalar = new SalariedEmplpyee();
			System.out.println("Nhập SSN Nhân Viên");
			empSalar.setSsn(sc.nextLine());
			System.out.println("Nhập firstName ");
			empSalar.setFirstName(sc.nextLine());
			System.out.println("Nhập lastName ");
			empSalar.setLastName(sc.nextLine());
			System.out.println("Nhập birthDate");
			try {String inputDate = sc.nextLine();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
				LocalDate localDate = LocalDate.parse(inputDate, formatter);
				empSalar.setBirthDate(localDate);
			} catch (Exception e) {
				System.out.println("BirthDate không hợp lệ");
			}
			System.out.println("Nhập Phone");
			empSalar.setPhone(sc.nextLine());
			System.out.println("Nhập Email");
			empSalar.setEmail(sc.nextLine());
			System.out.println("Nhập commissionRate ");
			empSalar.setCommissionRate(Integer.parseInt(sc.nextLine()));
			System.out.println("Nhập grossSales ");
			empSalar.setGrossSales(Integer.parseInt(sc.nextLine()));
			System.out.println("Nhập basicSalary");
			empSalar.setBasicSalary(Integer.parseInt(sc.nextLine()));
			listofEmploy.add(empSalar);
             break;
			}
			case 2: {HourlyEmployee empSalar = new HourlyEmployee();
			System.out.println("Nhập SSN Nhân Viên");
			empSalar.setSsn(sc.nextLine());
			System.out.println("Nhập firstName ");
			empSalar.setFirstName(sc.nextLine());
			System.out.println("Nhập lastName ");
			empSalar.setLastName(sc.nextLine());
			System.out.println("Nhập birthDate");
			try {String inputDate = sc.nextLine();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
				LocalDate localDate = LocalDate.parse(inputDate, formatter);
				empSalar.setBirthDate(localDate);
			} catch (Exception e) {
				System.out.println("BirthDate không hợp lệ");
			}
			System.out.println("Nhập Phone");
			empSalar.setPhone(sc.nextLine());
			System.out.println("Nhập Email");
			empSalar.setEmail(sc.nextLine());
			System.out.println("Nhập rate ");
			empSalar.setRate(Integer.parseInt(sc.nextLine()));
			System.out.println("Nhập grossSales ");
			empSalar.setWorkingHours(Integer.parseInt(sc.nextLine()));
			listofEmploy.add(empSalar);
				break;
			}

			}
			 System.out.println("Bạn Có Muốn Nhập Thêm Employee. Chọn Y/N");
             String next = sc.nextLine();
             if(next.equalsIgnoreCase("n")) {
				break;
             }
		} while (true);
	}
	public static void showinfo(List<Employee> list) {
		for (Employee employee : list) {
			System.out.println(employee.toString());
		}
	}
	public static void selectEmp(List<Employee> list, String name) {
		
		for (Employee employee : list) {
			if(employee.getFirstName().equalsIgnoreCase(name)) {
			System.out.println(employee.toString());
			}
		}
	}
	public static void classification(List<Employee> emplist) {
		List<SalariedEmplpyee> listsala = new ArrayList<SalariedEmplpyee>();
		List<HourlyEmployee> listhou = new ArrayList<HourlyEmployee>();
		for (Employee employee : emplist) {
			if(employee instanceof SalariedEmplpyee) {
				listsala.add((SalariedEmplpyee)employee);
			}else {
				listhou.add((HourlyEmployee)employee);
			}
		}
		for (HourlyEmployee hourlyEmployee : listhou) {
			System.out.println(hourlyEmployee.toString());
		}
		for (SalariedEmplpyee salaEmployee : listsala) {
			System.out.println(salaEmployee.toString());
		}
	}
}
