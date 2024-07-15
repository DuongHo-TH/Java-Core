package GiaoHang;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Conecction {
	private static final String ULR  = "jdbc:sqlserver://localhost:1433;databaseName=MiniProject_Delivery;encrypt=false;trustServerCertificate=false";
	private static final String usern = "sa";
	private static final String psswrd = "123456789";

	public static Connection connectDB() {
		Connection conn;
		try {
			conn = DriverManager.getConnection(ULR, usern, psswrd);

			System.out.println("Ket Noi Thanh Cong");
			return conn;
		} catch (SQLException e) {
			System.out.println("Ket Noi That Bai");
			e.printStackTrace();
			return null;
			
		}
	}
	public static void Close(PreparedStatement stm) {
		if(stm != null) {
			try {
				stm.close();
			} catch (SQLException e) {
				e.printStackTrace(); 
			}
		}
	
	}
	public static Connection connecdemo() {
		Connection demo;
		try {
			demo = DriverManager.getConnection(ULR,usern,psswrd);
			System.out.println("Ket Noi Thanh Cong");
			return demo;
		} catch (Exception e) {
			System.out.println("Ket Noi That Bai");
			e.printStackTrace();
		}
		return null;
	}

}
