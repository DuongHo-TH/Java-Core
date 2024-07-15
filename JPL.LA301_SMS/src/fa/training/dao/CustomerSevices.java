package fa.training.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fa.training.entities.Customer;

public class CustomerSevices {
public static Customer CreateCustomer(Scanner sc) {
	Customer cus = new Customer();
	System.out.println("Nhập CustomerID");
	cus.setCustomerID(Integer.parseInt(sc.nextLine()));
	System.out.println("Nhập CustomerName");
	cus.setCustomerName(sc.nextLine());
	return cus;
}
public static List<Customer> getAllCustomer() {
	List<Customer> listcustom = new ArrayList<Customer>();
	String sql = "SELECT * FROM Customer cs JOIN Orderr or on cs.customerID = or.customerID";
	try(Connection conn = Connection_SMS.connectDB(); PreparedStatement stm = conn.prepareStatement(sql);) {
		ResultSet rs = stm.executeQuery();
		while(rs.next()) {
			Customer cus = new Customer();
			cus.setCustomerID(rs.getInt(1));
			cus.setCustomerName(rs.getString(2));
			listcustom.add(cus);
		}
	} catch (SQLException e) {
		System.out.println("Không Tìm Thấy Khách Hàng Trong Database");
	}
	return listcustom;
}
}
