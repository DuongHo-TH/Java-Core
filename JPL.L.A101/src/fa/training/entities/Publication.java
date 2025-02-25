package fa.training.entities;

import java.util.Date;

public abstract class Publication {
	private int publicationYear;
	private String publisher;
	private Date publicationDate;

	public Publication() {
		this.publicationYear = 0;
		this.publisher = "";
		this.publicationDate = null;
	}

	public Publication(int year, String publisher, Date publicationDate) {
		this.publicationYear = year;
		this.publisher = publisher;
		this.publicationDate = publicationDate;
	}

	public int getPublicationYear() {
		return publicationYear;
	}

	public void setPublicationYear(int publicationYear) {
		this.publicationYear = publicationYear;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Date getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}

	abstract void display();


}