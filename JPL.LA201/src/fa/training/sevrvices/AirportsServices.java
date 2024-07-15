package fa.training.sevrvices;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fa.training.entities.Airports;
import fa.training.entities.Fixedwing;
import fa.training.entities.Helicopter;
import fa.training.utils.validator;

public class AirportsServices {
	public static Airports createAirports(Scanner sc) {
		Airports airp = new Airports();
		do {
			System.out.println("Nhập ID Sân Bay, Bắt Đầu Bằng : AP ");
			String ID = sc.nextLine();
			if (ID.matches(validator.Check_IDAirports)) {
				airp.setAirports_ID(ID);
			}
			System.out.println("Nhập Tên Sân Bay");
			airp.setAirports_Name(sc.nextLine());
			System.out.println("Nhập Kich Thước Đường Băng");
			airp.setRunway_Size(Integer.parseInt(sc.nextLine()));
			System.out.println("Số Lượng Đậu Tối Đa Máy Bay Cánh Cố Định");
			airp.setMaxFixedwingParkingPlace(Integer.parseInt(sc.nextLine()));
			do {
				airp.setListofFixedwingID(AirportsServices.createFixed(airp.getListofFixedwingID(), sc));
				System.out.println("Bạn Có Muốn Nhập Thêm ID Máy Bay Cánh Cố Định, Chọn Y/N :");
				String next = sc.nextLine();
				if (next.equalsIgnoreCase("n"))
					;
				{
					break;
				}
			} while (true);

			System.out.println("Số Lượng Đỗ Máy Bay Trực Thăng Tối Đa");
			airp.setMaxRotatedwingParkingPlace(Integer.parseInt(sc.nextLine()));
			do {
				airp.setListofHelicopterID(AirportsServices.createHelicop(airp.getListofHelicopterID(), sc));
				System.out.println("Bạn Có Muốn Nhập Thêm ID Máy Bay Cánh Cố Định, Chọn Y/N :");
				String next = sc.nextLine();
				if (next.equalsIgnoreCase("n"))
					;
				{
					break;
				}
			} while (true);
			break;
		} while (true);
		return airp;
	}

	public static List<Fixedwing> createFixed(List<Fixedwing> listoffix, Scanner sc) {

		do {
			Fixedwing fix = new Fixedwing();
			System.out.println("Nhập ID Máy Bay, Bắt Đầu Bằng : FW");
			String ID = sc.nextLine();
			if (ID.matches(validator.Check_IDFixedwing)) {
				fix.setPlane_ID(ID);
			}
			System.out.println("Nhập Tên Mẫu Máy Bay");
			fix.setPlane_Model(sc.nextLine());
			System.out.println("Nhập Ký Hiệu Loại Máy Bay : CAG (Cargo), LGR (Long range), PRV (Private) ");
			String typer = sc.nextLine();
			if (typer.matches(validator.check_typerFix)) {
				fix.setFly_Type(typer);
			}
			System.out.println("Nhập Tốc Độ Máy Bay");
			fix.setCruise_Speed(sc.nextLine());
			System.out.println("Nhập Trọng Lượng Rỗng của máy bay");
			fix.setEmpty_Weight(Integer.parseInt(sc.nextLine()));
			System.out.println("Trọng Lượng Cất Cánh Tối Đa");
			fix.setMaxTakeoff_Weight(Integer.parseInt(sc.nextLine()));
			System.out.println("Kích Thước Đường Băng Tối Thiểu");
			fix.setMinNeeded_RunwaySize(Integer.parseInt(sc.nextLine()));
			listoffix.add(fix);
			System.out.println("Bạn Có Muốn Nhập Thêm  Máy Bay Cánh Cố Định, Chọn Y/N :");
			String next = sc.nextLine();
			if (next.equalsIgnoreCase("n"))
				;
			{
				break;
			}
		} while (true);
		return listoffix;
	}

	public static List<Helicopter> createHelicop(List<Helicopter> listofheli, Scanner sc) {

		do {
			Helicopter heli = new Helicopter();
			System.out.println("Nhập ID Máy Bay, Bắt Đầu Bằng : FW");
			String ID = sc.nextLine();
			if (ID.matches(validator.Check_IDHelicopter)) {
				heli.setPlane_ID(ID);
			}
			System.out.println("Nhập Tên Mẫu Máy Bay");
			heli.setPlane_Model(sc.nextLine());
			System.out.println("Nhập Tốc Độ Máy Bay");
			heli.setCruise_Speed(sc.nextLine());
			System.out.println("Nhập Trọng Lượng Rỗng của máy bay");
			heli.setEmpty_Weight(Integer.parseInt(sc.nextLine()));
			System.out.println("Trọng Lượng Cất Cánh Tối Đa");
			heli.setMaxTakeoff_Weight(Integer.parseInt(sc.nextLine()));
			System.out.println("Khoảng Cách Có Thể Bay");
			heli.setRanger(sc.nextLine());
			listofheli.add(heli);
			System.out.println("Bạn Có Muốn Nhập Thêm  Máy Bay Cánh Cố Định, Chọn Y/N :");
			String next = sc.nextLine();
			if (next.equalsIgnoreCase("n"))
				;
			{
				break;
			}
		} while (true);
		return listofheli;
	}
}
