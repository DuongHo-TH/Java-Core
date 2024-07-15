package fa.training.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import fa.training.entities.GoodStudent;
import fa.training.entities.NormalStudent;
import fa.training.entities.Student;

public class StudentDao {
	public static void selectStudent() {
		List<Student> listofStudent = new ArrayList<Student>();
		String sql = "SELECT Full_Name, Phone FROM Student";
		try (Connection conn = ConnectStudent.connectDB(); Statement st = conn.createStatement()) {
			ResultSet student = st.executeQuery(sql);
			while (student.next()) {
					Student good = new GoodStudent();
					good.setFullName(student.getString(1));
					good.setPhoneNumber(student.getString(2));
					listofStudent.add(good);
			}
		} catch (SQLException e) {
			System.out.println("Input files have unknow errors !!!");
		}
		Collections.sort(listofStudent,
				Comparator.comparing(Student::getFullName).reversed().thenComparing(Student::getPhoneNumber));
		for (Student student : listofStudent) {
			System.out.println("FullName : " + student.getFullName() + " " + "SĐT : " + student.getPhoneNumber());
		}
	}

	public static void showlistStudent(List<Student> list) {
		for (Student student : list) {
			System.out.println(student.toString());
		}
	}
	public static void displayTT(Scanner sc) {
		List<Student> listtrungtuyen = new ArrayList<Student>();
		System.out.println("Nhập Số Lượng Nhân Viên Cần Tuyển Dụng");
		int slnv = Integer.parseInt(sc.nextLine());
		String sql = "SELECT * FROM Student WHERE gradelLevel  = 'Kha' or gradelLevel = 'Gioi' ORDER BY GPA DESC, Full_Name ASC";
		try (Connection conn = ConnectStudent.connectDB(); PreparedStatement prs = conn.prepareStatement(sql);){
			ResultSet student = prs.executeQuery();
			while(student.next()) {
				GoodStudent nv = new GoodStudent();
				nv.setFullName(student.getString(1));
				String dob = student.getString(2);
				DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				nv.setDoB(LocalDate.parse(dob, formatDate));
				nv.setSex(student.getString(3));
				nv.setPhoneNumber(student.getString(4));
				nv.setUniversityName(student.getString(5));
				nv.setGradeLevel(student.getString(6));
				nv.setGpa(student.getInt(7));
				nv.setBestRewardName(student.getString(8));
				listtrungtuyen.add(nv);
			}
		} catch (SQLException e) {
			System.out.println("Input files have unknow errors !!!");
		}
		if(slnv > listtrungtuyen.size()) {
			String sql1 = "SELECT [Full_Name], [Birtday], [Sex], [Phone], [UniversityName], [gradelLevel], [englishScore], [entryTestScore]"
					+ " FROM Student WHERE gradelLevel = 'TrungBinhKha' or gradelLevel = 'TrungBinh' ORDER BY entryTestScore DESC, englishScore DESC ";
			try (Connection conn = ConnectStudent.connectDB(); PreparedStatement prs = conn.prepareStatement(sql1);){
				ResultSet student = prs.executeQuery();
				while(student.next()) {
					NormalStudent nv = new NormalStudent();
					nv.setFullName(student.getString(1));
					String dob = student.getString(2);
					DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
					nv.setDoB(LocalDate.parse(dob, formatDate));
					nv.setSex(student.getString(3));
					nv.setPhoneNumber(student.getString(4));
					nv.setUniversityName(student.getString(5));
					nv.setGradeLevel(student.getString(6));
					nv.setEnglishScore(student.getDouble(7));
					nv.setEntryTestScore(student.getDouble(8));
					listtrungtuyen.add(nv);
				}
			} catch (SQLException e) {
				System.out.println("Input files have unknow errors !!!");
			}
			
		}
		for(int i = 0 ; i < slnv ; i ++) {
			System.out.println(listtrungtuyen.get(i).toString());
		}
		
	}
	
}
