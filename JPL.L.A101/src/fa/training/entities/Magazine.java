package fa.training.entities;

import java.sql.Date;

public class Magazine extends Publication {
	private String author;
	private int volumn;
	private int edition;

	public Magazine() {
		super();
		this.author = "";
		this.edition = 0;
		this.volumn = 0;
	}

	public Magazine(String author, int volumn, int edition) {
		this.author = author;
		this.edition = edition;
		this.volumn = volumn;
	}

	public Magazine(int year, String publisher, Date publicationDate) {
		super(year, publisher, publicationDate);

	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getVolumn1() {
		return volumn;
	}

	public void setVolumn(int volumn) {
		this.volumn = volumn;
	}

	public int getEdition() {
		return edition;
	}

	public void setEdition(int edition) {
		this.edition = edition;
	}

	
	@Override
	public String toString() {
		return "Magazine [getAuthor()=" + getAuthor() + ", getVolumn()=" + getVolumn1() + ", getEdition()="
				+ getEdition() + ", getPublicationYear()=" + getPublicationYear() + ", getPublisher()=" + getPublisher()
				+ ", getPublicationDate()=" + getPublicationDate() + "]";
	}

	void display() {
		System.out.println(this.toString());
	}



}
