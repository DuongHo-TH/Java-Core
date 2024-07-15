package fa.training.dao;
import java.util.Scanner;

import fa.training.entities.Product;

public class ProductSevices {
	public static Product CreateProduct(Scanner sc) {
		Product pr = new Product();
		
			
			System.out.println("Nhập ProductID");
			pr.setProductID(Integer.parseInt(sc.nextLine()));
			System.out.println("Nhập ProductName");
			pr.setProductName(sc.nextLine());
			System.out.println("Nhập ListPrice");
			pr.setListPrice(Double.parseDouble(sc.nextLine()));
			return pr;
	}
}