package gen.candidate.enitities;

import java.time.LocalDate;
import java.util.List;

public class Expericence extends Candidate {
	protected int ExpInyear;
	protected String ProSkill;

	public Expericence() {
		super();
		this.ExpInyear = 0;
		this.ProSkill = "";
	}

	public Expericence(int exp, String skill) {
		this.ExpInyear = exp;
		this.ProSkill = skill;
	}

	public Expericence(String candi, String name, LocalDate birt, String phone, String email, int typer,
			List<Certificate> certi) {
		super(candi, name, birt, phone, email, typer, certi);
	}

	public String showme() {
		return "Expericence [ ExpInyear = " + getExpInyear() + ", ProSkill = " + getProSkill() + "]";
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

	
}
