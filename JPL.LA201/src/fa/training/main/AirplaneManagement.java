package fa.training.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import fa.training.entities.Airports;
import fa.training.entities.Fixedwing;
import fa.training.entities.Helicopter;
import fa.training.sevrvices.AirportsServices;

public class AirplaneManagement {
	public static void main(String[] agrs) {
		Scanner sc = new Scanner(System.in);
		List<Airports> listofAirports = new ArrayList<Airports>();
		int key;
		do {
			System.out.println("====== Menu AirplaneManagement =======");
			System.out.println("1, Quản Lý Sân Bay");
			System.out.println("2,Quản Lý Máy Bay Cánh Cố Định");
			System.out.println("3, Quản Lý May Bay Trực Thăng");
			System.out.println("4, Đóng Trương Trình");
			key = Integer.parseInt(sc.nextLine());
			switch (key) {
			case 1: {
				do {
					System.out.println("Chọn Chức Năng Bạn Muốn Thực Hiện");
					System.out.println("1, Hiển thị danh sách thông tin tất cả sân bay");
					System.out.println("2, Hiển thị trạng thái của một sân bay, tìm theo Airports_ID");
					System.out.println("3, Insert Thông tin sân bay mới");
					int menuAirport = Integer.parseInt(sc.nextLine());
					switch (menuAirport) {
					case 1: { 
						display(listofAirports);
						break;
					}
					case 2: {
						showAirport(listofAirports, sc);
						break;
					}
					case 3: {
						listofAirports.add(AirportsServices.createAirports(sc));
						break;
					}

					}
					System.out.println("Bạn Có Muốn Quay Lại Menu AirplaneManagement. Chọn Y/N");
					String chon = sc.nextLine();
					if (chon.equalsIgnoreCase("y")) {
						break;
					}
				} while (true);
			}
			case 2: {
				do {
					System.out.println(" Menu Quản Lý Máy Bay Cánh Cố Định");
					System.out.println("Chọn Chức Năng Bạn Muốn Thực Hiện");
					System.out.println("1, Hiển Thị Danh Sách Tất Cả Máy Bay Cánh Cố Định");
					System.out.println("2, Insert Thông tin máy bay mới vào sân bay");
					System.out.println("3, Xoá Thông tin máy bay khỏi sân bay");
					System.out.println("4, Update Thông tin Loại Máy Bay Cố định và Kích Thước Đường Băng ");
					int menuAirport = Integer.parseInt(sc.nextLine());
					switch (menuAirport) {
					case 1: {
						displayFixed(listofAirports);
						break;
					}
					case 2: {
						addFixdwing(listofAirports, sc);
						break;
					}
					case 3: {
						deleteFixdwing(listofAirports, sc);
						break;
					}
					case 4: {
						updateFixdwing(listofAirports, sc);
						break;
					}
					}
					System.out.println("Bạn Có Muốn Quay Lại Menu AirplaneManagement. Chọn Y/N");
					String chon = sc.nextLine();
					if (chon.equalsIgnoreCase("y")) {
						break;
					}
				} while (true);
			}

			case 3: {
				do {
					System.out.println(" Menu Quản Lý Máy Bay Trực Thăng");
					System.out.println("Chọn Chức Năng Bạn Muốn Thực Hiện");
					System.out.println("1, Hiển Thị Danh Sách Tất Cả Máy Bay Trực Thăng");
					System.out.println("2, Insert Thông tin máy bay mới vào sân bay");
					System.out.println("3, Xoá Thông tin máy bay khỏi sân bay");
					int menuAirport = Integer.parseInt(sc.nextLine());
					switch (menuAirport) {
					case 1: {
						displayHeli(listofAirports);
						break;
					}
					case 2: {
						addHelicopter(listofAirports, sc);
						break;
					}
					case 3: {
						deleteHelicopter(listofAirports, sc);
						break;
					}
					}
					System.out.println("Bạn Có Muốn Quay Lại Menu AirplaneManagement. Chọn Y/N");
					String chon = sc.nextLine();
					if (chon.equalsIgnoreCase("y")) {
						break;
					}
				} while (true);
			}

			}
		} while (key < 4);
	}

