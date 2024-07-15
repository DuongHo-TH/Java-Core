package fa.training.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import fa.training.entities.LineItem;

public class LineItemDaoImp implements LineItemDao {

	@Override
	public void InsertLineItem(List<LineItem> lineitem) {
		String sql = "INSERT INTO LineItem([orderID], [productID], [quantity], [price]) VALUES(?, ?, ?, ?)";
		try (Connection conn = Connection_SMS.connectDB(); PreparedStatement stm = conn.prepareStatement(sql);) {
			conn.setAutoCommit(false);
			for (LineItem Line : lineitem) {
				stm.setInt(1, Line.getOrderID());
				stm.setInt(2, Line.getProductID());
				stm.setDouble(3, Line.getQuantity());
				stm.setDouble(4, Line.getPrice());
				stm.addBatch();

			}
			stm.executeBatch();
			conn.commit();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	@Override
	public void UpdateLineItem(LineItem line, int ID) {
		String sql = "UPDATE Orderr SET [orderID] = ?, [productID] = ?, [quantity] = ?, [price] = ? WHERE [orderID] = ? or [productID] = ? ";
		try (Connection conn = Connection_SMS.connectDB(); PreparedStatement stm = conn.prepareStatement(sql);) {
			stm.setInt(1, line.getOrderID());
			stm.setInt(2, line.getProductID());
			stm.setInt(3, line.getQuantity());
			stm.setDouble(4, line.getPrice());
			stm.setInt(5, ID);
			stm.setInt(6, ID);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	@Override
	public void DeleteLineItem(int ID) {
		int i = 0;
		String sql = "DELETE  LineItem WHERE [orderID] = ? or [productID] = ? ";
		try (Connection conn = Connection_SMS.connectDB(); PreparedStatement stm = conn.prepareStatement(sql);) {
			stm.setInt(1, ID);
			stm.setInt(2, ID);
			i = stm.executeUpdate();
			if (i > 0) {
				System.out.println("DELETE LineItem Thành Công");
			}
		} catch (SQLException e) {
			System.out.println("UPDATE data thất bại");
		}

	}

	@Override
	public void RetrieveLineItem(LineItem line) {
		String sql = "SELECT [orderID], [productID], [quantity], [price] FROM Employee WHERE [orderID] = ?";
		try (Connection conn = Connection_SMS.connectDB();
				PreparedStatement stm = conn.prepareStatement(sql, ResultSet.CONCUR_UPDATABLE);) {
			stm.setInt(1, line.getOrderID());
			ResultSet rs = stm.executeQuery();
			if (rs.next()) {
				rs.updateInt(1, line.getOrderID());
				rs.updateInt(2, line.getProductID());
				rs.updateInt(3, line.getQuantity());
				rs.updateDouble(4, line.getPrice());
				rs.updateRow();
				System.out.println("Update Employee Thành Công");
			} else {
				rs.updateInt(1, line.getOrderID());
				rs.updateInt(2, line.getProductID());
				rs.updateInt(3, line.getQuantity());
				rs.updateDouble(4, line.getPrice());
				rs.insertRow();
				System.out.println("Insert LineItem Thành Công");
			}
		} catch (SQLException e) {
			System.out.println("Update data LineItem Thất Bại");
		}
	}

}
