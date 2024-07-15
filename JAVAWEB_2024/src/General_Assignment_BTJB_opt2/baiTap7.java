package General_Assignment_BTJB_opt2;

import java.util.Scanner;

public class baiTap7 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Nhập Chuỗi S : ");
		String S = input.next();
		
		//a, Đảo Ngược Chuỗi S
		String M = new StringBuilder(S).reverse().toString();
		System.out.println("Chuỗi đảo ngược của S là : " + M);
		
        // In ra Chuỗi S in Hoa
		String SHOA = S.toUpperCase();
		System.out.println(" Chuỗi S sau khi đổi sang chữ HOA : " + SHOA);
		
		
		// d.	Đưa ra bảng tần số xuất hiện của các kí tự trong S
		
		
		
		
		
		// e.	Trích ra chuỗi con của từ kí tự thứ n đến thứ m của S 
		System.out.print("Nhập giá trị của n: ");
        int n = input.nextInt();
        System.out.print("Nhập giá trị của m: ");
        int m = input.nextInt();
        String subString = S.substring(n, m);
        System.out.println("Chuỗi con từ kí tự thứ " + n + " đến thứ " + m + ": " + subString);
	}


}
