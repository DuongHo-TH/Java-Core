package fa.duongho.entities;

public class StudentClass {
private String id;
private String name;
private String department;
private String poorstudent;
private String prioritystudent;
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDepartment() {
	return department;
}
public void setDepartment(String department) {
	this.department = department;
}
public String getPoorstudent() {
	return poorstudent;
}
public void setPoorstudent(String poorstudent) {
	this.poorstudent = poorstudent;
}
public String getPrioritystudent() {
	return prioritystudent;
}
public void setPrioritystudent(String prioritystudent) {
	this.prioritystudent = prioritystudent;
}
public StudentClass(String id, String name, String department, String poorstudent, String prioritystudent) {
	super();
	this.id = id;
	this.name = name;
	this.department = department;
	this.poorstudent = poorstudent;
	this.prioritystudent = prioritystudent;
}
public StudentClass() {
	super();
}
@Override
public String toString() {
	return "StudentClass [getId()=" + getId() + ", getName()=" + getName() + ", getDepartment()=" + getDepartment()
			+ ", getPoorstudent()=" + getPoorstudent() + ", getPrioritystudent()=" + getPrioritystudent() + "]";
}

}
