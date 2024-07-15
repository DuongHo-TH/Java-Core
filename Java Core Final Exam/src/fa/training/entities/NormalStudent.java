package fa.training.entities;

import java.time.LocalDate;

public class NormalStudent extends Student {
	private double englishScore;
	private double entryTestScore;

	@Override
	public String ShowMyInfor() {
		return "EnglishScore = " + getEnglishScore() + ", EntryTestScore = " + getEntryTestScore();
	}

	@Override
	public String toString() {
		return "NormalStudent [ || EnglishScore : " + getEnglishScore() + " || EntryTestScore : " + getEntryTestScore()
				+ " || FullName : " + getFullName() + " || DoB : " + getDoB() + " || Sex : " + getSex()
				+ " || PhoneNumber : " + getPhoneNumber() + " || UniversityName : " + getUniversityName()
				+ " || GradeLevel : " + getGradeLevel() + "]";
	}

	public NormalStudent() {
		super();
		this.englishScore = 0;
		this.entryTestScore = 0;
	}

	public NormalStudent(double englishScore, double entryTestScore) {
		super();
		this.englishScore = englishScore;
		this.entryTestScore = entryTestScore;
	}

	public NormalStudent(String fullName, LocalDate doB, String sex, String phoneNumber, String universityName,
			String gradeLevel) {
		super(fullName, doB, sex, phoneNumber, universityName, gradeLevel);
	}

	public double getEnglishScore() {
		return englishScore;
	}

	public void setEnglishScore(double englishScore) {
		this.englishScore = englishScore;
	}

	public double getEntryTestScore() {
		return entryTestScore;
	}

	public void setEntryTestScore(double entryTestScore) {
		this.entryTestScore = entryTestScore;
	}

}
