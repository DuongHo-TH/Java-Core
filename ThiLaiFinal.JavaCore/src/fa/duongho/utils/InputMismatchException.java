package fa.duongho.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;


public class InputMismatchException extends Exception {
	public InputMismatchException(String message) {
		super(message);
	}
	public static final String Check_SDT = "^\\d{9,10}$";
	public static void valdidateDOB(String dob) throws InputMismatchException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		try {
			dateFormat.parse(dob);
		} catch (ParseException e) {
			throw new InputMismatchException("Ngày Sinh " + dob + "Không Đúng Định Dạng dd/MM/yyyy");
		}
	}
	public static void validatePhoneNumber(String phoneNumber) throws InputMismatchException {

		if (phoneNumber.matches(Check_SDT)) {
			return ;
		}else {
			throw new InputMismatchException("Số điện thoại không đúng định dạng!!! 0" + phoneNumber);
		}
	}
}
