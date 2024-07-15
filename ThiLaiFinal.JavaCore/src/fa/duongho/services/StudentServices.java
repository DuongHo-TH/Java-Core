package fa.duongho.services;

import java.io.BufferedReader;
import java.io.FileReader;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import fa.duongho.entities.Student;

import fa.duongho.entities.poorStudent;
import fa.duongho.entities.priorityStudent;
import fa.duongho.main.ConnectionStudent;
import fa.duongho.utils.IDInvalidFormatException;
import fa.duongho.utils.InputMismatchException;


public class StudentServices {
	public static void inputPoorStudent(List<poorStudent> listStudent) {
		String input = "D:/Data_CSV/poor_Student.csv";
		try (BufferedReader Studentclass = new BufferedReader(new FileReader(input))) {
			String student;
			while ((student = Studentclass.readLine()) != null) {
				String[] arrClass = student.split(",");
				poorStudent poorstudent = new poorStudent();
				try {
					IDInvalidFormatException.validateID(arrClass[0]);
					poorstudent.setStudentid(arrClass[0]);
				} catch (IDInvalidFormatException e) {
					System.out.println(e.getMessage());
				}
				
				poorstudent.setStudentname(arrClass[1]);
				poorstudent.setSex(arrClass[2]);
				
				try {
					InputMismatchException.valdidateDOB(arrClass[3]);
					DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					poorstudent.setBirtday(LocalDate.parse(arrClass[3], formatDate));
				} catch (InputMismatchException e) {
					System.out.println("Lỗi Định Dạng" + e.getMessage());
				}
				poorstudent.setEmail(arrClass[4]);
				try {
					InputMismatchException.validatePhoneNumber(arrClass[5]);
					poorstudent.setPhone("0"+arrClass[5]);
				} catch (InputMismatchException e) {
					System.out.println(e.getMessage());
				}
				
				poorstudent.setGraduate(arrClass[6]);
				poorstudent.setExammark(Float.parseFloat(arrClass[7]));
				poorstudent.setDepartment(arrClass[8]);
				poorstudent.setFamilylevel(arrClass[9]);
				poorstudent.setMonthlyincome(Float.parseFloat(arrClass[10]));
				poorstudent.setClassid(null);
			
				listStudent.add(poorstudent);
			}	
           for (Student poorstudent : listStudent) {
			System.out.println(poorstudent.toString());
		}
		} catch (Exception e) {
			System.out.println(e.getMessage() + "Input files have unknow errors !!!");
		}
	}
	public static void inputPriorityStudent(List<priorityStudent> listpriStudent) {
		String input = "D:/Data_CSV/priority_Student.csv";
		try (BufferedReader Studentclass = new BufferedReader(new FileReader(input))) {
			String studen;
			while ((studen = Studentclass.readLine()) != null) {
				String[] arrClass = studen.split(",");
				priorityStudent poorstudent = new priorityStudent();
				try {
					IDInvalidFormatException.validateID(arrClass[0]);
					poorstudent.setStudentid(arrClass[0]);
				} catch (IDInvalidFormatException e) {
					System.out.println(e.getMessage());
				}
				poorstudent.setStudentname(arrClass[1]);
				poorstudent.setSex(arrClass[2]);
				try {
					InputMismatchException.valdidateDOB(arrClass[3]);
					DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					poorstudent.setBirtday(LocalDate.parse(arrClass[3], formatDate));
				} catch (InputMismatchException e) {
					System.out.println("Lỗi Định Dạng" + e.getMessage());
				}
				poorstudent.setEmail(arrClass[4]);
				try {
					InputMismatchException.validatePhoneNumber(arrClass[5]);
					poorstudent.setPhone("0"+arrClass[5]);
				} catch (InputMismatchException e) {
					System.out.println(e.getMessage());
				}
				poorstudent.setGraduate(arrClass[6]);
				poorstudent.setExammark(Float.parseFloat(arrClass[7]));
				poorstudent.setDepartment(arrClass[8]);
				poorstudent.setPrioritytype(arrClass[9]);
				poorstudent.setInjuretype(arrClass[10]);
				poorstudent.setClassid(null);
				listpriStudent.add(poorstudent);
			}	
		} catch (Exception e) {
			System.out.println(e.getMessage() + "Input files have unknow errors !!!");
		}
	}
	public static void insertPoorStudent(List<poorStudent> listStudent) {
		String sql = "INSERT INTO Student([Student_ID]\r\n"
				+ "      ,[Student_Name]\r\n"
				+ "      ,[Sex]\r\n"
				+ "      ,[BirthDay]\r\n"
				+ "      ,[Email]\r\n"
				+ "      ,[Phone]\r\n"
				+ "      ,[Graduate]\r\n"
				+ "      ,[Exam_Mark]\r\n"
				+ "      ,[Department]\r\n"
				+ "      ,[Family_level]\r\n"
				+ "      ,[Monthly]\r\n"
				+ "      ,[Priority_type]\r\n"
				+ "      ,[Injure]\r\n"
				+ "      ,[ClassID]) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		int i = 0;
		try (Connection conn = ConnectionStudent.connectDB(); PreparedStatement stm = conn.prepareStatement(sql)) {
			for (poorStudent student : listStudent) {
				
					stm.setString(1, student.getStudentid());
					stm.setString(2, student.getStudentname());
					stm.setString(3, student.getSex());
					stm.setObject(4, student.getBirtday());
					stm.setString(5, student.getEmail());
					stm.setString(6, student.getPhone());
					stm.setString(7, student.getGraduate());
					stm.setFloat(8, student.getExammark());
					stm.setString(9, student.getDepartment());
					stm.setString(10, student.getFamilylevel());
					stm.setFloat(11, student.getMonthlyincome());
					stm.setString(12, null);
					stm.setString(13, null);
					stm.setString(14, null);
					i = stm.executeUpdate();
			
			
			}
			if (i > 0) {
				System.out.println("Insert Database Thanh Cong");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage()+"Insert Database That Bai");
		}
	}
	public static void insertPriStudent(List<priorityStudent> listStudent) {
		String sql = "INSERT INTO Student([Student_ID]\r\n"
				+ "      ,[Student_Name]\r\n"
				+ "      ,[Sex]\r\n"
				+ "      ,[BirthDay]\r\n"
				+ "      ,[Email]\r\n"
				+ "      ,[Phone]\r\n"
				+ "      ,[Graduate]\r\n"
				+ "      ,[Exam_Mark]\r\n"
				+ "      ,[Department]\r\n"
				+ "      ,[Family_level]\r\n"
				+ "      ,[Monthly]\r\n"
				+ "      ,[Priority_type]\r\n"
				+ "      ,[Injure]\r\n"
				+ "      ,[ClassID]) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		int i = 0;
		try (Connection conn = ConnectionStudent.connectDB(); PreparedStatement stm = conn.prepareStatement(sql)) {
			for (priorityStudent student : listStudent) {
				
					stm.setString(1, student.getStudentid());
					stm.setString(2, student.getStudentname());
					stm.setString(3, student.getSex());
					stm.setObject(4, student.getBirtday());
					stm.setString(5, student.getEmail());
					stm.setString(6, student.getPhone());
					stm.setString(7, student.getGraduate());
					stm.setFloat(8, student.getExammark());
					stm.setString(9, student.getDepartment());
					stm.setString(10, null);
					stm.setString(11, null);
					stm.setString(12, student.getPrioritytype());
					stm.setString(13, student.getInjuretype());
					stm.setString(14, null);
					i = stm.executeUpdate();
			}
			if (i > 0) {
				System.out.println("Insert Database Thanh Cong");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage()+"Insert Database That Bai");
		}
	}
	
	
}
