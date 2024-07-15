package gen.candidate.enitities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Candidate {
	private String CandidateID;
	private String Fullname;
	private LocalDate Birthday;
	private String Phone;
	private String Email;
	private int Candidate_type;
	static int  Canidate_count = 0 ;
	private List<Certificate> Certifi_ofCandidate;

	public abstract String showme();
	public String showinfor() {
		return "Candidate [CandidateID = " + getCandidateID() + ", Fullname = " + getFullname()
		+ ", Birthday = " + getBirthday() + ", Phone = " + getPhone() + ", Email = " + getEmail()
		+ ", Candidate_type = " + getCandidate_type() + " " + showme() 
		+ getCertifi_ofCandidate()  + "]";
	}

	public Candidate() {
		this.CandidateID = "";
		this.Fullname = "";
		this.Birthday = null;
		this.Phone = "";
		this.Email = "";
		this.Candidate_type = 0;
		this.Certifi_ofCandidate = new ArrayList<Certificate>();
	}

	public Candidate(String candi, String name, LocalDate birt, String phone, String email, int typer,
			List<Certificate> certi) {
		this.CandidateID = candi;
		this.Fullname = name;
		this.Birthday = birt;
		this.Phone = phone;
		this.Email = email;
		this.Candidate_type = typer;
		this.Certifi_ofCandidate = certi;

	}

	@Override
	public String toString() {
		return "Candidate [CandidateID = " + getCandidateID() + ", Fullname =" + getFullname()
				+ ", Birthday = " + getBirthday() + ", Phone = " + getPhone() + ", getEmail = " + getEmail()
				+ ", Candidate_type = " + getCandidate_type() + ", Certifi_ofCandidate = "
				+ getCertifi_ofCandidate() + "]";
	}

	public String getCandidateID() {
		return CandidateID;
	}

	public void setCandidateID(String candidateID) {
		CandidateID = candidateID;
	}

	public String getFullname() {
		return Fullname;
	}

	public void setFullname(String fullname) {
		Fullname = fullname;
	}

	public LocalDate getBirthday() {
		return Birthday;
	}

	public void setBirthday(LocalDate birthday) {
		Birthday = birthday;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public int getCandidate_type() {
		return Candidate_type;
	}

	public void setCandidate_type(int candidate_type) {
		Candidate_type = candidate_type;
	}

	public static int getCanidate_count() {
		return Canidate_count;
	}

	public static void setCanidate_count(int canidate_count) {
		Canidate_count = canidate_count;
	}

	public List<Certificate> getCertifi_ofCandidate() {
		return Certifi_ofCandidate;
	}

	public void setCertifi_ofCandidate(List<Certificate> certifi_ofCandidate) {
		Certifi_ofCandidate = certifi_ofCandidate;
	}
}
