package fa.duongho.services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import fa.duongho.entities.StudentClass;
import fa.duongho.main.ConnectionStudent;

public class StudentClassServices {
	public static void inputClassStudent(List<StudentClass> listStudent) {
		String input = "D:/Data_CSV/Class.csv";
		try (BufferedReader Studentclass = new BufferedReader(new FileReader(input))) {
			String Class;
			while ((Class = Studentclass.readLine()) != null) {
				String[] arrClass = Class.split(",");
				StudentClass stclass = new StudentClass();
				stclass.setId(arrClass[0]);
				stclass.setName(arrClass[1]);
				stclass.setDepartment(arrClass[2]);
				stclass.setPoorstudent(arrClass[3]);
				stclass.setPrioritystudent(arrClass[4]);
				listStudent.add(stclass);
			}	
           for (StudentClass student : listStudent) {
			System.out.println(student.toString());
		}
		} catch (Exception e) {
			System.out.println(e.getMessage() + "Input files have unknow errors !!!");
		}
	}
	public static void insertStudentClass(List<StudentClass> listStudent) {
		String sql = "INSERT INTO ClassStudent(ClassID, Class_Name, Department, Poor_Student, Priority_Student) VALUES (?, ?, ?, ?, ?)";
		int i = 0;
		try (Connection conn = ConnectionStudent.connectDB(); PreparedStatement stm = conn.prepareStatement(sql)) {
			for (StudentClass student : listStudent) {
				
					stm.setString(1, student.getId());
					stm.setObject(2, student.getName());
					stm.setString(3, student.getDepartment());
					stm.setString(4, student.getPoorstudent());
					stm.setString(5, student.getPrioritystudent());
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
