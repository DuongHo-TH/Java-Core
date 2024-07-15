package fa.candidate.enitities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import fa.candidate.main.ConnectionQLUV_FPT;

public class Intern extends Candidate {
	protected String Maors;
	protected int Semester;
	protected String University_name;

	public Intern() {
		super();
		this.Maors = "";
		this.Semester = 0;
		this.University_name = "";
	}

	public Intern(String maors, int semester, String univers) {
		this.Maors = maors;
		this.Semester = semester;
		this.University_name = univers;
	}

	public Intern(String candi, String name, LocalDate birt, String phone, String email, int typer,
			List<Certificate> certi) {
		super(candi, name, birt, phone, email, typer, certi);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Intern [CandidateID = " + getCandidateID() + ", Fullname = " + getFullname() + ", Birthday = "
				+ getBirthday() + ", Phone = " + getPhone() + ", Email = " + getEmail() + ", Candidate_type = "
				+ getCandidate_type() + ", Maors = " + getMaors() + ", Semester = " + getSemester()
				+ ",University_name = " + getUniversity_name() + "]";
	}

	public String getMaors() {
		return Maors;
	}

	public void setMaors(String maors) {
		Maors = maors;
	}

	public int getSemester() {
		return Semester;
	}

	public void setSemester(int semester) {
		Semester = semester;
	}

	public String getUniversity_name() {
		return University_name;
	}

	public void setUniversity_name(String university_name) {
		University_name = university_name;
	}

	public void Showinfo() {
		List<Candidate> listExper = new ArrayList<>();

		Connection conn = ConnectionQLUV_FPT.connectDB();
		String sql = "SELECT Candidate_ID,Fullname,Birthday,Phone,Email,Candidate_type,Maors,Semester,University_name"
				+ " FROM Candidate WHERE Candidate_type = 2 ";
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ResultSet exper = ps.executeQuery();
			while (exper.next()) {
				Intern experSQL = new Intern();
				experSQL.setCandidateID(exper.getString(1));
				experSQL.setFullname(exper.getString(2));
				String birt = exper.getString(3);
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				experSQL.setBirthday(LocalDate.parse(birt, formatter));
				experSQL.setPhone(exper.getString(4));
				experSQL.setEmail(exper.getString(5));
				experSQL.setCandidate_type(exper.getInt(6));
				experSQL.Maors = exper.getString(7);
				experSQL.Semester = exper.getInt(8);
				experSQL.University_name = exper.getString(9);
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
		LinkedHashMap<String, Candidate> listExper = new LinkedHashMap<>();

		Connection conn = ConnectionQLUV_FPT.connectDB();
		String sql = "SELECT Candidate_ID,Fullname,Birthday,Phone,Email,Candidate_type,Maors,Semester,University_name"
				+ " FROM Candidate WHERE Candidate_type = 2 ";
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ResultSet exper = ps.executeQuery();
			while (exper.next()) {
				Intern experSQL = new Intern();
				experSQL.setCandidateID(exper.getString(1));
				experSQL.setFullname(exper.getString(2));
				String birt = exper.getString(3);
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				experSQL.setBirthday(LocalDate.parse(birt, formatter));
				experSQL.setPhone(exper.getString(4));
				experSQL.setEmail(exper.getString(5));
				experSQL.setCandidate_type(exper.getInt(6));
				experSQL.Maors = exper.getString(7);
				experSQL.Semester = exper.getInt(8);
				experSQL.University_name = exper.getString(9);

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
			System.out.println(value);
		}
	}

	public static List<Intern> showlist() {
		List<Intern> experSQL1 = new ArrayList<Intern>();
		Connection conn = ConnectionQLUV_FPT.connectDB();
		String sql = "SELECT Candidate_ID,Fullname,Birthday,Phone,Email,Candidate_type,Maors,Semester,University_name"
				+ " FROM Candidate WHERE Candidate_type = 2 ";

		try (PreparedStatement ps = conn.prepareStatement(sql)) {

			ResultSet exper = ps.executeQuery();
			while (exper.next()) {
				Intern experSQL = new Intern();
				experSQL.setCandidateID(exper.getString(1));
				experSQL.setFullname(exper.getString(2));
				String birt = exper.getString(3);
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				experSQL.setBirthday(LocalDate.parse(birt, formatter));
				experSQL.setPhone(exper.getString(4));
				experSQL.setEmail(exper.getString(5));
				experSQL.setCandidate_type(exper.getInt(6));
				experSQL.Maors = exper.getString(7);
				experSQL.Semester = exper.getInt(8);
				experSQL.University_name = exper.getString(9);

				experSQL1.add(experSQL);
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
		return experSQL1;

	}

}