	public static void addFixdwing(List<Airports> listair, Scanner sc) {
		System.out.println("Nhập Airports_ID của sân bay cần thêm máy bay");
		String IDAirports = sc.nextLine();
		for (Airports airports : listair) {
			if (airports.getAirports_ID().equals(IDAirports)) {
				airports.setListofFixedwingID(AirportsServices.createFixed(airports.getListofFixedwingID(), sc));
			}
		}
	}

	public static void addHelicopter(List<Airports> listair, Scanner sc) {
		System.out.println("Nhập Airports_ID của sân bay cần thêm máy bay");
		String IDAirports = sc.nextLine();
		for (Airports airports : listair) {
			if (airports.getAirports_ID().equals(IDAirports)) {
				airports.setListofHelicopterID(AirportsServices.createHelicop(airports.getListofHelicopterID(), sc));
			}
		}
	}
	public static void deleteFixdwing(List<Airports> lista, Scanner sc) {
		System.out.println("Nhập ID Sân Bay ");
		String IDAir = sc.nextLine();
		System.out.println("Nhập ID Máy Bay Cần Xóa");
		String IDFix = sc.nextLine();
		for (Airports airports : lista) {
			if(airports.getAirports_ID().equals(IDAir)) {
				for (Fixedwing fix : airports.getListofFixedwingID()) {
					if(fix.getPlane_ID().equals(IDFix)) {
						airports.getListofFixedwingID().remove(fix);
					}
				}
					
				
			}
		}
	}
	public static void deleteHelicopter(List<Airports> lista, Scanner sc) {
		System.out.println("Nhập ID Sân Bay ");
		String IDAir = sc.nextLine();
		System.out.println("Nhập ID Máy Bay Cần Xóa");
		String IDFix = sc.nextLine();
		for (Airports airports : lista) {
			if(airports.getAirports_ID().equals(IDAir)) {
				for (Helicopter fix : airports.getListofHelicopterID()) {
					if(fix.getPlane_ID().equals(IDFix)) {
						airports.getListofHelicopterID().remove(fix);
					}
				}
					
				
			}
		}
	}
	public static void updateFixdwing(List<Airports> lista, Scanner sc) {
		System.out.println("Nhập ID Sân Bay ");
		String IDAir = sc.nextLine();
		System.out.println("Nhập ID Máy Bay Cần Xóa");
		String IDFix = sc.nextLine();
		for (Airports airports : lista) {
			if(airports.getAirports_ID().equals(IDAir)) {
				for (Fixedwing fix : airports.getListofFixedwingID()) {
					if(fix.getPlane_ID().equals(IDFix)) {
						System.out.println("Nhập type mới của máy cần update");
						fix.setFly_Type(sc.nextLine());
						System.out.println("Nhập Kích Thước Tối Thiểu Của Đường Băng Cần Update");
						fix.setMinNeeded_RunwaySize(Integer.parseInt(sc.nextLine()));
					}
				}
					
				
			}
		}
	}
	public static void display(List<Airports> ai) {
		Collections.sort(ai, Comparator.comparing(Airports :: getAirports_ID));
		for (Airports airports : ai) {
			System.out.println(airports.toString());
		}
	}
	public static void showAirport(List<Airports> air, Scanner sc) {
		System.out.println("Nhập ID Sân Bay Cần Tìm Kiếm Thông Tin");
		String AirID = sc.nextLine();
		for (Airports airports : air) {
			if(airports.equals(AirID)) {
				System.out.println(airports.toString());
			}
		}
	}
	public static void displayFixed(List<Airports> ai) {
		for (Airports airports : ai) {
			System.out.println(airports.getAirports_ID() + airports.getAirports_Name()+ airports.getListofFixedwingID().toString());
		}
	}
	public static void displayHeli(List<Airports> ai) {
		for (Airports airports : ai) {
			System.out.println(airports.getAirports_ID() + airports.getAirports_Name()+ airports.getListofHelicopterID().toString());
		}
	}
}
