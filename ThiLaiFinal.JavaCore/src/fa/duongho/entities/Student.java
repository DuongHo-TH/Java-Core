package fa.duongho.entities;

import java.time.LocalDate;

public abstract class Student {
	private String studentid;
	private String studentname;
	private String sex;
	private LocalDate birtday;
	private String email;
	private String phone;
	private String graduate;
	private float exammark;
	private String department;
	private StudentClass classid;
	
	public abstract  String printMe();

	public String getStudentid() {
		return studentid;
	}

	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}

	public String getStudentname() {
		return studentname;
	}

	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public LocalDate getBirtday() {
		return birtday;
	}

	public void setBirtday(LocalDate birtday) {
		this.birtday = birtday;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getGraduate() {
		return graduate;
	}

	public void setGraduate(String graduate) {
		this.graduate = graduate;
	}

	public float getExammark() {
		return exammark;
	}

	public void setExammark(float exammark) {
		this.exammark = exammark;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public StudentClass getClassid() {
		return classid;
	}

	public void setClassid(StudentClass classid) {
		this.classid = classid;
	}

	public Student(String studentid, String studentname, String sex, LocalDate birtday, String email, String phone,
			String graduate, float exammark, String department, StudentClass classid) {
		super();
		this.studentid = studentid;
		this.studentname = studentname;
		this.sex = sex;
		this.birtday = birtday;
		this.email = email;
		this.phone = phone;
		this.graduate = graduate;
		this.exammark = exammark;
		this.department = department;
		this.classid = classid;
	}

	public Student() {
		super();
	}

	@Override
	public String toString() {
		return "Student [getStudentid()=" + getStudentid() + ", getStudentname()=" + getStudentname() + ", getSex()="
				+ getSex() + ", getBirtday()=" + getBirtday() + ", getEmail()=" + getEmail() + ", getPhone()="
				+ getPhone() + ", getGraduate()=" + getGraduate() + ", getExammark()=" + getExammark()
				+ ", getDepartment()=" + getDepartment() + ", getClassid()=" + getClassid() + "]";
	}
	
}
