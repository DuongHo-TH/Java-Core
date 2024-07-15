package Java.S.A201;

public class ArrayContains {
	public static void main(String[]agrs) {
		String [] Array = new String[6];
		Array[0] = "Softwe";
		Array[1] = "FPTs";
		Array[2] = "Values";
		Array[3] = "Fesher";
		Array[4] = "Academy";
		Array[5] = "2018";
		
		
		for( int i = 0 ; i<Array.length ; i++) {
			if(Array[i] == "Values") {
				System.out.println(" Tìm Thấy " +Array[i] +" Tại Vị Trí " +i);
				
			}else {
				System.out.println("Check 'Values' in Array: Contained!");
			}
				
		}
		
	}

}
