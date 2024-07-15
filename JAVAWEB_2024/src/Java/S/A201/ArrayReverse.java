package Java.S.A201;


public class ArrayReverse {
	public static void main(String[]agrs) {
		
 int[] myArray = {43, 32, 53, 23, 12, 34, 3, 12, 43, 32 };
  
    for (int i : myArray) {
		System.out.print(i + " ");
	}
 
    for (int i = myArray.length - 1; i >= 0; i--) {
	    System.out.println( + myArray[i] + " ");
	  
	}
  
 }
}
