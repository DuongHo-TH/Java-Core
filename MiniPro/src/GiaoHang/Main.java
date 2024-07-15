package GiaoHang;
import java.sql.*;
import java.util.Scanner;

public class Main{

    public static void main(String[] args) {
        try {
            // Kết nối tới cơ sở dữ liệu SQL Server
            String url = "jdbc:sqlserver://localhost:1433;databaseName=QLUV_FPT;encrypt=false;trustServerCertificate=false";
            String username = "sa";
            String password = "123456789";
            Connection connection = DriverManager.getConnection(url, username, password);

            // Nhập tháng từ bàn phím
            Scanner scanner = new Scanner(System.in);
            System.out.print("Nhập tháng (VD: 1): ");
            int month = scanner.nextInt();

            // Truy vấn dữ liệu
            String sql = "SELECT TOP 3 s.TenShip, SUM(CuocPhi * 0.1) AS TongLuong FROM CUOCPHIVANCHUYEN cpvc,  VANCHUYEN vc, SHIPPER s WHERE  MONTH(vc.NgayGiaoHang) = ? and cpvc.VanChuyenID = vc.VanChuyenID and vc.ShipperID = s.ShipperID GROUP BY TenShip ORDER BY TongLuong DESC";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, month);
            ResultSet resultSet = statement.executeQuery();

            // In kết quả
            System.out.println("3 nhân viên có lương cao nhất trong tháng " + month + ":");
            while (resultSet.next()) {
                String name = resultSet.getString("TenShip");
                int Luong = resultSet.getInt("TongLuong");
                System.out.println(name + " - Lương: " + Luong);
            }

            // Đóng kết nối
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}