package fa.duongho.entities;

import java.time.LocalDate;

public class poorStudent extends Student {
	private String familylevel;
	private float monthlyincome;

	public poorStudent() {
		super();
	}

	public poorStudent(String studentid, String studentname, String sex, LocalDate birtday, String email, String phone,
			String graduate, float exammark, String department, StudentClass classid, String familylevel,
			float monthlyincome) {
		super(studentid, studentname, sex, birtday, email, phone, graduate, exammark, department, classid);
		this.familylevel = familylevel;
		this.monthlyincome = monthlyincome;
	}

	public String getFamilylevel() {
		return familylevel;
	}

	public void setFamilylevel(String familylevel) {
		this.familylevel = familylevel;
	}

	public float getMonthlyincome() {
		return monthlyincome;
	}

	public void setMonthlyincome(float monthlyincome) {
		this.monthlyincome = monthlyincome;
	}

	@Override
	public String toString() {
		return "poorStudent [getFamilylevel()=" + getFamilylevel() + ", getMonthlyincome()=" + getMonthlyincome()
				+ ", getStudentid()=" + getStudentid() + ", getStudentname()=" + getStudentname() + ", getSex()="
				+ getSex() + ", getBirtday()=" + getBirtday() + ", getEmail()=" + getEmail() + ", getPhone()="
				+ getPhone() + ", getGraduate()=" + getGraduate() + ", getExammark()=" + getExammark()
				+ ", getDepartment()=" + getDepartment() + ", getClassid()=" + getClassid() + "]";
	}

	@Override
	public String printMe() {
		return "poorStudent [getFamilylevel()=" + getFamilylevel() + ", getMonthlyincome()=" + getMonthlyincome()
		+ ", getStudentid()=" + getStudentid() + ", getStudentname()=" + getStudentname() + ", getSex()="
		+ getSex() + ", getBirtday()=" + getBirtday() + ", getEmail()=" + getEmail() + ", getPhone()="
		+ getPhone() + ", getGraduate()=" + getGraduate() + ", getExammark()=" + getExammark()
		+ ", getDepartment()=" + getDepartment() + ", getClassid()=" + getClassid() + "]";
	}

}
