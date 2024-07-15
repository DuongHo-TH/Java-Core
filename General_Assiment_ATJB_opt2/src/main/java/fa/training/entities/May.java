package fa.training.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "May")
public class May {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MaMay")
	private int mamay;
	@Column(name = "ViTri")
	private int vitri;
	@Column(name = "TrangThai")
	private String trangthai;

	public int getMamay() {
		return mamay;
	}

	public void setMamay(int mamay) {
		this.mamay = mamay;
	}

	public int getVitri() {
		return vitri;
	}

	public void setVitri(int vitri) {
		this.vitri = vitri;
	}

	public String getTrangthai() {
		return trangthai;
	}

	public void setTrangthai(String trangthai) {
		this.trangthai = trangthai;
	}

	public May(int vitri, String trangthai) {
		super();
		this.vitri = vitri;
		this.trangthai = trangthai;
	}

	public May() {
		super();
	}

}
