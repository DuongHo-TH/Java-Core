package GiaoHang;

import java.time.LocalDate;

public class LuongShip {
 private String TenShiper;
 private String IDShipper;
 private double Luong;
public LuongShip(String tenShiper, String iDShipper, double luong) {
	super();
	TenShiper = tenShiper;
	IDShipper = iDShipper;
	Luong = luong;
}

public LuongShip(String tenShiper, double luong) {
	super();
	TenShiper = tenShiper;
	Luong = luong;
}

public String getTenShiper() {
	return TenShiper;
}
public void setTenShiper(String tenShiper) {
	TenShiper = tenShiper;
}
public String getIDShipper() {
	return IDShipper;
}
public void setIDShipper(String iDShipper) {
	IDShipper = iDShipper;
}
public double getLuong() {
	return Luong;
}
public void setLuong(double luong) {
	Luong = luong;
}
 
}
