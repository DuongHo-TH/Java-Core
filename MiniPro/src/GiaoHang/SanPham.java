package GiaoHang;

public class SanPham {
	public SanPham() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SanPham(String sanPhamID, String donHangID, String tenSP, int trongLuong, String loaiHang, int soLuong) {
		super();
		SanPhamID = sanPhamID;
		DonHangID = donHangID;
		TenSP = tenSP;
		TrongLuong = trongLuong;
		LoaiHang = loaiHang;
		SoLuong = soLuong;
	}
	public String getSanPhamID() {
		return SanPhamID;
	}
	public void setSanPhamID(String sanPhamID) {
		SanPhamID = sanPhamID;
	}
	public String getDonHangID() {
		return DonHangID;
	}
	public void setDonHangID(String donHangID) {
		DonHangID = donHangID;
	}
	public String getTenSP() {
		return TenSP;
	}
	public void setTenSP(String tenSP) {
		TenSP = tenSP;
	}
	public int getTrongLuong() {
		return TrongLuong;
	}
	public void setTrongLuong(int trongLuong) {
		TrongLuong = trongLuong;
	}
	public String getLoaiHang() {
		return LoaiHang;
	}
	public void setLoaiHang(String loaiHang) {
		LoaiHang = loaiHang;
	}
	public int getSoLuong() {
		return SoLuong;
	}
	public void setSoLuong(int soLuong) {
		SoLuong = soLuong;
	}
	private String SanPhamID;
	private String DonHangID;
	private String TenSP;
	private int TrongLuong;
	private String LoaiHang;
	private int SoLuong;
	
	
}
