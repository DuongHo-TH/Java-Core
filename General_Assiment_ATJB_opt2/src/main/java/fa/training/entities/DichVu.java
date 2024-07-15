package fa.training.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "DICH_VU")
public class DichVu {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MA_DV")
	private int madv;
	@Column(name = "TEN_DV")
	private String tendv;
	@Column(name = "DON_VI_TINH")
	private String donvi;
	@Column(name = "DON_GIA")
	private float dongia;
	public int getMadv() {
		return madv;
	}
	public void setMadv(int madv) {
		this.madv = madv;
	}
	public String getTendv() {
		return tendv;
	}
	public void setTendv(String tendv) {
		this.tendv = tendv;
	}
	public String getSoluong() {
		return donvi;
	}
	public void setSoluong(String soluong) {
		this.donvi = soluong;
	}
	public float getDongia() {
		return dongia;
	}
	public void setDongia(float dongia) {
		this.dongia = dongia;
	}
	public DichVu(String tendv, String soluong, float dongia) {
		super();
		this.tendv = tendv;
		this.donvi = soluong;
		this.dongia = dongia;
	}
	public DichVu() {
		super();
	}

}
