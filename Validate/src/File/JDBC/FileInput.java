package File.JDBC;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;



public class FileInput {
        public static List<Object> Input() {
        	try (BufferedReader reader = new BufferedReader(new FileReader("D:/Data_CSV/ex_Employee.csv"));
    				FileWriter errorWriter = new FileWriter("D:/Data_CSV/erro.txt")) {
			} catch (IOException e) {
				System.out.println("Input File thất bại!");
			}
			return null;
        }
}
