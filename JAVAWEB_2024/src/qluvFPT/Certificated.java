package qluvFPT;

import java.sql.Date;
import java.time.LocalDate;

public class Certificated {
	private String Certufucated_ID;
	private String Certificate_name;
	private String Certificate_rank;
	private LocalDate Certificate_date;

	public Certificated() {
		this.Certufucated_ID = "";
		this.Certificate_name = "";
		this.Certificate_rank = "";
		this.Certificate_date = null;

	}

	public Certificated(String id, String name, String rank, LocalDate date) {
		this.Certufucated_ID = id;
		this.Certificate_name = name;
		this.Certificate_rank = rank;
		this.Certificate_date = date;
	}

	@Override
	public String toString() {
		return "Certificated [getCertufucated_ID()=" + getCertufucated_ID() + ", getCertificate_name()="
				+ getCertificate_name() + ", getCertificate_rank()=" + getCertificate_rank()
				+ ", getCertificate_date()=" + getCertificate_date() + "]";
	}

	public String getCertufucated_ID() {
		return Certufucated_ID;
	}

	public void setCertufucated_ID(String certufucated_ID) {
		Certufucated_ID = certufucated_ID;
	}

	public String getCertificate_name() {
		return Certificate_name;
	}

	public void setCertificate_name(String certificate_name) {
		Certificate_name = certificate_name;
	}

	public String getCertificate_rank() {
		return Certificate_rank;
	}

	public void setCertificate_rank(String certificate_rank) {
		Certificate_rank = certificate_rank;
	}

	public LocalDate getCertificate_date() {
		return Certificate_date;
	}

	public void setCertificate_date(LocalDate certificate_date) {
		Certificate_date = certificate_date;
	}

}
