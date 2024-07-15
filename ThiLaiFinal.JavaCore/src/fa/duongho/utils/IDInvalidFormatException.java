package fa.duongho.utils;



public class IDInvalidFormatException extends Exception{
	public IDInvalidFormatException(String message) {
		super(message);
	}
	public static final String Check_ID = "^(P|N)\\d{4}$";
	public static void validateID(String fullName) throws IDInvalidFormatException {

	    if (fullName.matches(Check_ID)) {
	       return;
	    }else {
	    	 throw new IDInvalidFormatException("ID Student Sai Dịnh Dạng: " + fullName);
	    }
	}
}
