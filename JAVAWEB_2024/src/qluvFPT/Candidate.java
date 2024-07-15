package qluvFPT;

import java.sql.Date;
import java.time.LocalDate;

public abstract class Candidate {
	private String CandidateID;
	private String Fullname;
	private LocalDate Birthday;
	private int Phone;
	private String Email;
	private int Candidate_type;
	static int Canidate_count = 0;


	public static void Canidate_count() {
		Canidate_count++;
	}

	public Candidate() {
		this.CandidateID = "";
		this.Fullname = "";
		this.Birthday = null;
		this.Phone = 0;
		this.Email = "";
		this.Candidate_type = 0;

	}

	public Candidate(String candi, String name, LocalDate birt, int phone, String email, int typer, int count) {
		this.CandidateID = candi;
		this.Fullname = name;
		this.Birthday = birt;
		this.Phone = phone;
		this.Email = email;
		this.Candidate_type = typer;

	}

	@Override
	public String toString() {
		return "Candidate [getCandidateID()=" + getCandidateID() + ", getFullname()=" + getFullname()
				+ ", getBirthday()=" + getBirthday() + ", getPhone()=" + getPhone() + ", getEmail()=" + getEmail()
				+ ", getCandidate_type()=" + getCandidate_type() + "]";
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

	public int getPhone() {
		return Phone;
	}

	public void setPhone(int phone) {
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

	public abstract void Showinfo();
}
