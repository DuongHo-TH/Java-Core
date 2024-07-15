package fa.training.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import fa.training.entities.Customer;

public class CustomerDaoImp implements CustomerDao{

	@Override
	public void InsertCustomer(List<Customer> Customer) {
		String sql = "INSERT INTO Customer([customerID], [customerName]) VALUES(?, ?)";
		try (Connection conn = Connection_SMS.connectDB(); PreparedStatement stm = conn.prepareStatement(sql);){
			conn.setAutoCommit(false);
			for (Customer cus : Customer) {
				stm.setInt(1, cus.getCustomerID());
				stm.setString(2, cus.getCustomerName());
				stm.addBatch();

			}
			stm.executeBatch();
			conn.commit();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		
	}

	@Override
	public void UpdateCustomer(Customer Custom) {
		String sql = "UPDATE Employee SET [customerName] = ? WHERE [customerID] = ? ";
		try (Connection conn = Connection_SMS.connectDB(); PreparedStatement stm = conn.prepareStatement(sql);){
			stm.setString(1, Custom.getCustomerName());
			stm.setInt(2, Custom.getCustomerID());
			stm.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} 
		
	}

	@Override
	public void DeleteCustomer(int ID) {
		int i = 0;
		String sql = "DELETE Customer WHERE [customerID] = ? ";
		try (Connection conn = Connection_SMS.connectDB(); PreparedStatement stm = conn.prepareStatement(sql);) {
			stm.setInt(1, ID);
			i = stm.executeUpdate();
			if(i > 0) {
				System.out.println("DELETE Customer Thành Công");
			}
		} catch (SQLException e) {
			System.out.println("UPDATE data thất bại");
		}
		
	}

	@Override
	public void RetrieveCustomer(Customer Custom) {
String sql = "SELECT [customerID], [customerName] FROM Customer WHERE [customerID] = ?";
		
		try (Connection conn = Connection_SMS.connectDB();
				PreparedStatement stm = conn.prepareStatement(sql, ResultSet.CONCUR_UPDATABLE);) {
			stm.setInt(1, Custom.getCustomerID());
			ResultSet rs = stm.executeQuery();
			if (rs.next()) {
				rs.updateString(2, Custom.getCustomerName());
				rs.updateRow();
				System.out.println("Update Employee Thành Công");
			} else {
				rs.updateInt(1, Custom.getCustomerID());
				rs.updateString(2, Custom.getCustomerName());
				rs.insertRow();
				System.out.println("Insert Employee Thành Công");
			}
		} catch (SQLException e) {
			System.out.println("Update data Employee Thất Bại");
		}
	}

}


