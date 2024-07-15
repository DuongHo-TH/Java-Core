package General_Assignment_BTJB_opt2;

import java.util.Scanner;

public class baiTap4 {
   public static void main(String[]agrs) {
	   Scanner input = new Scanner(System.in);
	   System.out.println("Nhập Giá trị của số nguyên m : ");
	   int m = input.nextInt();
	   int a;
	   int b;
	   int c;
	   int d;
	   int sum;
	   int deff;
	   if(m <=99) {
		   a = m / 10 ;
		   b = m % 10;
		   sum = a + b;
		   deff = a * b;
		   System.out.println(" Tổng của các số trong m = : " + sum );
		   System.out.println("Tích của các số trong m = : " + deff);
	   }else if(m <=999) {
		   a = m /100;
		   b = (m % 100) /10 ;
		   c = m % 10 ;
		   sum = a + b + c;
		   deff = a * b * c;
		   System.out.println(" Tổng của các số trong m = : " + sum);
		   System.out.println("Tích của các số trong m = : " + deff);
		   
	   }else {
		   a = m /1000;
		   b = (m % 1000) /100;
		   c = (m % 100) / 10;
		   d = m % 10;
		   sum = a + b + c + d;
		   deff = a * b * c * d;
		   System.out.println(" Tổng của các số trong m = : " + sum);
		   System.out.println("Tích của các số trong m = : " + deff);
	   }
   }
}
