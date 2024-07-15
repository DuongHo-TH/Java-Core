package fa.duongho.validator;


@SuppressWarnings("serial")
public class InvalidFullNameException extends Exception {
public InvalidFullNameException(String name) {
	super(name);
}
public static void validateFullName(String fullName) throws InvalidFullNameException {

    if (fullName.matches(Validate.Check_Fullname)) {
        throw new InvalidFullNameException("Họ tên không hợp lệ: " + fullName);
    }
}
}