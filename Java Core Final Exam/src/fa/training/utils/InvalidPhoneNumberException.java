package fa.training.utils;

public class InvalidPhoneNumberException extends Exception {
	public InvalidPhoneNumberException(String message) {
		super(message);
	}

	public static void validatePhoneNumber(String phoneNumber) throws InvalidPhoneNumberException {

		if (phoneNumber.matches(Validate.Check_SDT)) {
			return ;
		}else {
			throw new InvalidPhoneNumberException("Số điện thoại không đúng định dạng!!! 0" + phoneNumber);
		}
	}
}
