package fa.training.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import fa.training.entities.Product;

public class ProductDAOImpl implements ProductDAO {

	@Override
	public void InsertProduct(List<Product> product) {
		String sql = "INSERT INTO Orderr([orderID], [date], [customerID], [employeeID], [total]) VALUES(?, ?, ?, ?, ?)";
		try (Connection conn = Connection_SMS.connectDB(); PreparedStatement stm = conn.prepareStatement(sql);) {
			conn.setAutoCommit(false);
			for (Product product1 : product) {
				stm.setInt(1, product1.getProductID());
				stm.setString(2, product1.getProductName());
				stm.setDouble(3, product1.getListPrice());
				stm.addBatch();
			}
			stm.executeBatch();
			conn.setAutoCommit(true);
			conn.commit();
		} catch (SQLException e) {
			System.out.println("INSERT data thất bại");
		}

	}

	@Override
	public void UpdateProduct(Product pro) {
		String sql = "UPDATE Orderr SET [productName] = ?, [listPrice] = ? WHERE [productID] = ? ";
		try (Connection conn = Connection_SMS.connectDB(); PreparedStatement stm = conn.prepareStatement(sql);) {
			System.out.println("Nhập OrderrID cần UPDATE");
			stm.setInt(3, pro.getProductID());
		
			stm.setString(1, pro.getProductName());
			System.out.println("Nhập total");
			stm.setDouble(2, pro.getListPrice());
			stm.executeUpdate();
		} catch (SQLException e) {
			System.out.println("UPDATE data thất bại");
		}

	}

	@Override
	public void DeleteProduct(int ID) {
		String sql = "DELETE Orderr WHERE [orderID] = ? ";
		try (Connection conn = Connection_SMS.connectDB(); PreparedStatement stm = conn.prepareStatement(sql);) {
			stm.setInt(1, ID);
			stm.executeUpdate();
			System.out.println("Update Thành Công");
		} catch (SQLException e) {
			System.out.println("UPDATE data thất bại");
		}

	}

	@Override
	public void RetrieveProduct(Product pro) {
		String sql = "SELECT * FROM Product WHERE ProductID = ?";
		try (Connection conn = Connection_SMS.connectDB();
				PreparedStatement stm = conn.prepareStatement(sql, ResultSet.CONCUR_UPDATABLE);) {
			stm.setInt(1, pro.getProductID());
			ResultSet rs = stm.executeQuery();
			if (rs.next()) {
				rs.updateObject(2, pro.getProductName());
				rs.updateDouble(3, pro.getListPrice());
				rs.updateRow();
			} else {
				rs.updateInt(1, pro.getProductID());
				rs.updateObject(2, pro.getProductName());
				rs.updateDouble(3, pro.getListPrice());
				rs.insertRow();
			}
		} catch (SQLException e) {
			System.out.println(" Dữ Liệu Không Hợp Lệ");
		}

	}

}
