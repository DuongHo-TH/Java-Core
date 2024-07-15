package fa.training.entities;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "SUDUNGDICHVU")
public class SuDungDichVu {
	@Id
	@ManyToOne
	@JoinColumn(name = "makh")
	private Khach makh;
	@Id
	@ManyToOne
	@JoinColumn(name = "madv")
	private DichVu madv;
	@Id
	@Column(name = "TEN_DV")
	private LocalDate ngaysudung;
	@Id
	@Column(name = "TEN_DV")
	private LocalTime giosudung;
	@Column(name = "TEN_DV")
	private int soluong;
	public Khach getMakh() {
		return makh;
	}
	public void setMakh(Khach makh) {
		this.makh = makh;
	}
	public DichVu getMadv() {
		return madv;
	}
	public void setMadv(DichVu madv) {
		this.madv = madv;
	}
	public LocalDate getNgaysudung() {
		return ngaysudung;
	}
	public void setNgaysudung(LocalDate ngaysudung) {
		this.ngaysudung = ngaysudung;
	}
	public LocalTime getGiosudung() {
		return giosudung;
	}
	public void setGiosudung(LocalTime giosudung) {
		this.giosudung = giosudung;
	}
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	public SuDungDichVu(Khach makh, DichVu madv, LocalDate ngaysudung, LocalTime giosudung, int soluong) {
		super();
		this.makh = makh;
		this.madv = madv;
		this.ngaysudung = ngaysudung;
		this.giosudung = giosudung;
		this.soluong = soluong;
	}
	public SuDungDichVu() {
		super();
	}
	
}
