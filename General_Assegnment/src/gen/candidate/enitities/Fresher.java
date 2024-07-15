package gen.candidate.enitities;

import java.time.LocalDate;
import java.util.List;


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

	public String showme() {
		return "Fresher [ Graduation_date = " + getGraduation_date() + ", Graduation_rank = "
				+ getGraduation_rank() + ", Education = " + getEducation() + "]";
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




}
