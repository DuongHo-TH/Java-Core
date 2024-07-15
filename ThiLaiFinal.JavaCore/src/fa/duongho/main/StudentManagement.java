package fa.duongho.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fa.duongho.entities.StudentClass;
import fa.duongho.entities.poorStudent;
import fa.duongho.entities.priorityStudent;
import fa.duongho.services.StudentClassServices;
import fa.duongho.services.StudentServices;




public class StudentManagement {
 public static void main(String[] args) {
	try {
		Scanner sc = new Scanner(System.in);
		List<poorStudent> lisofpoorStudent = new ArrayList<poorStudent>();
		List<priorityStudent> listofpriStudent = new ArrayList<priorityStudent>();
		List<StudentClass> listofStudentclass = new ArrayList<StudentClass>();
		int key;
		do {
		System.out.println("====================StudentManagement====================");
		System.out.println(" Chọn Các Chức Năng Trong Menu Theo Hướng Dẫn ");
		System.out.println("1, Input file StudentClass");
		System.out.println("2, Input file Poor_Student");
		System.out.println("3, Input file Prio_Student");
		System.out.println("4, INSERT List StudentClass");
		System.out.println("5, INSERT List PoorStudent");
		System.out.println("6, INSERT List PrioStudent");
		System.out.println("7, Kết Thúc Trương Trình");
		key = Integer.parseInt(sc.nextLine());
		switch (key) {
		case 1:{
			StudentClassServices.inputClassStudent(listofStudentclass);
			break;
		}case 2:{
			StudentServices.inputPoorStudent(lisofpoorStudent);
			break;
		}case 3:{
			StudentServices.inputPriorityStudent(listofpriStudent);
			for (priorityStudent studentClass : listofpriStudent) {
				System.out.println(studentClass.printMe());
			}
			break;
		}case 4:{
			StudentClassServices.insertStudentClass(listofStudentclass);
			break;
		}case 5:{
			StudentServices.insertPoorStudent(lisofpoorStudent);
			break;
		}case 6:{
			StudentServices.insertPriStudent(listofpriStudent);
			break;
		}
		
		}
		}while (key < 7);
	} catch (Exception e) {
		System.out.println("The application has encountered and unexpected error!!!");
	}
}
}
