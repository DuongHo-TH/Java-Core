package fa.training.main;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fa.training.house.House;
import fa.training.serivecs.HouseServiecs;
public class mainFinal {
	public static void main(String[] agrs) {
		List<House> house = new ArrayList<House>();
		Scanner sc = new Scanner(System.in);
		int key;
		do {
			System.out.println("MENU");
			System.out.println("====== EMPLOYEE MANAGEMENT SYSTEM ======");
			System.out.println("1.	InputFile");
			System.out.println("2.	InsertDatabase");
			System.out.println("3.	ShowInfor ");
			System.out.println("4.	Show Thông Tin House)");
			System.out.println("5, 	Create Department");
			System.out.println("7,   Insert File ");
			System.out.println("8,    Kết Thúc Chương Trình");
			key = Integer.parseInt(sc.nextLine());
			switch (key) {
			case 1: {
			HouseServiecs.InputHouse(house);
				break;
			}
			case 2: {
				HouseServiecs.InsertHouse(house);
				break;
			}
			case 3: {
				HouseServiecs.ShowHouse(house);
				break;
			}
			case 4: {
			for (House house2 : HouseServiecs.SelectPiceHouse()) {
				System.out.println(house2.toString());
			}	
				break;
			}
			case 5: {
				HouseServiecs.TinhGia();
				break;
			}
			case 6: {
				
				break;
			}case 7: {
				
				break;
			}
			}
		} while (key < 8);
	}
}


