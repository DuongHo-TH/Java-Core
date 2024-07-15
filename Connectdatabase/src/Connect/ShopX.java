package Connect;

import java.time.LocalDate;

public class ShopX {

	public ShopX() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ShopX(String maorder, String tenKH, String sDT, String tenSP, int soLuong, int donGia, LocalDate thoiGian) {
		super();
		Maorder = maorder;
		TenKH = tenKH;
		SDT = sDT;
		TenSP = tenSP;
		SoLuong = soLuong;
		DonGia = donGia;
		ThoiGian = thoiGian;
	}
	public String getMaorder() {
		return Maorder;
	}
	public void setMaorder(String maorder) {
		Maorder = maorder;
	}
	public String getTenKH() {
		return TenKH;
	}
	public void setTenKH(String tenKH) {
		TenKH = tenKH;
	}
	public String getSDT() {
		return SDT;
	}
	public void setSDT(String sDT) {
		SDT = sDT;
	}
	public String getTenSP() {
		return TenSP;
	}
	public void setTenSP(String tenSP) {
		TenSP = tenSP;
	}
	public int getSoLuong() {
		return SoLuong;
	}
	public void setSoLuong(int soLuong) {
		SoLuong = soLuong;
	}
	public int getDonGia() {
		return DonGia;
	}
	public void setDonGia(int donGia) {
		DonGia = donGia;
	}
	public LocalDate getThoiGian() {
		return ThoiGian;
	}
	public void setThoiGian(LocalDate thoiGian) {
		ThoiGian = thoiGian;
	}
	private String Maorder;
	private String TenKH;
	private String SDT;
	private String TenSP;
	private int SoLuong;
	private int DonGia;
	private LocalDate ThoiGian;

	}