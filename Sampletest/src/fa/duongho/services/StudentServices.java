package fa.duongho.services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import fa.duongho.entities.GoodStudent;
import fa.duongho.entities.NormalStudent;
import fa.duongho.entities.Student;
import fa.duongho.validator.InvalidDOBException;
import fa.duongho.validator.InvalidFullNameException;
import fa.duongho.validator.InvalidPhoneNumberException;




public class StudentServices {
	public static void inputGoodStudent(List<Student> listStudent) {
	String input =  "‪D:/Data_CSV/SinhVienGioi.csv";
	try (BufferedReader goodStudent = new BufferedReader(new FileReader(input))) {
		String Student1;
		while ((Student1 = goodStudent.readLine()) != null) {
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
				objectStudent.setPhoneNumber(arrStudent[3]);
			} catch (InvalidPhoneNumberException e) {
				System.out.println(e.getMessage());
			}

			objectStudent.setUniversityName(arrStudent[4]);
			objectStudent.setGradeLevel(arrStudent[5]);
			objectStudent.setGpa(Float.parseFloat(arrStudent[6]));
			objectStudent.setBestRewardName(arrStudent[7]);
			listStudent.add(objectStudent);
		}

	} catch (Exception e) {
		System.out.println("Input files have unknow errors !!!");
	}
} 
	public static void inputNormalStudent() {
		String input = "";
		try(BufferedReader normalStudent = new BufferedReader(new FileReader(input))) {
			String student;
			while((student = normalStudent.readLine()) != null) {
				String [] arrStudent = student.split(",");
				NormalStudent objectStudent = new NormalStudent();
				try {
					InvalidFullNameException.validateFullName(arrStudent[0]);
					objectStudent.setFullName(arrStudent[0]);
				} catch (InvalidFullNameException e) {
					System.out.println("Tên Không Đúng Định Dạng" + arrStudent[0]);
				}
			}
			
		} catch (Exception e) {
			System.out.println("Input files have unknow errors !!!");
		}
	}
}
