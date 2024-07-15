package General_Assignment_BTJB_opt2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class baiTap12 {
	public static void main(String[] args) {
		List<SinhVienBai12> listofSV = new ArrayList<SinhVienBai12>();
		try (BufferedReader reader = new BufferedReader(new FileReader("D:/Data_CSV/ex_Employee.csv"));
				FileWriter errorWriter = new FileWriter("D:/Data_CSV/erro.txt")) {
			String line;
			int i = 0;
			while ((line = reader.readLine()) != null) {
				i++;
				String[] studentInfo = line.split(",");
				String email = studentInfo[3]; // Cột chứa email
				String phoneNumber = studentInfo[2]; // Cột chứa số điện thoại
				if ( isValidPhoneNumber(phoneNumber)) {
					if(isValidEmail(email)) {
						
						
						SinhVienBai12 sv = new SinhVienBai12();
						sv.setMaSV(studentInfo[0]);
						sv.setTenSV(studentInfo[1]);
						sv.setSDT(studentInfo[2]);
						sv.setEmail(studentInfo[3]);
						sv.setDiem(Integer.parseInt(studentInfo[4]));
						listofSV.add(sv);
						}else {
							errorWriter.write("Lỗi dòng " + i + " Sai định dạng email \n");
						}
				}else if(isValidEmail(email)) {
					errorWriter.write("Lỗi dòng " + i + " Sai định dạng phone \n");
				}	else {
					errorWriter.write("Lỗi dòng " + i + " Sai Định dạng phone, email \n" );
					
				}

			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (SinhVienBai12 sinhVien : listofSV) {
			System.out.println(sinhVien.toString());
			
		}System.out.println("Tổn Số Sinh Viên Trong Danh Sách " + listofSV.size() );
	}
	
	public static boolean isValidEmail(String email) {
		// Biểu thức chính quy kiểm tra định dạng email
		String emailPattern = "^[A-Za-z0-9+_.-]+@(.+)$";
		return email.matches(emailPattern);
	}

	public static boolean isValidPhoneNumber(String phoneNumber) {
		// Biểu thức chính quy kiểm tra định dạng số điện thoại
		String phonePattern = "^(\\+\\d{1,3})?\\d{9,15}$";
		return phoneNumber.matches(phonePattern);
	}
}
