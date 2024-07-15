package qluvFPT;

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

	@Override
	public String toString() {
		return "Intern [getMaors()=" + getMaors() + ", getSemester()=" + getSemester() + ", getUniversity_name()="
				+ getUniversity_name() + ", getCandidateID()=" + getCandidateID() + ", getFullname()=" + getFullname()
				+ ", getBirthday()=" + getBirthday() + ", getPhone()=" + getPhone() + ", getEmail()=" + getEmail()
				+ ", getCandidate_type()=" + getCandidate_type() + "]";
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

	@Override
	public void Showinfo() {
		System.out.println(this.toString());

	}

}
