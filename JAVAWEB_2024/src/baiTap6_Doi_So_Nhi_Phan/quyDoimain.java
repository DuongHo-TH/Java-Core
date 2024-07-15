package baiTap6_Doi_So_Nhi_Phan;

import java.util.Scanner;

public class quyDoimain {
 public static void main (String[]args) {
	 Scanner input = new Scanner(System.in);
	 System.out.println("Nhập Số nguyên n : ");
	 int n = input.nextInt();
	 String nhiphan = quyDoiNhiPhan.converToBinary(n);
	 System.out.println("Số " + n + " Trong hệ nhị phân là: " + nhiphan);
 }




}

