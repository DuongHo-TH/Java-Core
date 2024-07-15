package fa.duongho.entities;

public class GoodStudent extends Student {
	private float gpa;
	private String bestRewardName;

	public GoodStudent() {
		super();
	}

	public GoodStudent(float gpa, String bestRewardName) {
		super();
		this.gpa = gpa;
		this.bestRewardName = bestRewardName;
	}

	public float getGpa() {
		return gpa;
	}

	public void setGpa(float gpa) {
		this.gpa = gpa;
	}

	public String getBestRewardName() {
		return bestRewardName;
	}

	public void setBestRewardName(String bestRewardName) {
		this.bestRewardName = bestRewardName;
	}

	@Override
	public String toString() {
		return "GoodStudent [getGpa()=" + getGpa() + ", getBestRewardName()=" + getBestRewardName() + ", getFullName()="
				+ getFullName() + ", getDoB()=" + getDoB() + ", getSex()=" + getSex() + ", getPhoneNumber()="
				+ getPhoneNumber() + ", getUniversityName()=" + getUniversityName() + ", getGradeLevel()="
				+ getGradeLevel() + "]";
	}

	@Override
	public String showinfo() {
		return "GoodStudent [Gpa : " + getGpa() + " || BestRewardName : " + getBestRewardName() + " || FullName : "
				+ getFullName() + " || DoB : " + getDoB() + " || Sex : " + getSex() + " || PhoneNumber : "
				+ getPhoneNumber() + " || UniversityName : " + getUniversityName() + " || GradeLevel : "
				+ getGradeLevel() + "]";
	}

}
