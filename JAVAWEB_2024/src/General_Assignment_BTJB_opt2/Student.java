package General_Assignment_BTJB_opt2;

public class Student {
	
	    int rollno;
	    String name;
	    String city;

	    public Student(int rollno, String name, String city) {
	        this.rollno = rollno;
	        this.name = name;
	        this.city = city;
	    }

	    // Ghi đè phương thức toString()
	    public String toString() {
	        return rollno + " " + name + " " + city;
	    }

	    public static void main(String[] args) {
	        Student s1 = new Student(101, "Viet", "HaNoi");
	        Student s2 = new Student(102, "Nam", "DaNang");

	        System.out.println(s1); // Kết quả: 101 Viet HaNoi
	        System.out.println(s2); // Kết quả: 102 Nam DaNang
	    }
	

}
