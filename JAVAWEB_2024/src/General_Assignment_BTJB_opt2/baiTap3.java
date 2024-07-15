package General_Assignment_BTJB_opt2;

import java.util.Scanner;

public class baiTap3 {
	public static void main(String[]agrs) {
		Scanner input = new Scanner(System.in);
		System.out.println("Nhập Số Nguyên a: ");
		int a = input.nextInt();
		System.out.println("Nhập Số Nguyên b: ");
		int b = input.nextInt();
		int USLN = a / b;
		System.out.println("Ước Số Lớn Nhất Của 2 số a , b là : " + USLN);
		
		
		int BSNN = (a*b) / USLN;
		System.out.println("Bội Số Nhỏ Nhất Của 2 số a, b là : " + BSNN);
	}

}
