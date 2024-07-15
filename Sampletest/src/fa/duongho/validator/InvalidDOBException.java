package fa.duongho.validator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
@SuppressWarnings("serial")
public class InvalidDOBException extends Exception {

	public InvalidDOBException(String message) {
		super(message);
	}

	public static void valdidateDOB(String dob) throws InvalidDOBException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		try {
			dateFormat.parse(dob);
		} catch (ParseException e) {
			throw new InvalidDOBException("Ngày tháng không hợp lệ: " + dob);
		}
	}
}
