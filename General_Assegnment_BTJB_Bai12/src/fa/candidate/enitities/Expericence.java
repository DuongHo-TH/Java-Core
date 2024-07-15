package fa.candidate.enitities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import fa.candidate.main.ConnectionQLUV_FPT;

public class Expericence extends Candidate {
	public int ExpInyear;
	public String ProSkill;

	/*
	 * super() được sử dụng để gọi hàm khởi tạo của lớp cha. Khi tạo một đối tượng
	 * của lớp con, hàm khởi tạo của lớp cha cũng được gọi. super() thường được đặt
	 * ở đầu hàm khởi tạo của lớp con. Nó đảm bảo rằng các tài nguyên và trạng thái
	 * của lớp cha được khởi tạo trước khi khởi tạo lớp con.
	 */
	public Expericence() {
		super();
		this.ExpInyear = 0;
		this.ProSkill = "";
	}

	public Expericence(String candi, String name, LocalDate birt, String phone, String email, int typer,
			List<Certificate> certi) {
		super(candi, name, birt, phone, email, typer, certi);
		
	}

	public String toString() {
		return "Expericence [CandidateID = " + getCandidateID() + ", Fullname = " + getFullname()
				+ ", Birthday = " + getBirthday() + ", Phone = " + getPhone() + ", Email = " + getEmail()
				+ ", Candidate_type = " + getCandidate_type() + ", ExpInyear = " + getExpInyear()
				+ ", ProSkill = " + getProSkill() + "]";
	}

	/*
	 * this là một biến tham chiếu đến đối tượng hiện tại. Nó được sử dụng để truy
	 * cập các thành viên (biến và phương thức) của đối tượng hiện tại. để giải
	 * quyết xung đột tên giữa biến cục bộ và biến thành viên.
	 * 
	 */
	public Expericence(int exp, String skill) {
		this.ExpInyear = exp;
		this.ProSkill = skill;
	}

	public int getExpInyear() {
		return ExpInyear;
	}

	public void setExpInyear(int expInyear) {
		ExpInyear = expInyear;
	}

	public String getProSkill() {
		return ProSkill;
	}

	public void setProSkill(String proSkill) {
		ProSkill = proSkill;
	}
//	private String CandidateID;
//	private String Fullname;
//	private LocalDate Birthday;
//	private int Phone;
//	private String Email;
//	private int Candidate_type;

	public void Showinfo() {
		super.toString();

	}

	public void ShowinfoMap() {
		Map<String, Candidate> listExper = new LinkedHashMap<String, Candidate>();

		Connection conn = ConnectionQLUV_FPT.connectDB();
		String sql = "SELECT Candidate_ID,Fullname,Birthday,Phone,Email,Candidate_type,Maors,Semester,University_name"
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
				listExper.put(experSQL.getCandidateID(), experSQL);

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
		for (Candidate value : listExper.values()) {
			System.out.println(value.toString());
		}
	}

	public static List<Expericence> Showlist() {
		List<Expericence> listExper = new ArrayList<Expericence>();

		Connection conn = ConnectionQLUV_FPT.connectDB();
		String sql = "SELECT Candidate_ID,Fullname,Birthday,Phone,Email,Candidate_type,Graduation_date,Graduation_rank,Education"
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
				String birt2 = exper.getString(7);
				DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
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
		return listExper;
	}

}
