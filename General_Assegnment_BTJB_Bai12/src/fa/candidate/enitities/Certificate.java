package fa.candidate.enitities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import fa.candidate.main.ConnectionQLUV_FPT;

public class Certificate {
	Scanner sc = new Scanner(System.in);
	public String Certificated_ID;
	public String Certificate_Name;
	public String Certificate_Rank;
	public LocalDate Certificated_Date;

	public Certificate() {
		this.Certificated_ID = "";
		this.Certificate_Name = "";
		this.Certificate_Rank = "";
		this.Certificated_Date = null;
	}

	public Certificate(String id, String name, String rank, LocalDate date) {
		this.Certificated_ID = id;
		this.Certificate_Name = name;
		this.Certificate_Rank = rank;
		this.Certificated_Date = date;
	}


	public String toString() {
		return "Certificate [Certificated_ID = " + getCertificated_ID() + ", Certificate_Name = "
				+ getCertificate_Name() + ", Certificate_Rank = " + getCertificate_Rank()
				+ ", Certificated_Date = " + getCertificated_Date() + "]";
	}

	public String getCertificated_ID() {
		return Certificated_ID;
	}

	public void setCertificated_ID(String certificated_ID) {
		Certificated_ID = certificated_ID;
	}

	public String getCertificate_Name() {
		return Certificate_Name;
	}

	public void setCertificate_Name(String certificate_Name) {
		Certificate_Name = certificate_Name;
	}

	public String getCertificate_Rank() {
		return Certificate_Rank;
	}

	public void setCertificate_Rank(String certificate_Rank) {
		Certificate_Rank = certificate_Rank;
	}

	public LocalDate getCertificated_Date() {
		return Certificated_Date;
	}

	public void setCertificated_Date(LocalDate certificated_Date) {
		Certificated_Date = certificated_Date;
	}
	public void createCertificate() {
		
		do {
			System.out.println("Nhập Certificated_ID");
			this.setCertificated_ID(sc.nextLine());
			System.out.println("Nhập Certificated_Name");
			this.setCertificate_Name(sc.nextLine());
			System.out.println("Nhập Certificated_Rank");
			this.setCertificate_Rank(sc.nextLine());
			while (true) {
				try {
					System.out.println("Nhập Certificated_Date . Theo Mẫu yyy-MM-dd");
					String inputDate = sc.nextLine();
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
					LocalDate localDate = LocalDate.parse(inputDate, formatter);
					this.setCertificated_Date(localDate);
					break;
				} catch (Exception e) {
					System.out.println("Định dạng không hợp lệ. Vui lòng nhập lại theo định dạng yyyy-MM-dd.");
				}
			}
			

			System.out.println("Bạn Có Muốn Nhập Thêm Ứng Viên Experience. Chọn Y/N");
			String menu = sc.nextLine();
			if (menu.equalsIgnoreCase("n")) {
				break;
			}

		} while (true);
	}
public void insertCertificate(){
	
	String sql = "INSERT INTO CERTIFICATE(Certificated_ID,Certificate_Name,Certificate_Rank,Certificated_Date) VALUES (?,?,?,?)";
	try (Connection conn = ConnectionQLUV_FPT.connectDB();
			PreparedStatement ps = conn.prepareStatement(sql)) {
		ps.setString(1, this.getCertificated_ID());
		ps.setString(1, this.getCertificate_Name());
		ps.setString(3, this.getCertificate_Rank());
		ps.setObject(4, this.getCertificated_Date());
		Candidate.setCanidate_count(ps.executeUpdate());
		if (Candidate.getCanidate_count() > 0) {
			System.out.println("Dữ liệu đã được thêm thành công!" + Candidate.getCanidate_count() + "record");
		} else {
			System.out.println("Không thể chèn dữ liệu.");
		}
	} catch (Exception e) {

	}


	}

}
