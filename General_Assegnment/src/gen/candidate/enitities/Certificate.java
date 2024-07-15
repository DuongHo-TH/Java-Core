package gen.candidate.enitities;

import java.time.LocalDate;


public class Certificate {
	public String Certificated_ID;
	public String Certificate_Name;
	public String Certificate_Rank;
	public LocalDate Certificated_Date;

	public Certificate() {
		this.Certificated_ID = "";
		this.Certificate_Name = "";
		this.Certificate_Rank = "";
		this.Certificated_Date = null;
	}

	public Certificate(String id, String name, String rank, LocalDate date) {
		this.Certificated_ID = id;
		this.Certificate_Name = name;
		this.Certificate_Rank = rank;
		this.Certificated_Date = date;
	}

	@Override
	public String toString() {
		return "Certificate [Certificated_ID = " + getCertificated_ID() + ", Certificate_Name = "
				+ getCertificate_Name() + ", Certificate_Rank = " + getCertificate_Rank()
				+ ", Certificated_Date = " + getCertificated_Date() + "]";
	}

	public String getCertificated_ID() {
		return Certificated_ID;
	}

	public void setCertificated_ID(String certificated_ID) {
		Certificated_ID = certificated_ID;
	}

	public String getCertificate_Name() {
		return Certificate_Name;
	}

	public void setCertificate_Name(String certificate_Name) {
		Certificate_Name = certificate_Name;
	}

	public String getCertificate_Rank() {
		return Certificate_Rank;
	}

	public void setCertificate_Rank(String certificate_Rank) {
		Certificate_Rank = certificate_Rank;
	}

	public LocalDate getCertificated_Date() {
		return Certificated_Date;
	}

	public void setCertificated_Date(LocalDate certificated_Date) {
		Certificated_Date = certificated_Date;
	}

}
