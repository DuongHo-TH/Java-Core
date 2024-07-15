package General_Assignment_BTJB_opt2;

import java.util.Scanner;

public class baiTap2 {
	public static void main(String[]agrs) {
		Scanner intput = new Scanner(System.in);
		Double S = 1+ 1.0;
		System.out.println(" Hãy Nhập n : số nguyên vào phép tính");
		int n = intput.nextInt();
		
		for(int i = 2 ; i <= n; i++ ) {
			S = S /( i + 1);
			
		}
		System.out.println(" Kết Quả S = " + S);
	}

}

