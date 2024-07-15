package fa.training.entities;

import java.time.LocalDate;

public class GoodStudent extends Student {
	private double gpa;
	private String bestRewardName;

	@Override
	public String ShowMyInfor() {
		return "Gpa : " + getGpa() + "||  BestRewardName : " + getBestRewardName();
	}

	@Override
	public String toString() {
		return "GoodStudent [ || Gpa()=" + getGpa() + " || BestRewardName : " + getBestRewardName() + " || FullName : "
				+ getFullName() + " || DoB : " + getDoB() + " || Sex : " + getSex() + " || PhoneNumber : "
				+ getPhoneNumber() + " || UniversityName : " + getUniversityName() + " || GradeLevel : "
				+ getGradeLevel() + "]";
	}

	public GoodStudent(String fullName, LocalDate doB, String sex, String phoneNumber, String universityName,
			String gradeLevel) {
		super(fullName, doB, sex, phoneNumber, universityName, gradeLevel);
	}

	public GoodStudent() {
		super();
		this.gpa = 0;
		this.bestRewardName = "";
	}

	public GoodStudent(double gpa, String bestRewardName) {
		super();
		this.gpa = gpa;
		this.bestRewardName = bestRewardName;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	public String getBestRewardName() {
		return bestRewardName;
	}

	public void setBestRewardName(String bestRewardName) {
		this.bestRewardName = bestRewardName;
	}
}
