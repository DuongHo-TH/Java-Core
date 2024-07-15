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
@Table(name = "SU_DUNG_MAY")
public class SuDungMay {
	@Id
	@ManyToOne
	@JoinColumn(name = "mamay")
	private Khach makh;
	@Id
	@ManyToOne
	@JoinColumn( name = "makh")
	private May mamay;
	@Id
	@Column(name = "NGAY_BATDAU")
	private LocalDate ngaystar;
	@Id
	@Column(name = "GIO_BATDAU")
	private LocalTime timestar;
	@Column(name = "THOI_GIAN_SU_DUNG")
	private LocalTime thoigiansudung;
	public Khach getMakh() {
		return makh;
	}
	public void setMakh(Khach makh) {
		this.makh = makh;
	}
	public May getMamay() {
		return mamay;
	}
	public void setMamay(May mamay) {
		this.mamay = mamay;
	}
	public LocalDate getNgaystar() {
		return ngaystar;
	}
	public void setNgaystar(LocalDate ngaystar) {
		this.ngaystar = ngaystar;
	}
	public LocalTime getTimestar() {
		return timestar;
	}
	public void setTimestar(LocalTime timestar) {
		this.timestar = timestar;
	}
	public LocalTime getThoigiansudung() {
		return thoigiansudung;
	}
	public void setThoigiansudung(LocalTime thoigiansudung) {
		this.thoigiansudung = thoigiansudung;
	}
	public SuDungMay(Khach makh, May mamay, LocalDate ngaystar, LocalTime timestar, LocalTime thoigiansudung) {
		super();
		this.makh = makh;
		this.mamay = mamay;
		this.ngaystar = ngaystar;
		this.timestar = timestar;
		this.thoigiansudung = thoigiansudung;
	}
	public SuDungMay() {
		super();
	}

}
