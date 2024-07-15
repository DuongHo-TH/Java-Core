package fa.training.services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import fa.training.entities.GoodStudent;
import fa.training.entities.NormalStudent;
import fa.training.entities.Student;
import fa.training.utils.InvalidDOBException;
import fa.training.utils.InvalidFullNameException;
import fa.training.utils.InvalidPhoneNumberException;

public class StudentServices {
	public static void inputGoodStudent(List<Student> listStudent) {
		String input = "D:/Data_CSV/SinhVienGioi.csv";
		try (BufferedReader goodStudent = new BufferedReader(new FileReader(input))) {
			String Student1;
			while ((Student1 = goodStudent.readLine()) != null) {
				System.out.println(Student1);
				String[] arrStudent = Student1.split(",");
				GoodStudent objectStudent = new GoodStudent();
				try {
					InvalidFullNameException.validateFullName(arrStudent[0]);
					objectStudent.setFullName(arrStudent[0]);
				} catch (InvalidFullNameException e) {
					System.out.println("Lỗi" + e.getMessage());
				}
				try {
					InvalidDOBException.valdidateDOB(arrStudent[1]);
					DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					objectStudent.setDoB(LocalDate.parse(arrStudent[1], formatDate));
				} catch (InvalidDOBException e) {
					System.out.println("Lỗi Định Dạng" + e.getMessage());
				}
				objectStudent.setSex(arrStudent[2]);
				try {
					InvalidPhoneNumberException.validatePhoneNumber(arrStudent[3]);
					objectStudent.setPhoneNumber("0" + arrStudent[3]);
				} catch (InvalidPhoneNumberException e) {
					System.out.println(e.getMessage());
				}

				objectStudent.setUniversityName(arrStudent[4]);
				objectStudent.setGradeLevel(arrStudent[5]);
				objectStudent.setGpa(Double.parseDouble(arrStudent[6]));
				objectStudent.setBestRewardName(arrStudent[7]);
				listStudent.add(objectStudent);
			}
           for (Student student : listStudent) {
			System.out.println(student.ShowMyInfor());
		}
		} catch (Exception e) {
			System.out.println(e.getMessage() + "Input files have unknow errors !!!");
		}
	}

	public static void inputNormalStudent(List<Student> liststudent) {
		String input = "D:/Data_CSV/SinhVienKha.csv";
		try (BufferedReader normalStudent = new BufferedReader(new FileReader(input))) {
			String Student1;
			while ((Student1 = normalStudent.readLine()) != null) {
				String[] arrStudent = Student1.split(",");
				NormalStudent objectStudent = new NormalStudent();
				try {
					InvalidFullNameException.validateFullName(arrStudent[0]);
					objectStudent.setFullName(arrStudent[0]);
				} catch (InvalidFullNameException e) {
					System.out.println("Lỗi" + e.getMessage());
				}
				String inputdate = arrStudent[1];
				try {
					DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					objectStudent.setDoB(LocalDate.parse(inputdate, formatDate));
				} catch (Exception e) {
					System.out.println("Thoi Gian Khong Dung Dinh Dang");
				}
				objectStudent.setSex(arrStudent[2]);
				try {
					InvalidPhoneNumberException.validatePhoneNumber(arrStudent[3]);
					objectStudent.setPhoneNumber("0" + arrStudent[3]);
				} catch (InvalidPhoneNumberException e) {
					System.out.println(e.getMessage());
				}
				objectStudent.setUniversityName(arrStudent[4]);
				objectStudent.setGradeLevel(arrStudent[5]);
				objectStudent.setEnglishScore(Double.parseDouble(arrStudent[6]));
				objectStudent.setEntryTestScore(Double.parseDouble(arrStudent[7]));
				liststudent.add(objectStudent);
			}
		} catch (Exception e) {
			System.out.println("Input files have unknow errors !!!");
		}
	}

	public static void insertStudent(List<Student> listStudent) {
		String sql = "INSERT INTO Student([Full_Name]\r\n"
				+ "      ,[Birtday]\r\n"
				+ "      ,[Sex]\r\n"
				+ "      ,[Phone]\r\n"
				+ "      ,[UniversityName]\r\n"
				+ "      ,[gradelLevel]\r\n"
				+ "      ,[GPA]\r\n"
				+ "      ,[bestRewardName]\r\n"
				+ "      ,[englishScore]\r\n"
				+ "      ,[entryTestScore]) \r \n"
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		int i = 0;
		try (Connection conn = ConnectStudent.connectDB(); PreparedStatement stm = conn.prepareStatement(sql)) {
			for (Student student : listStudent) {
				if (student instanceof GoodStudent) {
					stm.setString(1, student.getFullName());
					stm.setObject(2, student.getDoB());
					stm.setString(3, student.getSex());
					stm.setString(4, student.getPhoneNumber());
					stm.setString(5, student.getUniversityName());
					stm.setString(6, student.getGradeLevel());
					stm.setDouble(7, ((GoodStudent) student).getGpa());
					stm.setString(8, ((GoodStudent) student).getBestRewardName());
					stm.setString(9, null);
					stm.setString(10, null);
					i = stm.executeUpdate();
				}
				if (student instanceof NormalStudent) {
					stm.setString(1, student.getFullName());
					stm.setObject(2, student.getDoB());
					stm.setString(3, student.getSex());
					stm.setString(4, student.getPhoneNumber());
					stm.setString(5, student.getUniversityName());
					stm.setString(6, student.getGradeLevel());
					stm.setString(7, null);
					stm.setString(8, null);			
					stm.setDouble(9, ((NormalStudent) student).getEnglishScore());
					stm.setDouble(10, ((NormalStudent) student).getEntryTestScore());
					i = stm.executeUpdate();
				}
			}
			if (i > 0) {
				System.out.println("Insert Database Thanh Cong");
			}
		} catch (SQLException e) {
			System.out.println("Insert Database That Bai");
		}
	}

}
