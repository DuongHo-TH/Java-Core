package qluvFPT;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CandidateServices {
	Scanner sc = new Scanner(System.in);
	List<Candidate> listCandidate = new ArrayList<Candidate>();

	public CandidateServices(List<Candidate> list) {
		this.listCandidate = list;
	}

	public void createExperience() throws SQLException {

		Experience exc = new Experience();
		do {
			System.out.println("Nhập CandidateID của ứng viên : ");
			exc.setCandidateID(sc.nextLine());
			System.out.println("Nhập FullName của ứng viên : ");
			exc.setFullname(sc.nextLine());

			while (true) {
				try {
					System.out.println("Nhập Birthday Theo Mẫu yyy-MM-dd");
					String inputDate = sc.nextLine();
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
					LocalDate localDate = LocalDate.parse(inputDate, formatter);
					exc.setBirthday(localDate);
					break;
				} catch (Exception e) {
					System.out.println("Định dạng không hợp lệ. Vui lòng nhập lại theo định dạng yyyy-MM-dd.");
				}
			}
			System.out.println("Nhập SĐT liên lạc : ");
			exc.setPhone(Integer.parseInt(sc.nextLine()));
			System.out.println("Nhập Địa Chỉ Email : ");
			exc.setEmail(sc.nextLine());
			System.out.println("Nhập Phân Loại Ứng Viên với 0,'Experience' 1,'Fresher' 2,'Intern' :");
			exc.setCandidate_type(Integer.parseInt(sc.nextLine()));
			System.out.println("Nhập Số Năm Kinh Nghiệm Của Ứng Viên :");
			exc.setExpInyear(Integer.parseInt(sc.nextLine()));
			System.out.println("Nhập tên Kỹ Năng của ứng viên : ");
			exc.setProSkill(sc.nextLine());
			this.listCandidate.add(exc);

			Connection conn = Conec_QLUV_FPT.connectDB();

			String sql = "INSERT INTO Candidate(Candidate_ID,Fullname,Birthday,Phone,Email,Candidate_type,ExpInyear,ProSkill ) VALUES (?,?,?,?,?,?,?,?)";

			try (PreparedStatement ps = conn.prepareStatement(sql)) {
				ps.setString(1, exc.getCandidateID());
				ps.setString(2, exc.getFullname());
				ps.setObject(3, exc.getBirthday());
				ps.setInt(4, exc.getPhone());
				ps.setString(5, exc.getEmail());
				ps.setInt(6, exc.getCandidate_type());
				ps.setInt(7, exc.getExpInyear());
				ps.setString(8, exc.getProSkill());
				int rowsAffected = ps.executeUpdate();
				if (rowsAffected > 0) {
					System.out.println("Dữ liệu đã được chèn thành công!");
				} else {
					System.out.println("Không thể chèn dữ liệu.");
				}
			} catch (Exception e) {
				// TODO: handle exception
			} finally {
				if (conn != null) {
					conn.close();
				}
			}
			System.out.println("Bạn Có Muốn Nhập Thêm Ứng Viên Experience. Chọn Y/N");
			String menu = sc.nextLine();
			if (menu.equalsIgnoreCase("n")) {
				break;
			}
		} while (true);
	}

	/*
	 * private String CandidateID; private String Fullname; private LocalDate
	 * Birthday; private int Phone; private String Email; private int
	 * Candidate_type;
	 */
	public void createFresher() throws SQLException {
		Fresher fres = new Fresher();
		do {
			System.out.println("Nhập CandidateID của ứng viên : ");
			fres.setCandidateID(sc.nextLine());
			System.out.println("Nhập FullName của ứng viên : ");
			fres.setFullname(sc.nextLine());

			while (true) {
				try {
					System.out.println("Nhập Birthday Theo Mẫu yyy-MM-dd");
					String inputDate = sc.nextLine();
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
					LocalDate localDate = LocalDate.parse(inputDate, formatter);
					fres.setBirthday(localDate);
					break;
				} catch (Exception e) {
					System.out.println("Định dạng không hợp lệ. Vui lòng nhập lại theo định dạng yyyy-MM-dd.");
				}
			}
			System.out.println("Nhập SĐT liên lạc : ");
			fres.setPhone(Integer.parseInt(sc.nextLine()));
			System.out.println("Nhập Địa Chỉ Email : ");
			fres.setEmail(sc.nextLine());
			System.out.println("Nhập Phân Loại Ứng Viên với 0,'Experience' 1,'Fresher' 2,'Intern' :");
			fres.setCandidate_type(Integer.parseInt(sc.nextLine()));
			while (true) {
				try {
					System.out.println("Nhập Thời Gian Ra Trường Theo Mẫu yyy-MM-dd");
					String inputDate2 = sc.nextLine();
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
					LocalDate localDate2 = LocalDate.parse(inputDate2, formatter);
					fres.setGraduation_date(localDate2);
					break;
				} catch (Exception e) {
					System.out.println("Định dạng không hợp lệ. Vui lòng nhập lại theo định dạng yyyy-MM-dd.");
				}
			}
			System.out.println("Ứng Viên Tốt Nghiệp Loại nào :");
			fres.setGraduation_rank(sc.nextLine());
			System.out.println("Nhập Nhập Tên Trường Đào Tạo:");
			fres.setEducation(sc.nextLine());

			this.listCandidate.add(fres);
			Connection conn = Conec_QLUV_FPT.connectDB();

			String sql = "INSERT INTO Candidate(Candidate_ID,Fullname,Birthday,Phone,Email,Candidate_type,Graduation_date,Graduation_rank, Education) VALUES (?,?,?,?,?,?,?,?,?)";

			try (PreparedStatement ps = conn.prepareStatement(sql)) {
				ps.setString(1, fres.getCandidateID());
				ps.setString(2, fres.getFullname());
				ps.setObject(3, fres.getBirthday());
				ps.setInt(4, fres.getPhone());
				ps.setString(5, fres.getEmail());
				ps.setInt(6, fres.getCandidate_type());
				ps.setObject(7, fres.getGraduation_date());
				ps.setString(8, fres.getGraduation_rank());
				ps.setString(9, fres.getEducation());
				int rowsAffected = ps.executeUpdate();
				if (rowsAffected > 0) {
					System.out.println("Dữ liệu đã được chèn thành công!");
				} else {
					System.out.println("Không thể chèn dữ liệu.");
				}
			} catch (Exception e) {
				// TODO: handle exception
			} finally {
				if (conn != null) {
					conn.close();
				}
			}

			System.out.println("Bạn Có Muốn Nhập Thêm Thông Tin của Fresher khác. Chọn Y/N : ");
			String menu = sc.nextLine();
			if (menu.equalsIgnoreCase("n"))
				;
		} while (true);
	}
	public void createIntern() throws SQLException {
		Intern inter = new Intern();
	do {
		System.out.println("Nhập CandidateID của ứng viên : ");
		inter.setCandidateID(sc.nextLine());
		System.out.println("Nhập FullName của ứng viên : ");
		inter.setFullname(sc.nextLine());

		while (true) {
			try {
				System.out.println("Nhập Birthday Theo Mẫu yyy-MM-dd");
				String inputDate = sc.nextLine();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				LocalDate localDate = LocalDate.parse(inputDate, formatter);
				inter.setBirthday(localDate);
				break;
			} catch (Exception e) {
				System.out.println("Định dạng không hợp lệ. Vui lòng nhập lại theo định dạng yyyy-MM-dd.");
			}
		}
		System.out.println("Nhập SĐT liên lạc : ");
		inter.setPhone(Integer.parseInt(sc.nextLine()));
		System.out.println("Nhập Địa Chỉ Email : ");
		inter.setEmail(sc.nextLine());
		System.out.println("Nhập Phân Loại Ứng Viên với 0,'Experience' 1,'Fresher' 2,'Intern' :");
		inter.setCandidate_type(Integer.parseInt(sc.nextLine()));
		System.out.println("Nhập Chuyên Ngành Đang Học :");
		inter.setMaors(sc.nextLine());
		System.out.println("Nhập Học Kỳ Đang Học : ");
		inter.setSemester(Integer.parseInt(sc.nextLine()));
		System.out.println("Nhập Tên Trường Đang Học :");
		inter.setUniversity_name(sc.nextLine());
		this.listCandidate.add(inter);

		Connection conn = Conec_QLUV_FPT.connectDB();

		String sql = "INSERT INTO Candidate(Candidate_ID,Fullname,Birthday,Phone,Email,Candidate_type,Maors,Semester,University_name ) VALUES (?,?,?,?,?,?,?,?,?)";

		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, inter.getCandidateID());
			ps.setString(2, inter.getFullname());
			ps.setObject(3, inter.getBirthday());
			ps.setInt(4, inter.getPhone());
			ps.setString(5, inter.getEmail());
			ps.setInt(6, inter.getCandidate_type());
			ps.setString(7, inter.getMaors());
			ps.setInt(8, inter.getSemester());
			ps.setString(9, inter.getUniversity_name());
			int rowsAffected = ps.executeUpdate();
			if (rowsAffected > 0) {
				System.out.println("Dữ liệu đã được chèn thành công!");
			} else {
				System.out.println("Không thể chèn dữ liệu.");
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
		System.out.println("Bạn Có Muốn Nhập Thêm Ứng Viên Experience. Chọn Y/N");
		String menu = sc.nextLine();
		if (menu.equalsIgnoreCase("n")) {
			break;
		}
	} while (true);
}
}