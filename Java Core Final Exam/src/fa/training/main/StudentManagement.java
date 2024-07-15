package fa.training.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fa.training.entities.Student;
import fa.training.services.StudentDao;
import fa.training.services.StudentServices;

public class StudentManagement {
public static void main(String[] agrs) {
	Scanner sc = new Scanner(System.in);
	List<Student> lisofStudent = new ArrayList<Student>();
	int key;
	do {
	System.out.println("====================StudentManagement====================");
	System.out.println(" Chọn Các Chức Năng Trong Menu Theo Hướng Dẫn ");
	System.out.println("1, Input file GoodStudent");
	System.out.println("2, Input file NormalStudent");
	System.out.println("3, ShowInfo List Student");
	System.out.println("4, INSERT List Student vào DATABASE SQL sever");
	System.out.println("5, Show FullName và PhoneNumber tất cả Student");
	System.out.println("6, Hiển Thị Danh Sách Student Trúng Tuyển");
	System.out.println("7, Kết Thúc Trương Trình");
	key = Integer.parseInt(sc.nextLine());
	switch (key) {
	case 1:{
		StudentServices.inputGoodStudent(lisofStudent);
		break;
	}case 2:{
		StudentServices.inputNormalStudent(lisofStudent);
		break;
	}case 3:{
		StudentDao.showlistStudent(lisofStudent);
		break;
	}case 4:{
		StudentServices.insertStudent(lisofStudent);
		break;
	}case 5:{
		StudentDao.selectStudent();
		break;
	}case 6:{
		StudentDao.displayTT(sc);
		break;
	}
	
	}
	}while (key < 7);
}
}
