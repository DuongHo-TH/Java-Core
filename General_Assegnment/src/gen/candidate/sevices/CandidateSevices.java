package gen.candidate.sevices;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import java.util.List;
import java.util.Scanner;

import gen.candidate.enitities.Candidate;
import gen.candidate.enitities.Certificate;
import gen.candidate.enitities.Expericence;
import gen.candidate.enitities.Fresher;
import gen.candidate.enitities.Intern;
import gen.candidate.main.ConnectionQLUV_FPT_Gen;
import gen.candidate.utils.Validator;

public class CandidateSevices {
	Scanner sc = new Scanner(System.in);

	public List<Candidate> addlistCandidate() {
		List<Candidate> listofCandidate = new ArrayList<Candidate>();
		do {
			System.out.println("Nhập Phân Loại Ứng Viên với 0,'Experience' 1,'Fresher' 2,'Intern' :");
			int Candidate_type = Integer.parseInt(sc.nextLine());
			if (Candidate_type == 0) {
				Expericence ex = new Expericence();
				System.out.println("Nhập CandidateID : ");
				ex.setCandidateID(sc.nextLine());
				System.out.println("Nhập Fullname : ");
				ex.setFullname(sc.nextLine());

				while (true) {
					try {
						System.out.println("Nhập Birthday Theo Mẫu yyy-MM-dd");
						String inputDate = sc.nextLine();
						DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
						LocalDate localDate = LocalDate.parse(inputDate, formatter);
						if (localDate.getYear() >= 1900 && localDate.getYear() <= 2024) {
							ex.setBirthday(localDate);
							break;
						} else {
							System.out.println("Năm sinh không có trong định dạng vui lòng nhập lại");
						}

					} catch (Exception e) {
						System.out.println("Định dạng không hợp lệ. Vui lòng nhập lại theo định dạng yyyy-MM-dd.");
					}
				}
				System.out.println("Nhập SĐT : ");
				ex.setPhone(sc.nextLine());

				while (true) {
					try {
					System.out.println("Nhập Địa Chỉ Email : ");
					String checkemail = sc.nextLine();
					if(checkemail.matches(Validator.Check_Email)) {
						ex.setEmail(checkemail);
						break;
					}else {
						throw new IllegalArgumentException("Email không hợp lệ. Vui Lòng Nhập Lại! ");
					}
						
						
					} catch(Exception e) {
						System.out.println("Lỗi " + e.getMessage());
					}
				}
				ex.setCandidate_type(Candidate_type);
				ex.setCertifi_ofCandidate(createCertificate());

				System.out.println("Nhập Số Năm Kinh Nghiệm : ");
				ex.setExpInyear(Integer.parseInt(sc.nextLine()));
				System.out.println("Nhập Tên Kỹ Năng : ");
				ex.setProSkill(sc.nextLine());

				listofCandidate.add(ex);

			} else if (Candidate_type == 1) {
				Fresher fre = new Fresher();
				System.out.println("Nhập CandidateID : ");
				fre.setCandidateID(sc.nextLine());
				System.out.println("Nhập Fullname : ");
				fre.setFullname(sc.nextLine());

				while (true) {
					try {
						System.out.println("Nhập Birthday Theo Mẫu yyy-MM-dd");
						String inputDate = sc.nextLine();
						DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
						LocalDate localDate = LocalDate.parse(inputDate, formatter);
						if (localDate.getYear() >= 1900 && localDate.getYear() <= 2024) {
							fre.setBirthday(localDate);
							break;
						} else {
							System.out.println("Năm sinh không có trong định dạng vui lòng nhập lại");
						}

					} catch (Exception e) {
						System.out.println("Định dạng không hợp lệ. Vui lòng nhập lại theo định dạng yyyy-MM-dd.");
					}
				}
				System.out.println("Nhập SĐT : ");
				fre.setPhone(sc.nextLine());
				while (true) {
					try {
					System.out.println("Nhập Địa Chỉ Email : ");
					String checkemail = sc.nextLine();
					if(checkemail.matches(Validator.Check_Email)) {
						fre.setEmail(checkemail);
						break;
					}else {
						throw new IllegalArgumentException("Email không hợp lệ. Vui Lòng Nhập Lại! ");
					}
						
						
					} catch(Exception e) {
						System.out.println("Lỗi " + e.getMessage());
					}
				}
				fre.setCandidate_type(Candidate_type);
				fre.setCertifi_ofCandidate(createCertificate());
				while (true) {
					try {
						System.out.println("Nhập Ngày Tốt Nghiệp Theo Mẫu yyy-MM-dd");
						String inputDate = sc.nextLine();
						DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
						LocalDate localDate = LocalDate.parse(inputDate, formatter);
						if (localDate.getYear() >= 1900 && localDate.getYear() <= 2024) {
							fre.setGraduation_date(localDate);
							break;
						} else {
							System.out.println("Năm sinh không có trong định dạng vui lòng nhập lại");
						}

					} catch (Exception e) {
						System.out.println("Định dạng không hợp lệ. Vui lòng nhập lại theo định dạng yyyy-MM-dd.");
					}
				}
				System.out.println("Nhập Xếp Loại Tốt Nghiệp : ");
				fre.setGraduation_rank(sc.nextLine());
				System.out.println("Nhập Trường Tốt Nghiệp : ");
				fre.setEducation(sc.nextLine());
				listofCandidate.add(fre);
			} else {
				Intern inter = new Intern();
				System.out.println("Nhập CandidateID : ");
				inter.setCandidateID(sc.nextLine());
				System.out.println("Nhập Fullname : ");
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
				System.out.println("Nhập SĐT : ");
				inter.setPhone(sc.nextLine());
				while (true) {
					try {
					System.out.println("Nhập Địa Chỉ Email : ");
					String checkemail = sc.nextLine();
					if(checkemail.matches(Validator.Check_Email)) {
						inter.setEmail(checkemail);
						break;
					}else {
						throw new IllegalArgumentException("Email không hợp lệ. Vui Lòng Nhập Lại! ");
					}
						
						
					} catch(Exception e) {
						System.out.println("Lỗi " + e.getMessage());
					}
				}
				inter.setCandidate_type(Candidate_type);
				inter.setCertifi_ofCandidate(createCertificate());
				System.out.println("Nhập Chuyên Ngành Học : ");
				inter.setMaors(sc.nextLine());
				System.out.println("Nhập Kì Học Hiện Tại : ");
				inter.setSemester(Integer.parseInt(sc.nextLine()));
				System.out.println("Nhập Trường Đang Học : ");
				inter.setUniversity_name(sc.nextLine());
				listofCandidate.add(inter);
			}
			System.out.println("Bạn Có Muốn Nhập Thêm Ứng Viên. Chọn Y/N");
			String menu = sc.nextLine();
			if (menu.equalsIgnoreCase("n")) {
				break;
			}
		} while (true);

		return listofCandidate;
	}

