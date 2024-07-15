package GiaoHang;
import java.util.ArrayList;
import java.util.Scanner;



public class GiaoHangMain {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int chon;

		int chon1;
		do {
			System.out.println("MENU");
			System.out.println("1. Thêm Thông Tin Sản Phẩm: ");
			System.out.println("2. Xóa Thông Tin Sản Phẩm: ");
			System.out.println("3. Update Thông Tin Sản Phẩm: ");
			System.out.println("4. Tính Lương Shiper:  ");
			System.out.println("5. Tìm Shipper có lương cao nhất trong tháng: ");
			System.out.println("6. Tìm Shipper có lương cao nhất trong Quý: ");
			System.out.println("7. Tìm Shipper vận chuyển đơn hàng: ");
			chon = Integer.parseInt(sc.nextLine());
			switch (chon) {
			case 1:

				break;
			case 2:
				delete();
				break;
				
			case 3:
				update();
				break;
				
			case 4:
				TinhLuong();
				break;
			
			case 5:
				TimKiem();
				break;
			case 6:
				
				System.out.println("Chon Quy.");
				chon1 = Integer.parseInt(sc.nextLine());
				
				
				do {
				switch (chon1) {
				case 1:
					System.out.println("Nhập Quý Muốn Tìm: ");
					int quy1 = Integer.parseInt(sc.nextLine());
					Quy1(quy1);
					break;
				case 2:
					System.out.println("Nhập Quý Muốn Tìm: ");
					int quy2 = Integer.parseInt(sc.nextLine());
					Quy2(quy2);
					break;
				case 3:
					System.out.println("Nhập Quý Muốn Tìm: ");
				int quy3 = Integer.parseInt(sc.nextLine());
					Quy3(quy3);
					break;
				case 4:
					System.out.println("Nhập Quý Muốn Tìm: ");
					int quy4 = Integer.parseInt(sc.nextLine());
					Quy4(quy4);
					break;
			
				}	
				}while (chon1 != 4);
				break;
			case 7:
				timdonhang();
				break;
			}
		} while (chon != 0);
	}
	private static void timdonhang() {
		System.out.println("Nhập Đơn Hàng Cần Tìm: ");
		String don = sc.nextLine();
		
		ArrayList<Shipper> danhsach = new ArrayList<>();
		danhsach.addAll(GiaoHangDao.Timdonhang(don));
		for (Shipper shipper : danhsach) {
			System.out.println("Thông Tin Shipper vận chuyển đơn hàng");
			System.out.println("TTSP: " + shipper.getTenSipper() + "\t" + "NgaySinh: " + shipper.getNgaySinh() + "\t" + "Gioi Tinh: " + shipper.getGioiTinh() + "\t" +
		"SĐT: " + shipper.getSoDTShipper() + "\t" + "DiaChi: " + shipper.getDiaChi() + "\t" +"Truong: " +shipper.getTruong()+"\t"+ "Lop: "+ shipper.getLop()
			+"\t"+"Email: "+shipper.getEmail());
		}
		
	}
	private static void Quy1(int quy) {
		
		
		System.out.println("Danh Sác Lương Trong Quý 1: ");
		
		ArrayList<LuongShip> danhsach = new ArrayList<>();
		danhsach.addAll(GiaoHangDao.TimQuy1());
		for (LuongShip luongShip : danhsach) {
			System.out.println(luongShip.getTenShiper() + "\t" + luongShip.getLuong());
		}
	}
	private static void Quy2(int quy) {
		
		
		System.out.println("Danh Sác Lương Trong Quý 2: ");
		
		ArrayList<LuongShip> danhsach = new ArrayList<>();
		danhsach.addAll(GiaoHangDao.TimQuy2());
		for (LuongShip luongShip : danhsach) {
			System.out.println(luongShip.getTenShiper() + "\t" + luongShip.getLuong());
		}
	}
	private static void Quy3(int quy) {
		
		
		System.out.println("Danh Sác Lương Trong Quý 3: ");
		
		ArrayList<LuongShip> danhsach = new ArrayList<>();
		danhsach.addAll(GiaoHangDao.TimQuy3());
		for (LuongShip luongShip : danhsach) {
			System.out.println(luongShip.getTenShiper() + "\t" + luongShip.getLuong());
		}
	}
		
		
	private static void Quy4(int quy) {
	
		System.out.println("Danh Sác Lương Trong Quý 4: ");
		
		ArrayList<LuongShip> danhsach = new ArrayList<>();
		danhsach.addAll(GiaoHangDao.TimQuy4());
		for (LuongShip luongShip : danhsach) {
			System.out.println(luongShip.getTenShiper() + "\t" + luongShip.getLuong());
		}
		}
	private static void TimKiem() {
		System.out.println("Nhập Tháng Cần Tìm: ");
		int month = Integer.parseInt(sc.nextLine());
		ArrayList<LuongShip> danhsach = new ArrayList();
		danhsach.addAll(GiaoHangDao.TimKiem(month));
		for (LuongShip luongShip : danhsach) {
			System.out.println(luongShip.getTenShiper() + "\t" + luongShip.getLuong());
		}
	}
	
	private static void TinhLuong() {
		System.out.println("Nhập Tháng Cần Tính: ");
		int month = Integer.parseInt(sc.nextLine());
		System.out.println("Nhập Năm Cần Tính: ");
		int year = Integer.parseInt(sc.nextLine());
		ArrayList<LuongShip> danhsach = new ArrayList<>();
		
		danhsach.addAll(GiaoHangDao.tinhtien(month, year));
		for (LuongShip luongShip : danhsach) {
			System.out.println(luongShip.getTenShiper() + "\t" + luongShip.getLuong());
			
		}
		
	}
	private static void insert() {
		ArrayList<SanPham> list = new ArrayList<>();
		System.out.print(" Nhập Số Lượng Sản Phẩm muốn thêm");
		int n = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < n; i++) {
			System.out.println("SanPhamID: ");
			String SanPhamID = sc.nextLine();
			
			System.out.println("DonHangID: ");
			String DonHangID = sc.nextLine();
			
			System.out.println("TenSP: ");
			String TenSP = sc.nextLine();
			
			System.out.println("TrongLuong: ");
			int TrongLuong = Integer.parseInt(sc.nextLine());
		
			
			System.out.println("LoaiHang: ");
			String LoaiHang = sc.nextLine();
			
			System.out.println("SoLuong: ");
			int SoLuong = Integer.parseInt(sc.nextLine());
			
			SanPham e = new SanPham(SanPhamID, DonHangID, TenSP, TrongLuong, LoaiHang, SoLuong);
			list.add(e);
			GiaoHangDao.insert(e);
		}
	}
	private static void delete() {
		System.out.println("Nhập SanPhamID Record cần xóa: ");
		String id =  sc.nextLine();

		SanPham delete = new SanPham();
		delete.setSanPhamID(id);
		GiaoHangDao.delete(delete);
		
		System.out.println("Xóa Thành Công Record có ID là:  " + id + " Thành Công!");
}
	private static void update() {
		ArrayList<SanPham> arr = new ArrayList<>();
		SanPham sanpham = new SanPham();
		
		System.out.println("Nhập SanPhamID Cần Update: ");
		String SanPhamID = sc.nextLine();
		sanpham.setSanPhamID(SanPhamID);
		
		System.out.print("DonHangID: ");
		String DonHang = sc.nextLine();
		sanpham.setDonHangID(DonHang);
		
		System.out.print("Nhập TenSP: ");
		String tensp = sc.nextLine();
		sanpham.setTenSP(tensp);
		
		System.out.print("Nhập Trọng Lượng: ");
		int trongluong = Integer.parseInt(sc.nextLine());
		sanpham.setTrongLuong(trongluong);
		
		System.out.print("Nhập Loại Hàng (De vo , De hu hong, Hang hoa thong thuong): ");
		String loaihang = sc.nextLine();
		sanpham.setLoaiHang(loaihang);
		
		System.out.print("Nhập Số Lượng: ");
		int soluong = Integer.parseInt(sc.nextLine());
		sanpham.setSoLuong(soluong);
		
		arr.add(sanpham);
		
		int result = GiaoHangDao.update(sanpham);
		if(result != 0) {
			System.out.println("Update thanh cong");
		}else {
			System.out.println("Update That Bai");
		}
		
	}

}
