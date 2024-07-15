package fa.training.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fa.training.entities.LineItem;

public class LineItemSevices {
public static LineItem CreateLine(Scanner sc) {
	LineItem line = new LineItem();
	System.out.println("Nhập OrderID");
	line.setOrderID(Integer.parseInt(sc.nextLine()));
	System.out.println("Nhập ProductID");
	line.setProductID(Integer.parseInt(sc.nextLine()));
	System.out.println("Nhập Quantity");
	line.setQuantity(Integer.parseInt(sc.nextLine()));
	System.out.println("Nhập Price");
	line.setPrice(Double.parseDouble(sc.nextLine()));
	return line;
}

public static List<LineItem> getAllItemsByOrderId(int orderId){
	List<LineItem> listitem = new ArrayList<LineItem>();
	String sql = "SELECT * FROM LineItem WHERE [orderID] = ?";
	try (Connection conn = Connection_SMS.connectDB(); PreparedStatement stm = conn.prepareStatement(sql)){
		stm.setInt(1, orderId);
		ResultSet rs = stm.executeQuery();
		while(rs.next()) {
			LineItem item = new LineItem();
			item.setOrderID(rs.getInt(1));
			item.setProductID(rs.getInt(2));
			item.setQuantity(rs.getInt(3));
			item.setPrice(rs.getDouble(4));
			listitem.add(item);
		}
	} catch (SQLException e) {
		System.out.println("Không tìm thấy orderrID trong database");
	}
	return listitem;
}
}
