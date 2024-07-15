package GiaoHang;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



public class GiaoHangDao {
	public static int insert(SanPham e) {
		Connection conn = Conecction.connectDB();
		int dem = 0;
		String sql = "INSERT INTO SANPHAM Values(?,?,?,?,?,?)";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, e.getSanPhamID());
			ps.setString(2, e.getDonHangID());
			ps.setString(3, e.getTenSP());
			ps.setInt(4, e.getTrongLuong());
			ps.setString(5, e.getLoaiHang());
			ps.setInt(6, e.getSoLuong());
			

			ps.executeUpdate();
		} catch (SQLException e1) {
			System.out.println("Mã Sản Phẩm Trùng Vui Lòng Nhập lại: ");
			
		}
		try {
			conn.close();
		} catch (Exception e2) {
			// TODO: handle exception
		}
		return dem;

	}
	public static int delete(SanPham sanpham) {
		int result = 0;
		Connection conn = Conecction.connectDB();
		String delete = "DELETE FROM SanPham WHERE SanPhamID=?";
		try {
			PreparedStatement pstm = conn.prepareStatement(delete);
			pstm.setString(1, sanpham.getSanPhamID() );
			result = pstm.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Thông Tin Sản Phẩm Không Chính Xác vui lòng nhập lại: ");
		}
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}
	public static int update(SanPham sanpham) {
		int result = 0; 
		Connection conn = Conecction.connectDB();
		String up = "UPDATE SanPham SET  DonHangID = ?, TenSP = ?, TrongLuong = ?, LoaiHang = ?, SoLuong = ? WHERE SanPhamID =?";
		try {
			PreparedStatement pstm = conn.prepareStatement(up);
			pstm.setString(6, sanpham.getSanPhamID());
			pstm.setString(1, sanpham.getDonHangID());
			pstm.setString(2, sanpham.getTenSP());
			pstm.setInt(3, sanpham.getTrongLuong());
			pstm.setString(4, sanpham.getLoaiHang());
			pstm.setInt(5, sanpham.getSoLuong());

			result = pstm.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Thông Tin Không Chính Xác Vui Lòng Nhập Lại: ");
		}
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}
	public static ArrayList<LuongShip> tinhtien(int month, int year) {
		ArrayList<LuongShip> danhSach = new ArrayList<>();
		Connection conn = Conecction.connecdemo();
		 String sql = "		 SELECT TOP 3 s.TenShip,  SUM(CuocPhi * 0.1) AS Luong \r\n"
		 		+ "		 FROM CUOCPHIVANCHUYEN cpvc,  VANCHUYEN vc, SHIPPER s\r\n"
		 		+ "         WHERE  MONTH(vc.NgayGiaoHang) = ? and YEAR(vc.NgayGiaoHang) = ? and cpvc.VanChuyenID = vc.VanChuyenID and vc.ShipperID = s.ShipperID\r\n"
		 		+ "         GROUP BY s.TenShip"
		        + "         ORDER BY Luong DESC";
		 try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, month);
			pstm.setInt(2, year);
			ResultSet rs = pstm.executeQuery();
			while(rs.next()) {
				String TenShip = rs.getString(1);
				double Luong = rs.getDouble(2);
				LuongShip luong = new LuongShip (TenShip, Luong);
				danhSach.add(luong);
			}
		} catch (SQLException e) {
			System.out.println("Thời gian không tồn tại trong CSDL. Vui Lòng Nhập Lại: ");
		}
		 try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return danhSach;
		 
	}
	public static ArrayList<LuongShip> TimKiem(int month) {
		ArrayList<LuongShip> danhSach = new ArrayList<>();
		Connection conn = Conecction.connecdemo();
		 String sql = "		 SELECT TOP 3 s.TenShip,  SUM(CuocPhi * 0.1) AS Luong \r\n"
		 		+ "		 FROM CUOCPHIVANCHUYEN cpvc,  VANCHUYEN vc, SHIPPER s\r\n"
		 		+ "         WHERE  MONTH(vc.NgayGiaoHang) = ? and cpvc.VanChuyenID = vc.VanChuyenID and vc.ShipperID = s.ShipperID\r\n"
		 		+ "         GROUP BY s.TenShip"
		 		+ "         ORDER BY Luong DESC";
		 try {
				PreparedStatement pstm = conn.prepareStatement(sql);
				pstm.setInt(1, month);
			
				ResultSet rs = pstm.executeQuery();
				while(rs.next()) {
					String TenShip = rs.getString(1);
					double Luong = rs.getDouble(2);
					LuongShip luong = new LuongShip (TenShip, Luong);
					danhSach.add(luong);
				}
			} catch (SQLException e) {
				System.out.println("Tháng Không Tồn Tại Vui Lòng Nhập Lại: ");
			}
			 try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 return danhSach;
	}
	public static ArrayList<LuongShip> TimQuy1() {
		ArrayList<LuongShip> danhSach = new ArrayList<>();
		Connection conn = Conecction.connecdemo();
		 String sql = "		 SELECT s.TenShip,  SUM(CuocPhi * 0.1) AS Luong \r\n"
		 		+ "		 FROM CUOCPHIVANCHUYEN cpvc,  VANCHUYEN vc, SHIPPER s\r\n"
		 		+ "         WHERE  vc.NgayGiaoHang between '2023-01-01' and '2023-03-31' and cpvc.VanChuyenID = vc.VanChuyenID and vc.ShipperID = s.ShipperID\r\n"
		 		+ "         GROUP BY s.TenShip"
		 		+ "         ORDER BY Luong DESC";
		 try {
				PreparedStatement pstm = conn.prepareStatement(sql);
				
				ResultSet rs = pstm.executeQuery();
				while(rs.next()) {
					String TenShip = rs.getString(1);
					double Luong = rs.getDouble(2);
					LuongShip luong = new LuongShip (TenShip, Luong);
					danhSach.add(luong);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 return danhSach;
	
}
	public static ArrayList<LuongShip> TimQuy2() {
		ArrayList<LuongShip> danhSach = new ArrayList<>();
		Connection conn = Conecction.connecdemo();
		 String sql = "		 SELECT s.TenShip,  SUM(CuocPhi * 0.1) AS Luong \r\n"
		 		+ "		 FROM CUOCPHIVANCHUYEN cpvc,  VANCHUYEN vc, SHIPPER s\r\n"
		 		+ "         WHERE  vc.NgayGiaoHang between '2023-04-01' and '2023-06-30' and cpvc.VanChuyenID = vc.VanChuyenID and vc.ShipperID = s.ShipperID\r\n"
		 		+ "         GROUP BY s.TenShip"
		 		+ "         ORDER BY Luong DESC";
		 try {
				PreparedStatement pstm = conn.prepareStatement(sql);
				
				ResultSet rs = pstm.executeQuery();
				while(rs.next()) {
					String TenShip = rs.getString(1);
					double Luong = rs.getDouble(2);
					LuongShip luong = new LuongShip (TenShip, Luong);
					danhSach.add(luong);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 return danhSach;
	
}
	public static ArrayList<LuongShip> TimQuy3() {
		ArrayList<LuongShip> danhSach = new ArrayList<>();
		Connection conn = Conecction.connecdemo();
		 String sql = "		 SELECT s.TenShip,  SUM(CuocPhi * 0.1) AS Luong \r\n"
		 		+ "		 FROM CUOCPHIVANCHUYEN cpvc,  VANCHUYEN vc, SHIPPER s\r\n"
		 		+ "         WHERE  vc.NgayGiaoHang between '2023-07-01' and '2023-09-30' and cpvc.VanChuyenID = vc.VanChuyenID and vc.ShipperID = s.ShipperID\r\n"
		 		+ "         GROUP BY s.TenShip"
		 		+ "         ORDER BY Luong DESC";
		 try {
				PreparedStatement pstm = conn.prepareStatement(sql);
				
				ResultSet rs = pstm.executeQuery();
				while(rs.next()) {
					String TenShip = rs.getString(1);
					double Luong = rs.getDouble(2);
					LuongShip luong = new LuongShip (TenShip, Luong);
					danhSach.add(luong);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 return danhSach;
	
}

	public static ArrayList<LuongShip> TimQuy4() {
		ArrayList<LuongShip> danhSach = new ArrayList<>();
		Connection conn = Conecction.connecdemo();
		 String sql = "		 SELECT s.TenShip,  SUM(CuocPhi * 0.1) AS Luong \r\n"
		 		+ "		 FROM CUOCPHIVANCHUYEN cpvc,  VANCHUYEN vc, SHIPPER s\r\n"
		 		+ "         WHERE  vc.NgayGiaoHang between '2023-10-01' and '2023-12-31' and cpvc.VanChuyenID = vc.VanChuyenID and vc.ShipperID = s.ShipperID\r\n"
		 		+ "         GROUP BY s.TenShip"
		 		+ "         ORDER BY Luong DESC";
		 try {
				PreparedStatement pstm = conn.prepareStatement(sql);
				
				ResultSet rs = pstm.executeQuery();
				while(rs.next()) {
					String TenShip = rs.getString(1);
					double Luong = rs.getDouble(2);
					LuongShip luong = new LuongShip (TenShip, Luong);
					danhSach.add(luong);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 return danhSach;
	}
	public static ArrayList<Shipper> Timdonhang(String don) {
		ArrayList<Shipper> danhsach = new ArrayList<>();
		Connection conn = Conecction.connecdemo();
		 String sql = "select [TenShip] ,[NgaySinh],[GioiTinh],[SoDTShipper],[DiaChi],[Truong],[Lop],[Email]"
			    		+  "from SHIPPER sp, VANCHUYEN vc, PHEDUYETDONHANG pd"
			    		+ " where pd.DonHangID = ? and vc.MaPheDuyet = pd.MaPheDuyet and sp.ShipperID = vc.ShipperID";
		 try {
				PreparedStatement pstm = conn.prepareStatement(sql);
				
				pstm.setString(1, don);
				
				ResultSet rs = pstm.executeQuery();
				while(rs.next()) {
					String TenShip = rs.getString(1);
					Date ngaysinh = rs.getDate(2);
					String gioitinh = rs.getString(3);
					int sdt = rs.getInt(4);
					String diachi = rs.getString(5);
					String truong = rs.getString(6);
					String lop = rs.getString(7);
					String email = rs.getString(8);
				Shipper sp = new Shipper(TenShip, ngaysinh, gioitinh, sdt, diachi,truong ,lop, email);	
				danhsach.add(sp);
				}
			} catch (SQLException e) {
				System.out.println("Đơn Hàng Không Tồn Tại. Vui Lòng Nhập Lại: ");
			}
			 try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 return danhsach;
}
}
