package Java.S.A201;

import java.util.Scanner;

import javax.swing.filechooser.FileNameExtensionFilter;

public class FrequentNumber {
	public static void main(String[] agrs) {

		Scanner input = new Scanner(System.in);

		System.out.println(" Nhập Độ dài của mảng :");
		int len = input.nextInt();
		int[] Arr = new int[len];
		int i = 0;

		do {
			System.out.println("Nhập Giá Trị Của Mảng Arr : ");
			Arr[i] = input.nextInt();
			i++;
			System.out.println("Do you want to continue Y/N : ");

			String chon = input.next();
//			System.out.println(chon);
			if (chon.equalsIgnoreCase("N")) {
				break;
			}
		} while (i < len);

		System.out.println("Nhập Giá Trị muốn tìm kiếm");
		int tim = input.nextInt();
		int count = 0;
		for (int k = 0; k < Arr.length; k++) {
			
			if (Arr[k] == tim) {
				count++;
			}
			
		}System.out.println("Số Lần Xuất Hiện của" + tim + "là : " + count);
	}

}
