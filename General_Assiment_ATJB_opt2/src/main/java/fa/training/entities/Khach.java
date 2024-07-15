package fa.training.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "KHACHHANG")
public class Khach {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int makh;
	@Column(name = "TEN_KH")
	private String tenKH;
	@Column(name = "DIA_CHI")
	private String diachi;
	@Column(name = "PHONE")
	private String phone;
	@Column(name = "Email")
	private String email;
	public String getTenKH() {
		return tenKH;
	}
	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getMakh() {
		return makh;
	}
	public void setMakh(int makh) {
		this.makh = makh;
	}
	public Khach(String tenKH, String diachi, String phone, String email) {
		super();
		this.tenKH = tenKH;
		this.diachi = diachi;
		this.phone = phone;
		this.email = email;
	}
	public Khach() {
		super();
	}

}
