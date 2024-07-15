package General_Assignment_BTJB_opt2;

public class SinhVienBai12 {
	private String MaSV;
	private String TenSV;
	private String SDT;
	private String Email;
	private int Diem;

	@Override
	public String toString() {
		return "SinhVienBai12 [getMaSV()=" + getMaSV() + ", getTenSV()=" + getTenSV() + ", getSDT()=" + getSDT()
				+ ", getEmail()=" + getEmail() + ", getDiem()=" + getDiem() + "]";
	}

	public String getMaSV() {
		return MaSV;
	}

	public void setMaSV(String maSV) {
		MaSV = maSV;
	}

	public String getTenSV() {
		return TenSV;
	}

	public void setTenSV(String tenSV) {
		TenSV = tenSV;
	}

	public String getSDT() {
		return SDT;
	}

	public void setSDT(String sDT) {
		SDT = sDT;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public int getDiem() {
		return Diem;
	}

	public void setDiem(int diem) {
		Diem = diem;
	}

}
