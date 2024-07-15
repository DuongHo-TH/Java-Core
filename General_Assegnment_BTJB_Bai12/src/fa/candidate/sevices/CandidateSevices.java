package fa.candidate.sevices;

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

import fa.candidate.enitities.Candidate;
import fa.candidate.enitities.Certificate;
import fa.candidate.enitities.Expericence;
import fa.candidate.enitities.Fresher;
import fa.candidate.enitities.Intern;
import fa.candidate.main.ConnectionQLUV_FPT;
import fa.canidate.utils.Validator;

public class CandidateSevices {
	Scanner sc = new Scanner(System.in);
	List<Candidate> listCandidate = new ArrayList<Candidate>();

	public CandidateSevices(List<Candidate> list) {
		this.listCandidate = list;
	}

	public void createExperience() throws SQLException {

		Expericence exc = new Expericence();
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
					if (localDate.getYear() >= 1900 && localDate.getYear() <= 2024) {
						exc.setBirthday(localDate);
						break;
					} else {
						System.out.println("Năm sinh không có trong định dạng vui lòng nhập lại");
					}

				} catch (Exception e) {
					System.out.println("Định dạng không hợp lệ. Vui lòng nhập lại theo định dạng yyyy-MM-dd.");
				}
			}
			System.out.println("Nhập SĐT liên lạc : ");
			exc.setPhone(sc.nextLine());
			System.out.println("Nhập Địa Chỉ Email : ");
			String checkemail = sc.nextLine();
			while (true) {
				if (checkemail.matches(Validator.Check_Email)) {
					exc.setEmail(checkemail);
					break;
				} else {
					System.out.println("Nhập Email sai định dạng vui lòng nhâp lại! ");
				}
			}
			System.out.println("Nhập Phân Loại Ứng Viên với 0,'Experience' 1,'Fresher' 2,'Intern' :");
			exc.setCandidate_type(Integer.parseInt(sc.nextLine()));
			System.out.println("Nhập Số Năm Kinh Nghiệm Của Ứng Viên :");
			exc.setExpInyear(Integer.parseInt(sc.nextLine()));
			System.out.println("Nhập tên Kỹ Năng của ứng viên : ");
			exc.setProSkill(sc.nextLine());
			List<Certificate> cer = new ArrayList<Certificate>();
			Certificate Cerexc = new Certificate();
			Cerexc.createCertificate();
			cer.add(Cerexc);
			exc.setCertifi_ofCandidate(cer);
			this.listCandidate.add(exc);

			Connection conn = ConnectionQLUV_FPT.connectDB();

			String sql = "INSERT INTO Candidate(Candidate_ID,Fullname,Birthday,Phone,Email,Candidate_type,ExpInyear,ProSkill ) VALUES (?,?,?,?,?,?,?,?)";

			try (PreparedStatement ps = conn.prepareStatement(sql)) {
				ps.setString(1, exc.getCandidateID());
				ps.setString(2, exc.getFullname());
				ps.setObject(3, exc.getBirthday());
				ps.setString(4, exc.getPhone());
				ps.setString(5, exc.getEmail());
				ps.setInt(6, exc.getCandidate_type());
				ps.setInt(7, exc.getExpInyear());
				ps.setString(8, exc.getProSkill());
				Candidate.setCanidate_count(ps.executeUpdate());
				if (Candidate.getCanidate_count() > 0) {
					System.out.println("Dữ liệu đã được thêm thành công!" + Candidate.getCanidate_count() + "record");
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
			Cerexc.insertCertificate();
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
					if (localDate.getYear() >= 1900 && localDate.getYear() <= 2024) {
						fres.setBirthday(localDate);
						break;
					} else {
						System.out.println("Năm sinh không có trong định dạng vui lòng nhập lại");
					}

				} catch (Exception e) {
					System.out.println("Định dạng không hợp lệ. Vui lòng nhập lại theo định dạng yyyy-MM-dd.");
				}
			}
			System.out.println("Nhập SĐT liên lạc : ");
			fres.setPhone(sc.nextLine());
			System.out.println("Nhập Địa Chỉ Email : ");
			String checkemail = sc.nextLine();
			while (true) {
				if (checkemail.matches(Validator.Check_Email)) {
					fres.setEmail(checkemail);
					break;
				} else {
					System.out.println("Nhập Email sai định dạng vui lòng nhâp lại! ");
				}
			}
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
			List<Certificate> cer = new ArrayList<Certificate>();
			Certificate Cerexc = new Certificate();
			Cerexc.createCertificate();
			cer.add(Cerexc);
			fres.setCertifi_ofCandidate(cer);

			this.listCandidate.add(fres);
			Connection conn = ConnectionQLUV_FPT.connectDB();

			String sql = "INSERT INTO Candidate(Candidate_ID,Fullname,Birthday,Phone,Email,Candidate_type,Graduation_date,Graduation_rank, Education) VALUES (?,?,?,?,?,?,?,?,?)";

			try (PreparedStatement ps = conn.prepareStatement(sql)) {
				ps.setString(1, fres.getCandidateID());
				ps.setString(2, fres.getFullname());
				ps.setObject(3, fres.getBirthday());
				ps.setString(4, fres.getPhone());
				ps.setString(5, fres.getEmail());
				ps.setInt(6, fres.getCandidate_type());
				ps.setObject(7, fres.getGraduation_date());
				ps.setString(8, fres.getGraduation_rank());
				ps.setString(9, fres.getEducation());
				Candidate.setCanidate_count(ps.executeUpdate());
				if (Candidate.getCanidate_count() > 0) {
					System.out.println("Dữ liệu đã được thêm thành công!" + Candidate.getCanidate_count() + "record");
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
			Cerexc.insertCertificate();
			System.out.println("Bạn Có Muốn Nhập Thêm Thông Tin của Fresher khác. Chọn Y/N : ");
			String menu = sc.nextLine();
			if (menu.equalsIgnoreCase("n"))
				break;
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
					if (localDate.getYear() >= 1900 && localDate.getYear() <= 2024) {
						inter.setBirthday(localDate);
						break;
					} else {
						System.out.println("Năm sinh không có trong định dạng vui lòng nhập lại");
					}

				} catch (Exception e) {
					System.out.println("Định dạng không hợp lệ. Vui lòng nhập lại theo định dạng yyyy-MM-dd.");
				}
			}
			System.out.println("Nhập SĐT liên lạc : ");
			inter.setPhone(sc.nextLine());
			System.out.println("Nhập Địa Chỉ Email : ");
			String checkemail = sc.nextLine();
			while (true) {
				if (checkemail.matches(Validator.Check_Email)) {
					inter.setEmail(checkemail);
					break;
				} else {
					System.out.println("Nhập Email sai định dạng vui lòng nhâp lại! ");
				}
			}
			System.out.println("Nhập Phân Loại Ứng Viên với 0,'Experience' 1,'Fresher' 2,'Intern' :");
			inter.setCandidate_type(Integer.parseInt(sc.nextLine()));
			System.out.println("Nhập Chuyên Ngành Đang Học :");
			inter.setMaors(sc.nextLine());
			System.out.println("Nhập Học Kỳ Đang Học : ");
			inter.setSemester(Integer.parseInt(sc.nextLine()));
			System.out.println("Nhập Tên Trường Đang Học :");
			inter.setUniversity_name(sc.nextLine());
			List<Certificate> cer = new ArrayList<Certificate>();
			Certificate Cerexc = new Certificate();
			Cerexc.createCertificate();
			cer.add(Cerexc);
			inter.setCertifi_ofCandidate(cer);

			this.listCandidate.add(inter);

			Connection conn = ConnectionQLUV_FPT.connectDB();

			String sql = "INSERT INTO Candidate(Candidate_ID,Fullname,Birthday,Phone,Email,Candidate_type,Maors,Semester,University_name ) VALUES (?,?,?,?,?,?,?,?,?)";

			try (PreparedStatement ps = conn.prepareStatement(sql)) {
				ps.setString(1, inter.getCandidateID());
				ps.setString(2, inter.getFullname());
				ps.setObject(3, inter.getBirthday());
				ps.setString(4, inter.getPhone());
				ps.setString(5, inter.getEmail());
				ps.setInt(6, inter.getCandidate_type());
				ps.setString(7, inter.getMaors());
				ps.setInt(8, inter.getSemester());
				ps.setString(9, inter.getUniversity_name());
				Candidate.setCanidate_count(ps.executeUpdate());
				if (Candidate.getCanidate_count() > 0) {
					System.out.println("Dữ liệu đã được thêm thành công!" + Candidate.getCanidate_count() + "record");
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
			Cerexc.insertCertificate();
			System.out.println("Bạn Có Muốn Nhập Thêm Ứng Viên Intern. Chọn Y/N");
			String menu = sc.nextLine();
			if (menu.equalsIgnoreCase("n")) {
				break;
			}
		} while (true);
	}

	public void selectCandidate() throws SQLException {

		Connection conn = ConnectionQLUV_FPT.connectDB();
		String sql = "SELECT FullName FROM Candidate  ";
		try (PreparedStatement stm = conn.prepareStatement(sql)) {

			ResultSet candaName = stm.executeQuery();

			while (candaName.next()) {
				Candidate Fullname = new Candidate() {

					@Override
					public void Showinfo() {
						// TODO Auto-generated method stub

					}
				};
				Fullname.setFullname(candaName.getString(1));
				this.listCandidate.add(Fullname);

			}
		} catch (Exception e) {

		} finally {
			if (conn != null) {
				conn.close();
			}
		}
		StringBuffer namecandidate = new StringBuffer();
		for (Candidate candidate1 : this.listCandidate) {
			namecandidate.append(candidate1.getFullname()).append(",");

		}
		System.out.println(namecandidate.toString());

	}

	public static void displayall() {

		List<Candidate> show = new ArrayList<Candidate>();
		show.addAll(Fresher.Showlist());
		show.addAll(Intern.showlist());
		show.addAll(Expericence.Showlist());
		Collections.sort(show,
				Comparator.comparing(Candidate::getCandidate_type).thenComparing(Candidate::getBirthday).reversed());

		for (Candidate candidate : show) {
			System.out.println(candidate.toString());
		}

	}

	public void showinfoExper() {
		List<Candidate> listExper = new ArrayList<Candidate>();

		Connection conn = ConnectionQLUV_FPT.connectDB();
		String sql = "SELECT Candidate_ID,Fullname,Birthday,Phone,Email,Candidate_type,ExpInyear,ProSkill"
				+ " FROM Candidate WHERE Candidate_type = 0 ";
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ResultSet exper = ps.executeQuery();
			while (exper.next()) {
				Expericence experSQL = new Expericence();
				experSQL.setCandidateID(exper.getString(1));
				experSQL.setFullname(exper.getString(2));
				String birt = exper.getString(3);
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				experSQL.setBirthday(LocalDate.parse(birt, formatter));
				experSQL.setPhone(exper.getString(4));
				experSQL.setEmail(exper.getString(5));
				experSQL.setCandidate_type(exper.getInt(6));
				experSQL.ExpInyear = exper.getInt(7);
				experSQL.ProSkill = exper.getString(8);
				listExper.add(experSQL);

			}

		} catch (Exception e) {

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		for (Candidate candidate : listExper) {
			System.out.println(candidate.toString());
		}
	}

	public void showinfoFres() {
		Fresher fre = new Fresher();
		fre.Showinfo();
	}

	public void showinfoIntern() {
		Intern intern = new Intern();
		intern.Showinfo();
	}

	public void showMapIntern() {
		Intern intern = new Intern();
		intern.ShowinfoMap();
	}

	public void showMapFres() {
		Fresher intern = new Fresher();
		intern.ShowinfoMap();
	}

	public void showMapExper() {
		Expericence intern = new Expericence();
		intern.ShowinfoMap();
	}

	public void updateCandidate() {
		
		String sql = " UPDATE  Candidate  SET  Candidate_ID = ? , FullName = ?, Birthday = ?, Phone = ?, Email = ?, Candidate_type = ?,ExpInyear = ?, ProSkill = ?  WHERE  Candidate_ID = ? ; ";
		String sql2 = " UPDATE  Candidate  SET  Candidate_ID = ? , FullName = ?, Birthday = ?, Phone = ?, Email = ?, Candidate_type = ?, Maors = ?, Semester = ?, University_name = ?  WHERE  Candidate_ID = ? ; ";
		String sql1 = " UPDATE  Candidate  SET  Candidate_ID = ? , FullName = ?, Birthday = ?, Phone = ?, Email = ?, Candidate_type = ?, Graduation_date = ?, Graduation_rank = ?, Education = ?  WHERE  Candidate_ID = ? ; ";

		System.out.println("Nhập Phân Loại Ứng Viên Cần Update 0,'Experience' 1,'Fresher' 2,'Intern' :");
		int typer = Integer.parseInt(sc.nextLine());

		if (typer == 0) {
			
			try (Connection conn = ConnectionQLUV_FPT.connectDB();
					PreparedStatement stm = conn.prepareStatement(sql)) {
				System.out.println("Nhập Candidate_ID ứng viên cần update thông tin");
				stm.setString(9, sc.nextLine());
				System.out.println("Nhập Candidate_ID");
				stm.setString(1, sc.nextLine());
				System.out.println("Nhập FullName");
				stm.setString(2, sc.nextLine());

				while (true) {
					try {
						System.out.println("Nhập Birthday Theo Mẫu yyy-MM-dd");
						String inputDate = sc.nextLine();
						DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
						LocalDate localDate = LocalDate.parse(inputDate, formatter);
						if (localDate.getYear() >= 1900 && localDate.getYear() <= 2024) {
							stm.setObject(3, localDate);
							break;
						} else {
							System.out.println("Năm sinh không có trong định dạng vui lòng nhập lại");
						}

					} catch (Exception e) {
						System.out.println("Định dạng không hợp lệ. Vui lòng nhập lại theo định dạng yyyy-MM-dd.");
					}
				}
				System.out.println("Nhập Số Điện Thoại");
				stm.setString(4, sc.nextLine());
				System.out.println("Nhập Email");
				stm.setString(5, sc.nextLine());
				System.out.println("Nhập Phân Loại Ứng Viên với 0,'Experience' 1,'Fresher' 2,'Intern' : ");
				stm.setInt(6, Integer.parseInt(sc.nextLine()));

				System.out.println("Nhập Số Năm Kinh Nghiệm");
				stm.setInt(7, Integer.parseInt(sc.nextLine()));
				System.out.println("Nhập Kỹ Năng Của Ứng Viên");
				stm.setString(8, sc.nextLine());

				Candidate.setCanidate_count(stm.executeUpdate());
				if (Candidate.getCanidate_count() > 0) {
					System.out.println("Số Ứng Viên Đã Update Thành Công" + Candidate.getCanidate_count());
				}
			} catch (SQLException e) {
				System.out.println("Thông Tin Ứng Viên Không Chính Xác");
			}
		} else if (typer == 1) {
			
			try (Connection conn1 = ConnectionQLUV_FPT.connectDB();
					PreparedStatement stm = conn1.prepareStatement(sql1)) {
				System.out.println("Nhập Candidate_ID ứng viên cần update thông tin");
				stm.setString(10, sc.nextLine());
				System.out.println("Nhập Candidate_ID");
				stm.setString(1, sc.nextLine());
				System.out.println("Nhập FullName");
				stm.setString(2, sc.nextLine());

				while (true) {
					try {
						System.out.println("Nhập Birthday Theo Mẫu yyy-MM-dd");
						String inputDate = sc.nextLine();
						DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
						LocalDate localDate = LocalDate.parse(inputDate, formatter);
						if (localDate.getYear() >= 1900 && localDate.getYear() <= 2024) {
							stm.setObject(3, localDate);
							break;
						} else {
							System.out.println("Năm sinh không có trong định dạng vui lòng nhập lại");
						}

					} catch (Exception e) {
						System.out.println("Định dạng không hợp lệ. Vui lòng nhập lại theo định dạng yyyy-MM-dd.");
					}
				}
				System.out.println("Nhập Số Điện Thoại");
				stm.setString(4, sc.nextLine());
				System.out.println("Nhập Email");
				stm.setString(5, sc.nextLine());
				System.out.println("Nhập Phân Loại Ứng Viên với 0,'Experience' 1,'Fresher' 2,'Intern' : ");
				stm.setInt(6, Integer.parseInt(sc.nextLine()));

				while (true) {
					try {
						System.out.println("Nhập Thời Gian Ra Trường Theo Mẫu yyy-MM-dd");
						String inputDate2 = sc.nextLine();
						DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
						LocalDate localDate2 = LocalDate.parse(inputDate2, formatter);
						stm.setObject(7, localDate2);
						break;
					} catch (Exception e) {
						System.out.println("Định dạng không hợp lệ. Vui lòng nhập lại theo định dạng yyyy-MM-dd.");
					}
				}
				System.out.println("Xếp Loại Tốt Nghiệp Của Ứng Viên");
				stm.setString(10, sc.nextLine());
				System.out.println("Trường Ứng Viên Tốt Nghiệp");
				stm.setString(11, sc.nextLine());
				Candidate.setCanidate_count(stm.executeUpdate());
				if (Candidate.getCanidate_count() > 0) {
					System.out.println("Số Ứng Viên Đã Update Thành Công" + Candidate.getCanidate_count());
				}
			} catch (SQLException e) {
				System.out.println("Thông Tin Ứng Viên Không Chính Xác");
			} 
		} else if(typer == 2) {
			
			try (Connection conn2 = ConnectionQLUV_FPT.connectDB();
					PreparedStatement stm = conn2.prepareStatement(sql2); ) {
				
				System.out.println("Nhập Candidate_ID ứng viên cần update thông tin");
				stm.setString(10, sc.nextLine());
				System.out.println("Nhập Candidate_ID");
				stm.setString(1, sc.nextLine());
				System.out.println("Nhập FullName");
				stm.setString(2, sc.nextLine());

				while (true) {
					try {
						System.out.println("Nhập Birthday Theo Mẫu yyy-MM-dd");
						String inputDate = sc.nextLine();
						DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
						LocalDate localDate = LocalDate.parse(inputDate, formatter);
						if (localDate.getYear() >= 1900 && localDate.getYear() <= 2024) {
							stm.setObject(3, localDate);
							break;
						} else {
							System.out.println("Năm sinh không có trong định dạng vui lòng nhập lại");
						}

					} catch (Exception e) {
						System.out.println("Định dạng không hợp lệ. Vui lòng nhập lại theo định dạng yyyy-MM-dd.");
					}
				}
				System.out.println("Nhập Số Điện Thoại");
				stm.setString(4, sc.nextLine());
				System.out.println("Nhập Email");
				stm.setString(5, sc.nextLine());
				System.out.println("Nhập Phân Loại Ứng Viên với 0,'Experience' 1,'Fresher' 2,'Intern' : ");
				stm.setInt(6, Integer.parseInt(sc.nextLine()));
				System.out.println("Nhập Chuyên Ngành Đang Học :");
				stm.setString(7, sc.nextLine());
				System.out.println("Nhập Học Kỳ Đang Học : ");
				stm.setInt(8, Integer.parseInt(sc.nextLine()));
				System.out.println("Nhập Tên Trường Đang Học :");
				stm.setString(9, sc.nextLine());
				Candidate.setCanidate_count(stm.executeUpdate());
				if (Candidate.getCanidate_count() > 0) {
					System.out.println("Số Ứng Viên Đã Update Thành Công" + Candidate.getCanidate_count());
				}
			}catch (SQLException e) {
				System.out.println("Thông Tin Ứng Viên Không Chính Xác");
			} 
		}
	}
}