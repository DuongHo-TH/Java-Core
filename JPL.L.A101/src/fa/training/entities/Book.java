package fa.training.entities;

import java.sql.Date;
import java.util.LinkedHashSet;
import java.util.Set;

public class Book extends Publication {
 public String isbn;
 public Set<String> author;
 public String publicationPlace;
 public Book() {
	 this.isbn = "";
	 this.author = new LinkedHashSet<>();
	 this.publicationPlace = "";
 }
	public Book(String isbn, Set<String> author, String publicationPlace) {
		this.isbn = isbn;
		this.author = author;
		this.publicationPlace = publicationPlace;
		
	}
	
	
	
	public Book(int year, String publisher, Date publicationDate) {
		super(year, publisher, publicationDate);
	}
	
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public Set<String> getAuthor() {
		return author;
	}
	public void setAuthor(Set<String> author) {
		this.author = author;
	}
	public String getPublicationPlace() {
		return publicationPlace;
	}
	public void setPublicationPlace(String publicationPlace) {
		this.publicationPlace = publicationPlace;
	}
	
	@Override
	public String toString() {
		return "Book [getIsbn()=" + getIsbn() + ", getAuthor()=" + getAuthor() + ", getPublicationPlace()="
				+ getPublicationPlace() + ", getPublicationYear()=" + getPublicationYear() + ", getPublisher()="
				+ getPublisher() + ", getPublicationDate()=" + getPublicationDate() + "]";
	}
	void display() {
		System.out.println(this.toString());
		
	}


	
	

}
