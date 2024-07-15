package Connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dame {
	public static void main(String[] args) {
   String url = "jdbc:sqlserver://localhost:1433;databaseName=Demo;encrypt=false;trustServerCertificate=false";
   String usern = "sa";
   String psswrd = "123456789";
			try {
	            Connection con = DriverManager.getConnection(url,usern,psswrd);
	            System.out.println("Ket Noi Thanh Cong");
	        }catch(SQLException e) {
	            System.out.println("Oops, there is an error");
	            e.printStackTrace();
	        }
		}
	}


