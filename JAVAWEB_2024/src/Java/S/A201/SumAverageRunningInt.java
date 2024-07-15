package Java.S.A201;

public class SumAverageRunningInt {
	public static void main(String[] args) {
		int A = 1;
		int B = 100;
		int Sum = 0;
		for( int i = A ; i < B ; i ++) {
			Sum += i;
		}
		Double AVG = (double) Sum / ( B - A );
		System.out.println(" Tổng của 1 đến 100 = " + Sum);
		System.out.println("Trung Bình 1 đến 100 = " + AVG);

	}

}


