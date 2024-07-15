package DAY1;

import java.util.Scanner;

public class CylinderComputation_2_4 {
	public static void main(String[]agrs) {
		Double R =  7.0;
		Double H = 10.0;
     final Double PI = 3.14;
        
        // Calculate base area (πr^2)
        double baseArea = PI *( R * R);

        // Calculate surface area (2πrh + 2πr^2)
        double surfaceArea = ((2 * PI) * R * H) + ((2 * PI) *( R * R));

        // Calculate volume (πr^2h)
        double volume = baseArea * H;

        // Print results
        System.out.println("Base Area: " + baseArea);
        System.out.println("Surface Area: " + surfaceArea);
        System.out.println("Volume: " + volume);
	}

}
