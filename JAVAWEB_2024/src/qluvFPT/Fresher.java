package qluvFPT;

import java.time.LocalDate;

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
	public Fresher(LocalDate date, String rank, String edu ) {
		this.Graduation_date = date;
		this.Graduation_rank = rank;
		this.Education = edu;
	}

	@Override
	public String toString() {
		return "Fresher [Graduation_date=" + Graduation_date + ", Graduation_rank=" + Graduation_rank + ", Education="
				+ Education + ", getGraduation_date()=" + getGraduation_date() + ", getGraduation_rank()="
				+ getGraduation_rank() + ", getEducation()=" + getEducation() + ", getCandidateID()=" + getCandidateID()
				+ ", getFullname()=" + getFullname() + ", getBirthday()=" + getBirthday() + ", getPhone()=" + getPhone()
				+ ", getEmail()=" + getEmail() + ", getCandidate_type()=" + getCandidate_type()  + "]";
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

	@Override
	public void Showinfo() {
		// TODO Auto-generated method stub

	}
}