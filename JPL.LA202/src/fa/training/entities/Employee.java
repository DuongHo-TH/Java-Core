package fa.training.entities;

import java.time.LocalDate;


public abstract class Employee {
	private String ssn;
	private String firstName;
	private String lastName;
	private LocalDate birthDate;
	private String phone;
	private String email;
	
	public String writer() {
		return getSsn() + ","+ getFirstName() + ","+ getLastName() + ","+ getBirthDate() +","+ getPhone() +","+ getEmail() +","+ showwriter();
	}
	@Override
	public String toString() {
		return "Employee [getSsn()=" + getSsn() + ", getFirstName()=" + getFirstName() + ", getLastName()="
				+ getLastName() + ", getBirthDate()=" + getBirthDate() + ", getPhone()=" + getPhone() + ", getEmail()="
				+ getEmail() + ", showme()=" + showme() + "]";
	}
	public Employee() {
		super();
	}
	public Employee(String ssn, String firstName, String lastName, LocalDate birthDate, String phone, String email) {
		super();
		this.ssn = ssn;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.phone = phone;
		this.email = email;
	}
	
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public LocalDate getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
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
	
public abstract String showme();
	public abstract String showwriter();
}
