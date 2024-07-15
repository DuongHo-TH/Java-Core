package fa.duongho.entities;

import java.time.LocalDate;

public class priorityStudent extends Student {
	private String prioritytype;
	private String injuretype;

	public priorityStudent(String studentid, String studentname, String sex, LocalDate birtday, String email,
			String phone, String graduate, float exammark, String department, StudentClass classid, String prioritytype,
			String injuretype) {
		super(studentid, studentname, sex, birtday, email, phone, graduate, exammark, department, classid);
		this.prioritytype = prioritytype;
		this.injuretype = injuretype;
	}

	public priorityStudent() {
		super();
	}

	public String getPrioritytype() {
		return prioritytype;
	}

	public void setPrioritytype(String prioritytype) {
		this.prioritytype = prioritytype;
	}

	public String getInjuretype() {
		return injuretype;
	}

	public void setInjuretype(String injuretype) {
		this.injuretype = injuretype;
	}

	@Override
	public String toString() {
		return "priorityStudent [ || Prioritytype()=" + getPrioritytype() + ", getInjuretype()=" + getInjuretype()
				+ ", getStudentid()=" + getStudentid() + ", getStudentname()=" + getStudentname() + ", getSex()="
				+ getSex() + ", getBirtday()=" + getBirtday() + ", getEmail()=" + getEmail() + ", getPhone()="
				+ getPhone() + ", getGraduate()=" + getGraduate() + ", getExammark()=" + getExammark()
				+ ", getDepartment()=" + getDepartment() + ", getClassid()=" + getClassid() + "]";
	}

	@Override
	public String printMe() {
		// TODO Auto-generated method stub
		return "priorityStudent [ || Prioritytype()=" + getPrioritytype() + ", getInjuretype()=" + getInjuretype()
				+ ", getStudentid()=" + getStudentid() + ", getStudentname()=" + getStudentname() + ", getSex()="
				+ getSex() + ", getBirtday()=" + getBirtday() + ", getEmail()=" + getEmail() + ", getPhone()="
				+ getPhone() + ", getGraduate()=" + getGraduate() + ", getExammark()=" + getExammark()
				+ ", getDepartment()=" + getDepartment() + ", getClassid()=" + getClassid() + "]";
	}

}
