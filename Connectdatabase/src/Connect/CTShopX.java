package Connect;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;



    public class CTShopX {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int chon;

		do {
			System.out.println("MENU");
			System.out.println("1. Thêm Thông Tin Oder: ");
			System.out.println("2. Hiển Thị Tất Cả Thông Tin Order: ");
			System.out.println("3. Hiển Thị Thông tin tất cả order ngày hiện tại: ");
			System.out.println("4. Cập Nhật Đơn Giá Tất Cả order Iphone15: ");
			System.out.println("5.Sắp Xếp Thông Tin Theo Ngày và Mã Order: ");
			chon = Integer.parseInt(sc.nextLine());
			switch (chon) {
			case 1:
				insert();
				break;
			case 2:
				display();
				break;
				
			case 3:
				
				break;
				
			case 4:
				
				break;
			
			case 5:
				
				break;
		
			}
		} while (chon != 0);
	}
	private static void insert() {
		ArrayList<ShopX> list = new ArrayList<>();
		System.out.print(" Nhập Số Lượng Order muốn thêm");
		int n = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < n; i++) {
			System.out.println("MaOrder: ");
			String Maorder = sc.nextLine();
			
			System.out.println("TenKH: ");
			String TenKH = sc.nextLine();
			
			System.out.println("SDT: ");
			String SDT = sc.nextLine();
			
			System.out.println("TenSP: ");
			String TenSP = sc.nextLine();
			
			System.out.println("SoLuong: ");
			int SoLuong = Integer.parseInt(sc.nextLine());
			
			System.out.println("DonGia: ");
			int DonGia = Integer.parseInt(sc.nextLine());
			
			System.out.println("ThoiGianDatHang: ");
			LocalDate ThoiGian = LocalDate.parse(sc.next());
			java.sql.Date ThoiGian1 = java.sql.Date.valueOf(ThoiGian);
			ShopX e = new ShopX(Maorder, TenKH, SDT, TenSP, SoLuong, DonGia, ThoiGian);
			list.add(e);
			ShopXdao.insert(e);
		}
	}
	private static void display() {
		ArrayList<ShopX> arr = new ArrayList<>();
		arr.addAll(ShopXdao.display());
		if (arr.size() != 0) {
			for (ShopX pt : arr) {
				System.out.println(pt.getMaorder() + "\t" + pt.getTenKH() + "\t" + pt.getSDT() + "\t" + pt.getTenSP()
						+ "\t" + pt.getSoLuong() + "\t" + pt.getDonGia());
			}
			
		}
	}
	

}
