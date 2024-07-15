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

public class Fresher extends Candidate {
	protected LocalDate Graduation_date;
	protected String Graduation_rank;
	protected String Education;

	public Fresher() {
		super();
		this.Graduation_date = null;
		this.Graduation_rank = "";
		this.Education = "";
	}

	public Fresher(LocalDate date, String rank, String edu) {
		this.Graduation_date = date;
		this.Graduation_rank = rank;
		this.Education = edu;
	}

	public String toString() {
		return "Fresher [CandidateID = " + getCandidateID() + ", Fullname = " + getFullname()
				+ ", Birthda = " + getBirthday() + ", Phone = " + getPhone() + ", Email = " + getEmail()
				+ ", Candidate_type = " + getCandidate_type() + ", Graduation_date = " + getGraduation_date()
				+ ", Graduation_rank = " + getGraduation_rank() + ", Education = " + getEducation()
				+  "]";
	}

	public Fresher(String candi, String name, LocalDate birt, String phone, String email, int typer,
			List<Certificate> certi) {
		super(candi, name, birt, phone, email, typer, certi);
		// TODO Auto-generated constructor stub
	}

	public LocalDate getGraduation_date() {
		return Graduation_date;
	}

	public void setGraduation_date(LocalDate graduation_date) {
		Graduation_date = graduation_date;
	}

	public String getGraduation_rank() {
		return Graduation_rank;
	}

	public void setGraduation_rank(String graduation_rank) {
		Graduation_rank = graduation_rank;
	}

	public String getEducation() {
		return Education;
	}

	public void setEducation(String education) {
		Education = education;
	}

	public void Showinfo() {
		List<Candidate> listExper = new ArrayList<Candidate>();

		Connection conn = ConnectionQLUV_FPT.connectDB();
		String sql = "SELECT Candidate_ID,Fullname,Birthday,Phone,Email,Candidate_type,Graduation_date,Graduation_rank,Education"
				+ " FROM Candidate WHERE Candidate_type = 1 ";
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ResultSet exper = ps.executeQuery();
			while (exper.next()) {
				Fresher experSQL = new Fresher();
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
				experSQL.Graduation_date = LocalDate.parse(birt2, formatter2);
				experSQL.Graduation_rank = exper.getString(8);
				experSQL.Education = exper.getString(9);
			
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

	public void ShowinfoMap() {
		Map<String, Candidate> listExper = new LinkedHashMap<String, Candidate>();

		Connection conn = ConnectionQLUV_FPT.connectDB();
		String sql = "SELECT Candidate_ID,Fullname,Birthday,Phone,Email,Candidate_type,Graduation_date,Graduation_rank,Education"
				+ " FROM Candidate WHERE Candidate_type = 1 ";
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ResultSet exper = ps.executeQuery();
			while (exper.next()) {
				Fresher experSQL = new Fresher();
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
				experSQL.Graduation_date = LocalDate.parse(birt2, formatter2);
				experSQL.Graduation_rank = exper.getString(8);
				experSQL.Education = exper.getString(9);
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

	public static List<Candidate> Showlist() {
		List<Candidate> listExper = new ArrayList<Candidate>();

		Connection conn = ConnectionQLUV_FPT.connectDB();
		String sql = "SELECT Candidate_ID,Fullname,Birthday,Phone,Email,Candidate_type,Graduation_date,Graduation_rank,Education"
				+ " FROM Candidate WHERE Candidate_type = 1 ";
		try (PreparedStatement ps = conn.prepareStatement(sql)) {

			ResultSet exper = ps.executeQuery();
			while (exper.next()) {
				Fresher experSQL = new Fresher();
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
				experSQL.Graduation_date = LocalDate.parse(birt2, formatter2);
				experSQL.Graduation_rank = exper.getString(8);
				experSQL.Education = exper.getString(9);

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