	public void insertCandidate() {

		String sql = "INSERT INTO Candidate(Candidate_ID,Fullname,Birthday,Phone,Email,Candidate_type,ExpInyear,ProSkill,Maors,Semester,University_name,Graduation_date,Graduation_rank,Education ) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		try (Connection conn = ConnectionQLUV_FPT_Gen.connectDB(); PreparedStatement ps = conn.prepareStatement(sql);) {
			int dem = 0;
			// Set auto-commit to false
			for (Candidate candi : addlistCandidate()) {
				ps.setString(1, candi.getCandidateID());
				ps.setString(2, candi.getFullname());
				ps.setObject(3, candi.getBirthday());
				ps.setString(4, candi.getPhone());
				ps.setString(5, candi.getEmail());
				ps.setInt(6, candi.getCandidate_type());
				if (candi instanceof Expericence) {
					ps.setInt(7, ((Expericence) candi).getExpInyear());
					ps.setString(8, ((Expericence) candi).getProSkill());
					ps.setString(9, null);
					ps.setString(10, null);
					ps.setString(11, null);
					ps.setString(12, null);
					ps.setString(13, null);
					ps.setString(14, null);
				} else if (candi instanceof Intern) {
					ps.setString(7, null);
					ps.setString(8, null);
					ps.setString(9, ((Intern) candi).getMaors());
					ps.setInt(10, ((Intern) candi).getSemester());
					ps.setString(11, ((Intern) candi).getUniversity_name());
					ps.setString(12, null);
					ps.setString(13, null);
					ps.setString(14, null);
				} else if (candi instanceof Fresher) {
					ps.setString(7, null);
					ps.setString(8, null);
					ps.setString(9, null);
					ps.setString(10, null);
					ps.setString(11, null);
					ps.setObject(12, ((Fresher) candi).getGraduation_date());
					ps.setString(13, ((Fresher) candi).getGraduation_rank());
					ps.setString(14, ((Fresher) candi).getEducation());
				}
				ps.executeUpdate();
				insertCertificate(candi);
				dem++;

			}
			Candidate.setCanidate_count(dem);
			if (Candidate.getCanidate_count() > 0) {
				System.out.println("Đã Insert Thành Công " + Candidate.getCanidate_count() + "Ứng Viên");

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void insertCertificate(Candidate as) {
		String sql = "INSERT INTO Certificate (Candidate_ID, Certificated_ID, Certificate_Name, Certificate_Rank, Certificated_Date) VALUES(?,?,?,?,?)";

		try (Connection conn = ConnectionQLUV_FPT_Gen.connectDB(); PreparedStatement ps = conn.prepareStatement(sql);) {

			for (Certificate certi : as.getCertifi_ofCandidate()) {
				ps.setString(1, as.getCandidateID());
				ps.setString(2, certi.getCertificated_ID());
				ps.setString(3, certi.getCertificate_Name());
				ps.setString(4, certi.getCertificate_Rank());
				ps.setObject(5, certi.getCertificated_Date());
				ps.executeUpdate();
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public List<Certificate> createCertificate() {
		List<Certificate> listofCerti = new ArrayList<Certificate>();

		do {
			Certificate Certi = new Certificate();
			System.out.println("Nhập Certificated_ID");
			Certi.setCertificated_ID(sc.nextLine());
			System.out.println("Nhập Certificated_Name");
			Certi.setCertificate_Name(sc.nextLine());
			System.out.println("Nhập Certificated_Rank");
			Certi.setCertificate_Rank(sc.nextLine());
			while (true) {
				try {
					System.out.println("Nhập Certificated_Date . Theo Mẫu yyy-MM-dd");
					String inputDate = sc.nextLine();
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
					LocalDate localDate = LocalDate.parse(inputDate, formatter);
					Certi.setCertificated_Date(localDate);
					break;
				} catch (Exception e) {
					System.out.println("Định dạng không hợp lệ. Vui lòng nhập lại theo định dạng yyyy-MM-dd.");
				}
			}

			listofCerti.add(Certi);
			System.out.println("Bạn Có Muốn Nhập Thêm Bằng Cấp cho Ứng Viên. Chọn Y/N");
			String menu = sc.nextLine();
			if (menu.equalsIgnoreCase("n")) {
				break;
			}

		} while (true);
		return listofCerti;
	}

	public List<Candidate> addinfor() {
		List<Candidate> listofCandidate = new ArrayList<Candidate>();

		String sql = "SELECT * FROM Candidate";
		try (Connection conn = ConnectionQLUV_FPT_Gen.connectDB(); PreparedStatement stm = conn.prepareStatement(sql)) {
			ResultSet candidate = stm.executeQuery();
			while (candidate.next()) {
				int type = candidate.getInt(6);
				if (type == 0) {
					Expericence exper = new Expericence();

					exper.setCandidateID(candidate.getString(1));
					exper.setFullname(candidate.getString(2));
					String birt = candidate.getString(3);
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
					exper.setBirthday(LocalDate.parse(birt, formatter));
					exper.setPhone(candidate.getString(4));
					exper.setEmail(candidate.getString(5));
					exper.setCandidate_type(type);
					exper.setExpInyear(candidate.getInt(7));
					exper.setProSkill(candidate.getString(8));
					List<Certificate> listofcerti = new ArrayList<Certificate>();
					String selectcertifi = "Select Certificated_ID, Certificate_Name, Certificate_Rank, Certificated_Date FROM Certificate WHERE Candidate_ID = ?";
					PreparedStatement stm1 = conn.prepareStatement(selectcertifi);
					stm1.setString(1, candidate.getString(1));
					ResultSet certifi = stm1.executeQuery();
					while (certifi.next()) {
						Certificate certi = new Certificate();
						certi.setCertificated_ID(certifi.getString(1));
						certi.setCertificate_Name(certifi.getString(2));
						certi.setCertificate_Rank(certifi.getString(3));
						String date = certifi.getString(4);
						DateTimeFormatter formatdate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
						certi.setCertificated_Date(LocalDate.parse(date, formatdate));
						listofcerti.add(certi);
					}
					exper.setCertifi_ofCandidate(listofcerti);
					listofCandidate.add(exper);
				} else if (type == 1) {
					Fresher fres = new Fresher();
					fres.setCandidateID(candidate.getString(1));
					fres.setFullname(candidate.getString(2));
					String birt = candidate.getString(3);

					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
					fres.setBirthday(LocalDate.parse(birt, formatter));
					fres.setPhone(candidate.getString(4));
					fres.setEmail(candidate.getString(5));
					fres.setCandidate_type(type);
					String birt2 = candidate.getString(12);
					DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
					fres.setGraduation_date(LocalDate.parse(birt2, formatter2));
					fres.setGraduation_rank(candidate.getString(13));
					fres.setEducation(candidate.getString(14));
					List<Certificate> listofcerti = new ArrayList<Certificate>();
					String selectcertifi = "Select Certificated_ID, Certificate_Name, Certificate_Rank, Certificated_Date FROM Certificate WHERE Candidate_ID = ?";
					PreparedStatement stm1 = conn.prepareStatement(selectcertifi);
					stm1.setString(1, candidate.getString(1));
					ResultSet certifi = stm1.executeQuery();
					while (certifi.next()) {
						Certificate certi = new Certificate();
						certi.setCertificated_ID(certifi.getString(1));
						certi.setCertificate_Name(certifi.getString(2));
						certi.setCertificate_Rank(certifi.getString(3));
						String date = certifi.getString(4);
						DateTimeFormatter formatdate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
						certi.setCertificated_Date(LocalDate.parse(date, formatdate));
						listofcerti.add(certi);
					}
					fres.setCertifi_ofCandidate(listofcerti);
					listofCandidate.add(fres);
				} else {
					Intern Inter = new Intern();
					Inter.setCandidateID(candidate.getString(1));
					Inter.setFullname(candidate.getString(2));
					String birt = candidate.getString(3);
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
					Inter.setBirthday(LocalDate.parse(birt, formatter));
					Inter.setPhone(candidate.getString(4));
					Inter.setEmail(candidate.getString(5));
					Inter.setCandidate_type(type);
					Inter.setMaors(candidate.getString(9));
					Inter.setSemester(candidate.getInt(10));
					Inter.setUniversity_name(candidate.getString(11));
					List<Certificate> listofcerti = new ArrayList<Certificate>();
					String selectcertifi = "Select Certificated_ID, Certificate_Name, Certificate_Rank, Certificated_Date FROM Certificate WHERE Candidate_ID = ?";
					PreparedStatement stm1 = conn.prepareStatement(selectcertifi);
					stm1.setString(1, candidate.getString(1));
					ResultSet certifi = stm1.executeQuery();
					while (certifi.next()) {
						Certificate certi = new Certificate();
						certi.setCertificated_ID(certifi.getString(1));
						certi.setCertificate_Name(certifi.getString(2));
						certi.setCertificate_Rank(certifi.getString(3));
						String date = certifi.getString(4);
						DateTimeFormatter formatdate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
						certi.setCertificated_Date(LocalDate.parse(date, formatdate));
						listofcerti.add(certi);
					}
					Inter.setCertifi_ofCandidate(listofcerti);

					listofCandidate.add(Inter);
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return listofCandidate;
	}

	public void shownameCandidate() {

		StringBuffer namecandidate = new StringBuffer();
		for (Candidate candidate : addinfor()) {
			namecandidate.append(candidate.getFullname()).append(",");

		}
		System.out.println(namecandidate.toString());

	}

	public void showinforCandidate() {
		for (Candidate candi : addinfor()) {
			System.out.println(candi.showinfor());
		}

	}

	public void sortlistCandidate() {
		List<Candidate> sortList = new ArrayList<Candidate>(addinfor());

		Collections.sort(sortList,
				Comparator.comparing(Candidate::getCandidate_type).thenComparing(Candidate::getBirthday).reversed());
		for (Candidate candi : sortList) {
			System.out.println(candi.showinfor());
		}

	}

	public int concurUpdate() {

		String sql = " SELECT * FROM Candidate WHERE Candidate_ID = ? ";
		try (Connection conn = ConnectionQLUV_FPT_Gen.connectDB();
				PreparedStatement stm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,
						ResultSet.CONCUR_UPDATABLE)) {
			System.out.println("Nhập Candidate_ID : ứng viên cần up date : ");
			stm.setString(1, sc.nextLine());
			System.out.println("Nhập Candidate_type của ứng viên cần update : ");
			int typer = Integer.parseInt(sc.nextLine());
			ResultSet rsCandidate = stm.executeQuery();
			while(rsCandidate.next()) {
			if ( typer == 0) {

				Expericence ex = new Expericence();
				System.out.println("Nhập CandidateID : ");
				ex.setCandidateID(sc.nextLine());
				System.out.println("Nhập Fullname : ");
				ex.setFullname(sc.nextLine());

				while (true) {
					try {
						System.out.println("Nhập Birthday Theo Mẫu yyy-MM-dd");
						String inputDate = sc.nextLine();
						DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
						LocalDate localDate = LocalDate.parse(inputDate, formatter);
						if (localDate.getYear() >= 1900 && localDate.getYear() <= 2024) {
							ex.setBirthday(localDate);
							break;
						} else {
							System.out.println("Năm sinh không có trong định dạng vui lòng nhập lại");
						}

					} catch (Exception e) {
						System.out.println("Định dạng không hợp lệ. Vui lòng nhập lại theo định dạng yyyy-MM-dd.");
					}
				}
				System.out.println("Nhập SĐT : ");
				ex.setPhone(sc.nextLine());

				while (true) {
					System.out.println("Nhập Địa Chỉ Email : ");
					String checkemail = sc.nextLine();
					if (checkemail.matches(Validator.Check_Email)) {
						ex.setEmail(checkemail);
						break;
					} else {
						System.out.println("Nhập Email sai định dạng vui lòng nhâp lại! ");
					}
				}
				System.out.println("Nhập Candidate_typer với 0,'Experience' 1,'Fresher' 2,'Intern' : ");
				ex.setCandidate_type(Integer.parseInt(sc.nextLine()));
				System.out.println("Nhập Số Năm Kinh Nghiệm : ");
				ex.setExpInyear(Integer.parseInt(sc.nextLine()));
				System.out.println("Nhập Tên Kỹ Năng : ");
				ex.setProSkill(sc.nextLine());

//				rsCandidate.updateString(1, ex.getCandidateID());
				rsCandidate.updateString(2, ex.getFullname());
				rsCandidate.updateObject(3, ex.getBirthday());
				rsCandidate.updateString(4, ex.getPhone());
				rsCandidate.updateString(5, ex.getEmail());
				rsCandidate.updateInt(6, ex.getCandidate_type());
				rsCandidate.updateInt(7, ex.getExpInyear());
				rsCandidate.updateString(8, ex.getProSkill());
//				rsCandidate.updateString(9, null);
//				rsCandidate.updateString(10, null);
//				rsCandidate.updateString(11, null);
//				rsCandidate.updateString(12, null);
//				rsCandidate.updateString(13, null);
//				rsCandidate.updateString(14, null);
				
				rsCandidate.updateRow();
				Candidate.setCanidate_count(+1);
				if(Candidate.getCanidate_count() != 0) {
					System.out.println("Update Ứng Viên Thành Công");
				}
			} else if (rsCandidate.next() && typer == 0) {
				Fresher fre = new Fresher();
				System.out.println("Nhập CandidateID : ");
				fre.setCandidateID(sc.nextLine());
				System.out.println("Nhập Fullname : ");
				fre.setFullname(sc.nextLine());

				while (true) {
					try {
						System.out.println("Nhập Birthday Theo Mẫu yyy-MM-dd");
						String inputDate = sc.nextLine();
						DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
						LocalDate localDate = LocalDate.parse(inputDate, formatter);
						if (localDate.getYear() >= 1900 && localDate.getYear() <= 2024) {
							fre.setBirthday(localDate);
							break;
						} else {
							System.out.println("Năm sinh không có trong định dạng vui lòng nhập lại");
						}

					} catch (Exception e) {
						System.out.println("Định dạng không hợp lệ. Vui lòng nhập lại theo định dạng yyyy-MM-dd.");
					}
				}
				System.out.println("Nhập SĐT : ");
				fre.setPhone(sc.nextLine());
				while (true) {
					System.out.println("Nhập Địa Chỉ Email : ");
					String checkemail = sc.nextLine();
					if (checkemail.matches(Validator.Check_Email)) {
						fre.setEmail(checkemail);
						break;
					} else {
						System.out.println("Nhập Email sai định dạng vui lòng nhâp lại! ");
					}
				}
				System.out.println("Nhập Candidate_typer với 0,'Experience' 1,'Fresher' 2,'Intern' : ");
				fre.setCandidate_type(Integer.parseInt(sc.nextLine()));

				while (true) {
					try {
						System.out.println("Nhập Ngày Tốt Nghiệp Theo Mẫu yyy-MM-dd");
						String inputDate = sc.nextLine();
						DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
						LocalDate localDate = LocalDate.parse(inputDate, formatter);
						if (localDate.getYear() >= 1900 && localDate.getYear() <= 2024) {
							fre.setGraduation_date(localDate);
							break;
						} else {
							System.out.println("Năm sinh không có trong định dạng vui lòng nhập lại");
						}

					} catch (Exception e) {
						System.out.println("Định dạng không hợp lệ. Vui lòng nhập lại theo định dạng yyyy-MM-dd.");
					}
				}
				System.out.println("Nhập Xếp Loại Tốt Nghiệp : ");
				fre.setGraduation_rank(sc.nextLine());
				System.out.println("Nhập Trường Tốt Nghiệp : ");
				fre.setEducation(sc.nextLine());

				rsCandidate.updateString(1, fre.getCandidateID());
				rsCandidate.updateString(2, fre.getFullname());
				rsCandidate.updateObject(3, fre.getBirthday());
				rsCandidate.updateString(4, fre.getPhone());
				rsCandidate.updateString(5, fre.getEmail());
				rsCandidate.updateInt(6, fre.getCandidate_type());
				rsCandidate.updateObject(7, fre.getGraduation_date());
				rsCandidate.updateString(8, fre.getGraduation_rank());
				rsCandidate.updateString(9, fre.getEducation());
				rsCandidate.updateRow();
				Candidate.setCanidate_count(+1);
			} else {
				Intern inter = new Intern();
				System.out.println("Nhập CandidateID : ");
				inter.setCandidateID(sc.nextLine());
				System.out.println("Nhập Fullname : ");
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
				System.out.println("Nhập SĐT : ");
				inter.setPhone(sc.nextLine());
				while (true) {
					System.out.println("Nhập Địa Chỉ Email : ");
					String checkemail = sc.nextLine();
					if (checkemail.matches(Validator.Check_Email)) {
						inter.setEmail(checkemail);
						break;
					} else {
						System.out.println("Nhập Email sai định dạng vui lòng nhâp lại! ");
					}
				}
				System.out.println("Nhập Candidate_typer với 0,'Experience' 1,'Fresher' 2,'Intern' : ");
				inter.setCandidate_type(Integer.parseInt(sc.nextLine()));
				System.out.println("Nhập Chuyên Ngành Học : ");
				inter.setMaors(sc.nextLine());
				System.out.println("Nhập Kì Học Hiện Tại : ");
				inter.setSemester(Integer.parseInt(sc.nextLine()));
				System.out.println("Nhập Trường Đang Học : ");
				inter.setUniversity_name(sc.nextLine());

				rsCandidate.updateString(1, inter.getCandidateID());
				rsCandidate.updateString(2, inter.getFullname());
				rsCandidate.updateObject(3, inter.getBirthday());
				rsCandidate.updateString(4, inter.getPhone());
				rsCandidate.updateString(5, inter.getEmail());
				rsCandidate.updateInt(6, inter.getCandidate_type());
				rsCandidate.updateString(7, inter.getMaors());
				rsCandidate.updateInt(8, inter.getSemester());
				rsCandidate.updateString(9, inter.getUniversity_name());
				rsCandidate.updateRow();

				Candidate.setCanidate_count(+1);
			}
			}
			if (Candidate.getCanidate_count() > 0) {
				System.out.println("Số Ứng Viên Đã Được Cập : " + Candidate.getCanidate_count());
			}else {
				System.out.println("Update Ứng Viên Thất Bại");
			}
		} catch (SQLException e) {
			System.out.println("Thông Tin Ứng Viên Không Chính Xác");
		}
		return Candidate.getCanidate_count();
	}

	public int concurInsert() {
		String sql = " SELECT * FROM Candidate WHERE Candidate_type = ? ";
		try (Connection conn = ConnectionQLUV_FPT_Gen.connectDB();
				PreparedStatement stm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,
						ResultSet.CONCUR_UPDATABLE)) {
			System.out.println("Nhập Candidate_type của ứng viên cần Insert : ");
			int typer = Integer.parseInt(sc.nextLine());
			stm.setInt(1, typer);
			ResultSet rsCandidate = stm.executeQuery();
			rsCandidate.moveToInsertRow();
			if ( typer == 0) {

				Expericence ex = new Expericence();
				System.out.println("Nhập Fullname : ");
				ex.setFullname(sc.nextLine());

				while (true) {
					try {
						System.out.println("Nhập Birthday Theo Mẫu yyy-MM-dd");
						String inputDate = sc.nextLine();
						DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
						LocalDate localDate = LocalDate.parse(inputDate, formatter);
						if (localDate.getYear() >= 1900 && localDate.getYear() <= 2024) {
							ex.setBirthday(localDate);
							break;
						} else {
							System.out.println("Năm sinh không có trong định dạng vui lòng nhập lại");
						}

					} catch (Exception e) {
						System.out.println("Định dạng không hợp lệ. Vui lòng nhập lại theo định dạng yyyy-MM-dd.");
					}
				}
				System.out.println("Nhập SĐT : ");
				ex.setPhone(sc.nextLine());

				while (true) {
					System.out.println("Nhập Địa Chỉ Email : ");
					String checkemail = sc.nextLine();
					if (checkemail.matches(Validator.Check_Email)) {
						ex.setEmail(checkemail);
						break;
					} else {
						System.out.println("Nhập Email sai định dạng vui lòng nhâp lại! ");
					}
				}
				ex.setCandidate_type(typer);
				System.out.println("Nhập Số Năm Kinh Nghiệm : ");
				ex.setExpInyear(Integer.parseInt(sc.nextLine()));
				System.out.println("Nhập Tên Kỹ Năng : ");
				ex.setProSkill(sc.nextLine());
				rsCandidate.updateString(2, ex.getFullname());
				rsCandidate.updateObject(3, ex.getBirthday());
				rsCandidate.updateString(4, ex.getPhone());
				rsCandidate.updateString(5, ex.getEmail());
				rsCandidate.updateInt(6, ex.getCandidate_type());
				rsCandidate.updateInt(7, ex.getExpInyear());
				rsCandidate.insertRow();
				Candidate.setCanidate_count(+1);
				ex.setCertifi_ofCandidate(createCertificate());
				insertCertificate(ex);
			} else if ( typer == 0) {
				Fresher fre = new Fresher();
				System.out.println("Nhập CandidateID : ");
				fre.setCandidateID(sc.nextLine());
				System.out.println("Nhập Fullname : ");
				fre.setFullname(sc.nextLine());

				while (true) {
					try {
						System.out.println("Nhập Birthday Theo Mẫu yyy-MM-dd");
						String inputDate = sc.nextLine();
						DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
						LocalDate localDate = LocalDate.parse(inputDate, formatter);
						if (localDate.getYear() >= 1900 && localDate.getYear() <= 2024) {
							fre.setBirthday(localDate);
							break;
						} else {
							System.out.println("Năm sinh không có trong định dạng vui lòng nhập lại");
						}

					} catch (Exception e) {
						System.out.println("Định dạng không hợp lệ. Vui lòng nhập lại theo định dạng yyyy-MM-dd.");
					}
				}
				System.out.println("Nhập SĐT : ");
				fre.setPhone(sc.nextLine());
				while (true) {
					System.out.println("Nhập Địa Chỉ Email : ");
					String checkemail = sc.nextLine();
					if (checkemail.matches(Validator.Check_Email)) {
						fre.setEmail(checkemail);
						break;
					} else {
						System.out.println("Nhập Email sai định dạng vui lòng nhâp lại! ");
					}
				}
				
				fre.setCandidate_type(typer);

				while (true) {
					try {
						System.out.println("Nhập Ngày Tốt Nghiệp Theo Mẫu yyy-MM-dd");
						String inputDate = sc.nextLine();
						DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
						LocalDate localDate = LocalDate.parse(inputDate, formatter);
						if (localDate.getYear() >= 1900 && localDate.getYear() <= 2024) {
							fre.setGraduation_date(localDate);
							break;
						} else {
							System.out.println("Năm sinh không có trong định dạng vui lòng nhập lại");
						}

					} catch (Exception e) {
						System.out.println("Định dạng không hợp lệ. Vui lòng nhập lại theo định dạng yyyy-MM-dd.");
					}
				}
				System.out.println("Nhập Xếp Loại Tốt Nghiệp : ");
				fre.setGraduation_rank(sc.nextLine());
				System.out.println("Nhập Trường Tốt Nghiệp : ");
				fre.setEducation(sc.nextLine());
				

				rsCandidate.updateString(1, fre.getCandidateID());
				rsCandidate.updateString(2, fre.getFullname());
				rsCandidate.updateObject(3, fre.getBirthday());
				rsCandidate.updateString(4, fre.getPhone());
				rsCandidate.updateString(5, fre.getEmail());
				rsCandidate.updateInt(6, fre.getCandidate_type());
				rsCandidate.updateString(7, null);
				rsCandidate.updateString(8, null);
				rsCandidate.updateString(9, null);
				rsCandidate.updateString(10, null);
				rsCandidate.updateString(11, null);
				rsCandidate.updateObject(12, fre.getGraduation_date());
				rsCandidate.updateString(13, fre.getGraduation_rank());
				rsCandidate.updateString(14, fre.getEducation());
				rsCandidate.insertRow();
				Candidate.setCanidate_count(+1);
				fre.setCertifi_ofCandidate(createCertificate());
				insertCertificate(fre);
			} else {
				Intern inter = new Intern();
				System.out.println("Nhập CandidateID : ");
				inter.setCandidateID(sc.nextLine());
				System.out.println("Nhập Fullname : ");
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
				System.out.println("Nhập SĐT : ");
				inter.setPhone(sc.nextLine());
				while (true) {
					System.out.println("Nhập Địa Chỉ Email : ");
					String checkemail = sc.nextLine();
					if (checkemail.matches(Validator.Check_Email)) {
						inter.setEmail(checkemail);
						break;
					} else {
						System.out.println("Nhập Email sai định dạng vui lòng nhâp lại! ");
					}
				}
				
				inter.setCandidate_type(typer);
				
				System.out.println("Nhập Chuyên Ngành Học : ");
				inter.setMaors(sc.nextLine());
				System.out.println("Nhập Kì Học Hiện Tại : ");
				inter.setSemester(Integer.parseInt(sc.nextLine()));
				System.out.println("Nhập Trường Đang Học : ");
				inter.setUniversity_name(sc.nextLine());
				

				rsCandidate.updateString(1, inter.getCandidateID());
				rsCandidate.updateString(2, inter.getFullname());
				rsCandidate.updateObject(3, inter.getBirthday());
				rsCandidate.updateString(4, inter.getPhone());
				rsCandidate.updateString(5, inter.getEmail());
				rsCandidate.updateInt(6, inter.getCandidate_type());
				rsCandidate.updateString(7, null);
				rsCandidate.updateString(8, null);
				rsCandidate.updateString(9, inter.getMaors());
				rsCandidate.updateInt(10, inter.getSemester());
				rsCandidate.updateString(11, inter.getUniversity_name());
				rsCandidate.updateString(12, null);
				rsCandidate.updateString(13, null);
				rsCandidate.updateString(14, null);
				rsCandidate.insertRow();
				Candidate.setCanidate_count(+1);
				inter.setCertifi_ofCandidate(createCertificate());
				insertCertificate(inter);
			}
			if (Candidate.getCanidate_count() > 0) {
				System.out.println("Số Ứng Viên Đã Được Cập : " + Candidate.getCanidate_count());
			}else {
				System.out.println("Insert Ứng Viên Thất Bại");
			}
		} catch (SQLException e) {
			System.out.println("Thông Tin Ứng Viên Không Chính Xác" + e.getMessage());
		}
		return Candidate.getCanidate_count();
	}
	public static void Selectinfor(Scanner sc) {
		List<Candidate> listofCandidate = new ArrayList<Candidate>();

		String sql = "SELECT * FROM Candidate WHERE FullName Like ? or Email Like ?";
		try (Connection conn = ConnectionQLUV_FPT_Gen.connectDB(); PreparedStatement stm = conn.prepareStatement(sql)) {
			System.out.println("Nhập FullName  hoặc Emailcần tìm Kiếm ");
			String fullname = sc.nextLine();
		
			stm.setString(1, "%" +fullname + "%");
			stm.setString(2, "%"+ fullname + "%");
			ResultSet candidate = stm.executeQuery();
			while (candidate.next()) {
				int type = candidate.getInt(6);
				if (type == 0) {
					Expericence exper = new Expericence();

					exper.setCandidateID(candidate.getString(1));
					exper.setFullname(candidate.getString(2));
					String birt = candidate.getString(3);
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
					exper.setBirthday(LocalDate.parse(birt, formatter));
					exper.setPhone(candidate.getString(4));
					exper.setEmail(candidate.getString(5));
					exper.setCandidate_type(type);
					exper.setExpInyear(candidate.getInt(7));
					exper.setProSkill(candidate.getString(8));
					List<Certificate> listofcerti = new ArrayList<Certificate>();
					String selectcertifi = "Select Certificated_ID, Certificate_Name, Certificate_Rank, Certificated_Date FROM Certificate WHERE Candidate_ID = ?";
					PreparedStatement stm1 = conn.prepareStatement(selectcertifi);
					stm1.setString(1, candidate.getString(1));
					ResultSet certifi = stm1.executeQuery();
					while (certifi.next()) {
						Certificate certi = new Certificate();
						certi.setCertificated_ID(certifi.getString(1));
						certi.setCertificate_Name(certifi.getString(2));
						certi.setCertificate_Rank(certifi.getString(3));
						String date = certifi.getString(4);
						DateTimeFormatter formatdate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
						certi.setCertificated_Date(LocalDate.parse(date, formatdate));
						listofcerti.add(certi);
					}
					exper.setCertifi_ofCandidate(listofcerti);
					listofCandidate.add(exper);
				} else if (type == 1) {
					Fresher fres = new Fresher();
					fres.setCandidateID(candidate.getString(1));
					fres.setFullname(candidate.getString(2));
					String birt = candidate.getString(3);

					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
					fres.setBirthday(LocalDate.parse(birt, formatter));
					fres.setPhone(candidate.getString(4));
					fres.setEmail(candidate.getString(5));
					fres.setCandidate_type(type);
					String birt2 = candidate.getString(12);
					DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
					fres.setGraduation_date(LocalDate.parse(birt2, formatter2));
					fres.setGraduation_rank(candidate.getString(13));
					fres.setEducation(candidate.getString(14));
					List<Certificate> listofcerti = new ArrayList<Certificate>();
					String selectcertifi = "Select Certificated_ID, Certificate_Name, Certificate_Rank, Certificated_Date FROM Certificate WHERE Candidate_ID = ?";
					PreparedStatement stm1 = conn.prepareStatement(selectcertifi);
					stm1.setString(1, candidate.getString(1));
					ResultSet certifi = stm1.executeQuery();
					while (certifi.next()) {
						Certificate certi = new Certificate();
						certi.setCertificated_ID(certifi.getString(1));
						certi.setCertificate_Name(certifi.getString(2));
						certi.setCertificate_Rank(certifi.getString(3));
						String date = certifi.getString(4);
						DateTimeFormatter formatdate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
						certi.setCertificated_Date(LocalDate.parse(date, formatdate));
						listofcerti.add(certi);
					}
					fres.setCertifi_ofCandidate(listofcerti);
					listofCandidate.add(fres);
				} else {
					Intern Inter = new Intern();
					Inter.setCandidateID(candidate.getString(1));
					Inter.setFullname(candidate.getString(2));
					String birt = candidate.getString(3);
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
					Inter.setBirthday(LocalDate.parse(birt, formatter));
					Inter.setPhone(candidate.getString(4));
					Inter.setEmail(candidate.getString(5));
					Inter.setCandidate_type(type);
					Inter.setMaors(candidate.getString(9));
					Inter.setSemester(candidate.getInt(10));
					Inter.setUniversity_name(candidate.getString(11));
					List<Certificate> listofcerti = new ArrayList<Certificate>();
					String selectcertifi = "Select Certificated_ID, Certificate_Name, Certificate_Rank, Certificated_Date FROM Certificate WHERE Candidate_ID = ?";
					PreparedStatement stm1 = conn.prepareStatement(selectcertifi);
					stm1.setString(1, candidate.getString(1));
					ResultSet certifi = stm1.executeQuery();
					while (certifi.next()) {
						Certificate certi = new Certificate();
						certi.setCertificated_ID(certifi.getString(1));
						certi.setCertificate_Name(certifi.getString(2));
						certi.setCertificate_Rank(certifi.getString(3));
						String date = certifi.getString(4);
						DateTimeFormatter formatdate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
						certi.setCertificated_Date(LocalDate.parse(date, formatdate));
						listofcerti.add(certi);
					}
					Inter.setCertifi_ofCandidate(listofcerti);

					listofCandidate.add(Inter);
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
         for (Candidate candidate2 : listofCandidate) {
			System.out.println(candidate2.showinfor());
		}
	}
}


