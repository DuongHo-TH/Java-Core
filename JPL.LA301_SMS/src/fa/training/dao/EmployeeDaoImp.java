package fa.training.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import fa.training.entities.Employee;

public class EmployeeDaoImp implements EmployeeDao {

	@Override
	public void InsertEmployee(List<Employee> Emp) {
		String sql = "INSERT INTO Employee([employeeID], [employeeName], [salary], [spvrID]) VALUES(?, ?, ?, ?)";
		try (Connection conn = Connection_SMS.connectDB(); PreparedStatement stm = conn.prepareStatement(sql);){
			conn.setAutoCommit(false);
			for (Employee employee : Emp) {
				stm.setInt(1, employee.getEmployeeID());
				stm.setString(2, employee.getEmployeeName());
				stm.setDouble(3, employee.getSalary());
				stm.setInt(4, employee.getSpvrID());
				stm.addBatch();

			}
			stm.executeBatch();
			conn.commit();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	@Override
	public void UpdateEmployee(Employee Emp) {
		String sql = "UPDATE Employee SET [employeeName] = ?, [salary] = ?, [spvrID] = ? WHERE [employeeID] = ? ";
		try (Connection conn = Connection_SMS.connectDB(); PreparedStatement stm = conn.prepareStatement(sql);){
			stm.setString(1, Emp.getEmployeeName());
			stm.setDouble(2, Emp.getSalary());
			stm.setInt(3, Emp.getSpvrID());
			stm.setInt(4, Emp.getEmployeeID());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} 

	}

	@Override
	public void DeleteEmployee(int ID) {
		int i = 0;
		String sql = "DELETE Employee WHERE [orderID] = ? ";
		try (Connection conn = Connection_SMS.connectDB(); PreparedStatement stm = conn.prepareStatement(sql);) {
			stm.setInt(1, ID);
			i = stm.executeUpdate();
			if(i > 0) {
				System.out.println("DELETE Employee Thành Công");
			}
		} catch (SQLException e) {
			System.out.println("UPDATE data thất bại");
		}
	}

	

	@Override
	public void RetrieveEmployee(Employee Emp) {
		String sql = "SELECT [employeeID], [employeeName], [salary], [spvrID] FROM Employee WHERE [employeeID] = ?";
		
		try (Connection conn = Connection_SMS.connectDB();
				PreparedStatement stm = conn.prepareStatement(sql, ResultSet.CONCUR_UPDATABLE);) {
			stm.setInt(1, Emp.getEmployeeID());
			ResultSet rs = stm.executeQuery();
			if (rs.next()) {
				rs.updateString(2, Emp.getEmployeeName());
				rs.updateDouble(3, Emp.getSalary());
				rs.updateInt(4, Emp.getSpvrID());
				rs.updateRow();
				System.out.println("Update Employee Thành Công");
			} else {
                rs.updateInt(1, Emp.getEmployeeID());
				rs.updateString(2, Emp.getEmployeeName());
				rs.updateDouble(3, Emp.getSalary());
				rs.updateInt(4, Emp.getSpvrID());
				rs.insertRow();
				System.out.println("Insert Employee Thành Công");
			}
		} catch (SQLException e) {
			System.out.println("Update data Employee Thất Bại");
		}
	}

}
