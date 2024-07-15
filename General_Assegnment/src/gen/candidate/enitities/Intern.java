package gen.candidate.enitities;

import java.time.LocalDate;
import java.util.List;


public class Intern extends Candidate{
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

	
	public String showme() {
		return "Intern [ Maors = " + getMaors() + ", Semester = " + getSemester()
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

	

}
