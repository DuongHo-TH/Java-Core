package fa.training.utils;

public class InvalidFullNameException extends Exception {
public InvalidFullNameException(String name) {
	super(name);
}
public static void validateFullName(String fullName) throws InvalidFullNameException {

    if (fullName.matches(Validate.Check_Fullname)) {
       return;
    }else {
    	 throw new InvalidFullNameException("Họ tên không hợp lệ: " + fullName);
    }
}
}
