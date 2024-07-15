package DAY1;

public class BaiTap2_1 {
    public static void main(String[]agrs) {
    	int A = (100 + 0) / 3;
    	Double B = (3.0e-6 * 10000000.1);
    	Boolean C = (true && true);
    	Boolean D = (false && true);
    	Boolean E = ((false && false) || (true && true));
    	Boolean F = (false || false) && (true && true);
    	System.out.println("(100 + 0) / 3 = " + A);
    	System.out.println("(3.0e-6 * 10000000.1) = " + B);
    	System.out.println(C);
    	System.out.println(D);
    	System.out.println(E);
    	System.out.println(F);
    }
}
