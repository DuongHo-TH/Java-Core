package fa.training.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import fa.training.entities.Order;

public class OrderSevices {
	public static Order CreateOrder(Scanner sc) {
			Order ord = new Order();
			System.out.println("Nhập OrderID");
			ord.setOrderID(Integer.parseInt(sc.nextLine()));
			System.out.println("Nhập OrderDate");
			try {
				DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				String inputdate = sc.nextLine();
				ord.setDate(LocalDate.parse(inputdate, format));
			} catch (Exception e) {
				System.out.println("Date không đúng định dạng! vui lòng nhập lại");
			}
			System.out.println("Nhập CustomerID");
			ord.setCustomerID(Integer.parseInt(sc.nextLine()));
			System.out.println("Nhập EmployeeID");
			ord.setEmployeeID(Integer.parseInt(sc.nextLine()));
			System.out.println("Nhập Total");
			ord.setTotal(Double.parseDouble(sc.nextLine()));
			return ord;
	}
	public static List<Order> getAllOrdersByCustomerId(int customerId){
		List<Order> ListofOrder = new ArrayList<Order>();
		String sql = "SELECT OrderID, Date, CustomerID, EmployeeID, Total FROM Orderr WHERE CustomerID = ? ";
		try (Connection conn = Connection_SMS.connectDB(); PreparedStatement stm = conn.prepareStatement(sql);){
			stm.setInt(1, customerId);
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				Order ord = new Order();
				ord.setOrderID(rs.getInt(1));
				try {
					DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					String inputdate = rs.getString(2);
					ord.setDate(LocalDate.parse(inputdate, format));
				} catch (Exception e) {
					System.out.println("Date không đúng định dạng! vui lòng nhập lại");
				}
				ord.setCustomerID(rs.getInt(3));
				ord.setEmployeeID(rs.getInt(4));
				ord.setTotal(rs.getDouble(5));
			}
		} catch (SQLException e) {
			System.out.println("Không Tìm Thấy Order");
		}
		return ListofOrder;
	}
	public static Double computeOrderTotal(int orderId) {
		String sql = "  SELECT Sum(price) as total_price FROM Orderr od JOIN LineItem li on od.orderID = li.orderID group by od.orderID ";
		Double total_price = 0d;
		try (Connection conn = Connection_SMS.connectDB(); PreparedStatement stm = conn.prepareStatement(sql)){
			ResultSet rs = stm.executeQuery();
		while(rs.next()) {
			total_price = rs.getDouble(1);
		}
			
		} catch (SQLException e) {
			System.out.println("Không Tìm Thấy OrderID");
		}
		return total_price;
	}
}
