package baiTap6_Doi_So_Nhi_Phan;

public class quyDoiNhiPhan {
	 public static String converToBinary(int n) {
		 StringBuilder result = new StringBuilder();
		 while (n>0) {
			 int giatri = n % 2;
			 result.insert(0, giatri);
			 n /= 2;
		 }
		 return result.toString();
	 }
}
