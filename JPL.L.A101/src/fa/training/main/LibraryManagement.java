package fa.training.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fa.training.entities.*;
import fa.training.services.BookMagazineServices;

public class LibraryManagement {

	public static void main(String[] agrs) {
		Scanner sc = new Scanner(System.in);

		int menu;
		List<Publication> DS = new ArrayList<Publication>();
		BookMagazineServices BookMagazine1 = new BookMagazineServices(DS);
		do {

			System.out.println("======LIBRARY MANAGEMENT SYSTEM ======");
			System.out.println("1.	Add a book");
			System.out.println("2.	Add a magazine");
			System.out.println("3.	Display books and magazines");
			System.out.println("4.	Add author to book");
			System.out.println("5.	Display top 10 of magazines by volume");
			System.out.println("6.	Search book by (isbn, author, publisher)");
			System.out.println("7.      Kết Thúc Trương Trình");
			System.out.println("Please choose function you'd like to do:");
			menu = Integer.parseInt(sc.nextLine());
			switch (menu) {
			case 1: {
				BookMagazine1.createBook();
				break;
			}
			case 2: {
				BookMagazine1.createMagazine();
				break;
			}
			case 3: {
				BookMagazine1.display();
				break;
			}
			case 4: {
				BookMagazine1.setAuthorbook();
				break;
			}
			case 5 : {
			 BookMagazine1.searchMaga();
			 break;
			}
			case 6: {
				BookMagazine1.searchBook();
			}
			}
		} while (menu < 7);

	}
}
