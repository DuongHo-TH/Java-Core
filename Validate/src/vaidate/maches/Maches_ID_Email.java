package vaidate.maches;

public class Maches_ID_Email {
	public static final String Check_IDAirports = "^AP\\d{5}$";
	public static final String Check_IDFixedwing = "^FW\\d{5}$";
	public static final String Check_IDHelicopter = "^RW\\d{5}$";
	public static final String check_typerFix = "^(CAG|LGR|PRV)$";
	public static final String Check_Email =  "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
            "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	public static final String Check_SDT = "^0\\[0-9]\\d[9, 13]$";
}
