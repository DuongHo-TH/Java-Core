package General_Assignment_BTJB_opt2;

import java.lang.reflect.Array;
import java.util.Scanner;

/*
9.	Viết chương trình thực hiện công việc sau:
a.	Nhập ma trận A (m dòng, n cột) gồm các phần tử kiểu int
b.	Tính tích các số là bội số của 3 nằm trên dòng đầu tiên của ma trận 
c.	Tạo ra mảng một chiều X với X[i] là các giá trị lớn nhất trên từng dòng i của ma trận A.
*/
public class baiTap9 {
	public static void main(String[] agrs) {
		Scanner sc = new Scanner(System.in);
		int m;
		System.out.println(" Nhập số dòng của mảng : ");
		m = Integer.parseInt(sc.nextLine());
		int n;
		System.out.println("Nhập Số Cột Của Mảng: ");
		n = Integer.parseInt(sc.nextLine());
		int[][] a = new int[m][n];
		while (true) {
			System.out.println("Hãy Chọn Các Phương Thức Theo Menu Bên Dưới");
			System.out.println("1. Thêm Phần Tử vào mảng a : ");
			System.out.println("2. Tính Tích các sô là bội số của 3 nằm trên dòng đầu tiên của ma trận");
			System.out.println("3. Tạo mảng X và thêm các phần tử lớn nhất từ dòng i vào X");
			int key = Integer.parseInt(sc.nextLine());
			switch (key) {
			case 1: {

				for (int i = 0; i < m; i++) {
					for (int j = 0; j < n; j++) {
						System.out.println("Nhập Giá Trị Phần Tử " + " " + i + " " + j);
						a[i][j] = Integer.parseInt(sc.nextLine());

					}
				}
				break;
			}
			case 2: {
				int tich = 1;
				for (int i = 0; i < 1; i++) {
					for (int j = 0; j < n; j++) {
						if (a[i][j] % 3 == 0) {
							tich = tich * a[i][j];
						}

						System.out.println("Tích của tất cả bội số của 3 trong " + a[i][j] + "Là : " + tich);
					}
				}
				break;
			}
			case 3: {

				int[] x = new int[m];
				for (int i = 0; i < m; i++) {
					int giatri = a[i][0];
					for (int j = 0; j < n; j++) {
						if (a[i][j] > giatri) {
							giatri = a[i][j];
						}
						x[i] = giatri;
					}

				}
				for (int h = 0; h < m; h++) {
					System.out.println("Các Phần tử Trong X" + h + " : " + x[h]);
				}
				break;
			}

			}

		}

	}
}
