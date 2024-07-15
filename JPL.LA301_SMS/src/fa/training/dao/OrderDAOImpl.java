package fa.training.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import fa.training.entities.Order;

public class OrderDAOImpl implements OrderDAO {

	@Override
	public void InsertOrder(List<Order> order) {
		String sql = "INSERT INTO Orderr([orderID], [date], [customerID], [employeeID], [total]) VALUES(?, ?, ?, ?, ?)";
		try (Connection conn = Connection_SMS.connectDB(); PreparedStatement stm = conn.prepareStatement(sql);) {
			conn.setAutoCommit(false);
			for (Order order2 : order) {
				stm.setInt(1, order2.getOrderID());
				stm.setObject(2, order2.getDate());
				stm.setInt(3, order2.getCustomerID());
				stm.setInt(4, order2.getEmployeeID());
				stm.setDouble(5, order2.getTotal());
				stm.addBatch();
			}
			stm.executeBatch();
			conn.commit();
		} catch (SQLException e) {
			System.out.println("INSERT data thất bại");
		}

	}

	@Override
	public void UpdateOrder(Order ord) {
		String sql = "UPDATE Orderr SET [date] = ?, [customerID] = ?, [employeeID] = ? , [total] = ? WHERE [orderID] = ? ";
		try (Connection conn = Connection_SMS.connectDB(); PreparedStatement stm = conn.prepareStatement(sql);) {
			stm.setInt(5, ord.getCustomerID());
			stm.setObject(1, ord.getDate());
			stm.setInt(2, ord.getCustomerID());
			stm.setInt(3, ord.getEmployeeID());
			stm.setDouble(4, ord.getTotal());
			stm.executeUpdate();
		} catch (SQLException e) {
			System.out.println("UPDATE data thất bại");
		}

	}

	@Override
	public void DeleteOrder(int ID) {
		String sql = "DELETE Orderr WHERE [orderID] = ? ";
		try (Connection conn = Connection_SMS.connectDB(); PreparedStatement stm = conn.prepareStatement(sql);) {
			stm.setInt(1, ID);
			stm.executeUpdate();
		} catch (SQLException e) {
			System.out.println("UPDATE data thất bại");
		}
	}

	@Override
	public void RetrieveOrder(Order ord) {
		String sql = "SELECT [orderID], [date], [customerID], [employeeID], [total] FROM Orderr WHERE OrderrID = ? ";
		try (Connection conn = Connection_SMS.connectDB();
				PreparedStatement stm = conn.prepareStatement(sql, ResultSet.CONCUR_UPDATABLE);) {
			stm.setInt(1, ord.getOrderID());
			ResultSet rs = stm.executeQuery();
			if (rs.next()) {
				rs.updateObject(2, ord.getDate());
				rs.updateInt(3, ord.getCustomerID());
				rs.updateInt(4, ord.getEmployeeID());
				rs.updateDouble(5, ord.getTotal());
				rs.updateRow();
				System.out.println("Update Employee Thành Công");
			} else {
				rs.updateInt(1, ord.getOrderID());
				rs.updateObject(2, ord.getDate());
				rs.updateInt(3, ord.getCustomerID());
				rs.updateInt(4, ord.getEmployeeID());
				rs.updateDouble(5, ord.getTotal());
				rs.insertRow();
				System.out.println("Insert Employee Thành Công");
			}
		} catch (

		SQLException e) {
			System.out.println(" Dữ Liệu Không Hợp Lệ");
		}
	}

}
