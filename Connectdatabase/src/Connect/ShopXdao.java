package Connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;




public class ShopXdao {
	public static int insert(ShopX e) {
		Connection conn = ConnShopX.connectDB();
		int dem = 0;
		String sql = "INSERT INTO Employee Values(?,?,?,?,?,?)";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, e.getMaorder());
			ps.setString(2, e.getTenKH());
			ps.setString(3, e.getSDT());
			ps.setString(4, e.getTenSP());
			ps.setInt(5, e.getSoLuong());
			ps.setInt(6, e.getDonGia());

			ps.executeUpdate();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			conn.close();
		} catch (Exception e2) {
			// TODO: handle exception
		}
		return dem;

	}

	public static ArrayList<ShopX> display() {
		Connection conn = ConnShopX.connectDB();
		ArrayList<ShopX> list = new ArrayList<>();
		String dislay = "SELECT * FROM Employee";

		try {
			PreparedStatement pstm = conn.prepareStatement(dislay);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				String MaOrder = rs.getString("MaOrder");
				String TenKH = rs.getString("TenKH");
				String SDT = rs.getString("SDT");
				String TenSP = rs.getString("TenSP");
				int SoLuong = rs.getInt("SoLuong");
				int DonGia = rs.getInt("DonGia");
				ShopX e = new ShopX(MaOrder, TenKH, SDT, TenSP, SoLuong, DonGia, null );

				list.add(e);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

}
