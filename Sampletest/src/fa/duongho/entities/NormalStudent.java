package fa.duongho.entities;

public class NormalStudent extends Student {
	private float englishScore;
	private float entryTestScore;

	public NormalStudent() {
		super();
	}

	public NormalStudent(float englishScore, float entryTestScore) {
		super();
		this.englishScore = englishScore;
		this.entryTestScore = entryTestScore;
	}

	public float getEnglishScore() {
		return englishScore;
	}

	public void setEnglishScore(float englishScore) {
		this.englishScore = englishScore;
	}

	public float getEntryTestScore() {
		return entryTestScore;
	}

	public void setEntryTestScore(float entryTestScore) {
		this.entryTestScore = entryTestScore;
	}

	@Override
	public String toString() {
		return "NormalStudent [getEnglishScore()=" + getEnglishScore() + ", getEntryTestScore()=" + getEntryTestScore()
				+ ", getFullName()=" + getFullName() + ", getDoB()=" + getDoB() + ", getSex()=" + getSex()
				+ ", getPhoneNumber()=" + getPhoneNumber() + ", getUniversityName()=" + getUniversityName()
				+ ", getGradeLevel()=" + getGradeLevel() + "]";
	}

	@Override
	public String showinfo() {
		// TODO Auto-generated method stub
		return "NormalStudent [ EnglishScore : " + getEnglishScore() + " || EntryTestScore : " + getEntryTestScore()
				+ " || FullName : " + getFullName() + " || DoB : " + getDoB() + " || Sex : " + getSex()
				+ " || PhoneNumber : " + getPhoneNumber() + " || UniversityName : " + getUniversityName()
				+ " || GradeLevel : " + getGradeLevel() + "]";
	}

}
