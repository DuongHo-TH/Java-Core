package qluvFPT;

import java.time.LocalDate;

public class Experience extends Candidate {
	protected int ExpInyear;
	protected String ProSkill;

	/*
	 * super() được sử dụng để gọi hàm khởi tạo của lớp cha. Khi tạo một đối tượng
	 * của lớp con, hàm khởi tạo của lớp cha cũng được gọi. super() thường được đặt
	 * ở đầu hàm khởi tạo của lớp con. Nó đảm bảo rằng các tài nguyên và trạng thái
	 * của lớp cha được khởi tạo trước khi khởi tạo lớp con.
	 */
	public Experience() {
		super();
		this.ExpInyear = 0;
		this.ProSkill = "";
	}

	/*
	 * this là một biến tham chiếu đến đối tượng hiện tại. Nó được sử dụng để truy
	 * cập các thành viên (biến và phương thức) của đối tượng hiện tại.
	 * để giải quyết xung đột tên giữa biến cục bộ và biến thành viên.
	 * 
	 */
	public Experience(int exp, String skill) {
		this.ExpInyear = exp;
		this.ProSkill = skill;
	}

	@Override
	public String toString() {
		return "Experience [getExpInyear()=" + getExpInyear() + ", getProSkill()=" + getProSkill()
				+ ", getCandidateID()=" + getCandidateID() + ", getFullname()=" + getFullname() + ", getBirthday()="
				+ getBirthday() + ", getPhone()=" + getPhone() + ", getEmail()=" + getEmail() + ", getCandidate_type()="
				+ getCandidate_type() + "]";
	}

	public int getExpInyear() {
		return ExpInyear;
	}

	public void setExpInyear(int expInyear) {
		ExpInyear = expInyear;
	}

	public Experience(String candi, String name, LocalDate birt, int phone, String email, int typer, int count) {
		super(candi, name, birt, phone, email, typer, count);
		// TODO Auto-generated constructor stub
	}

	public String getProSkill() {
		return ProSkill;
	}

	public void setProSkill(String proSkill) {
		ProSkill = proSkill;
	}

	@Override
	public void Showinfo() {
		System.out.println(this.toString());

	}

}
