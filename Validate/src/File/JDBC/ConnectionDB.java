package File.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
	private static final String ULR = "jdbc:sqlserver://localhost:1433;databaseName=DSHanhKhach;encrypt=false;trustServerCertificate=false";
	private static final String usern = "sa";
	private static final String psswrd = "123456789";

	public static Connection connectDB() {
		Connection conn;
		try {
			conn = DriverManager.getConnection(ULR, usern, psswrd);

			System.out.println("Kết Nối Thành Công");
			return conn;
		} catch (SQLException e) {
			System.out.println("Kết Nối Thất Bại");
			e.printStackTrace();
			return null;

		}
	}
}
