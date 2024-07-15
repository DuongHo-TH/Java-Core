package GiaoHang;

import java.sql.Date;

public class Shipper {
	public Shipper(String tenSipper, Date ngaySinh, String gioiTinh, int soDTShipper, String diaChi, String truong,
			String lop, String email) {
		super();
		TenSipper = tenSipper;
		NgaySinh = ngaySinh;
		GioiTinh = gioiTinh;
		SoDTShipper = soDTShipper;
		DiaChi = diaChi;
		Truong = truong;
		Lop = lop;
		Email = email;
	}

	
	public String getTenSipper() {
		return TenSipper;
	}
	public void setTenSipper(String tenSipper) {
		TenSipper = tenSipper;
	}
	public Date getNgaySinh() {
		return NgaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		NgaySinh = ngaySinh;
	}
	public String getGioiTinh() {
		return GioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		GioiTinh = gioiTinh;
	}
	public int getSoDTShipper() {
		return SoDTShipper;
	}
	public void setSoDTShipper(int soDTShipper) {
		SoDTShipper = soDTShipper;
	}
	public String getDiaChi() {
		return DiaChi;
	}
	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}
	public String getTruong() {
		return Truong;
	}
	public void setTruong(String truong) {
		Truong = truong;
	}
	public String getLop() {
		return Lop;
	}
	public void setLop(String lop) {
		Lop = lop;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	private String TenSipper;
	private Date NgaySinh;
	private String GioiTinh;
	private int SoDTShipper;
	private String DiaChi;
	private String Truong;
	private String Lop;
	private String Email;
	
	
}
