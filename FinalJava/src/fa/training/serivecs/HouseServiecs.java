package fa.training.serivecs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import fa.training.house.Apartment;
import fa.training.house.House;
import fa.training.house.LowCostHouse;
import fa.training.house.LuxuryHouse;
import fa.training.main.ConnectFinal;

public class HouseServiecs {
	public static void InputHouse(List<House> house) {
		try (BufferedReader DSHoue = new BufferedReader(new FileReader("D:/Data_CSV/datahouse.csv"));) {
			String ds;
			while ((ds = DSHoue.readLine()) != null) {
				String[] DS = ds.split(",");
				String type = DS[0];
				if (type.equalsIgnoreCase("1")) {
					LuxuryHouse lux = new LuxuryHouse();
					lux.setType(Integer.parseInt(DS[0]));
					lux.setHouseID(DS[1]);
					lux.setSquare(Double.parseDouble(DS[2]));
					lux.setDirection(DS[3]);
					try {
						String inputDate = DS[4];
						DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

						lux.setStarDate(LocalDate.parse(inputDate, formatter));
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					try {
						String inputDate = DS[5];
						DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
						lux.setCompletionDate(LocalDate.parse(inputDate, formatter));
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					lux.setRightCertificate(DS[6]);
					lux.setPrice(Double.parseDouble(DS[7]));
					lux.setProjectName(DS[8]);
					lux.setInvestor(DS[9]);
					lux.setView(DS[11]);
					house.add(lux);
				} else if (type.equalsIgnoreCase("2")) {
					LowCostHouse low = new LowCostHouse();
					low.setType(Integer.parseInt(DS[0]));
					low.setHouseID(DS[1]);
					low.setSquare(Double.parseDouble(DS[2]));
					low.setDirection(DS[3]);

					try {
						String inputDate = DS[4];
						DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

						low.setStarDate(LocalDate.parse(inputDate, formatter));
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					try {
						String inputDate = DS[5];
						DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
						low.setCompletionDate(LocalDate.parse(inputDate, formatter));
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					low.setRightCertificate(DS[6]);
					low.setPrice(Double.parseDouble(DS[7]));
					low.setTransferYear(DS[12]);
					house.add(low);
				} else if (type.equalsIgnoreCase("3")) {
					Apartment apa = new Apartment();
					apa.setType(Integer.parseInt(DS[0]));
					apa.setHouseID(DS[1]);
					apa.setSquare(Double.parseDouble(DS[2]));
					apa.setDirection(DS[3]);
					try {
						String inputDate = DS[4];
						DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

						apa.setStarDate(LocalDate.parse(inputDate, formatter));
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					try {
						String inputDate = DS[5];
						DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
						apa.setCompletionDate(LocalDate.parse(inputDate, formatter));
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					apa.setRightCertificate(DS[6]);
					apa.setPrice(Double.parseDouble(DS[7]));
					apa.setFloor(Integer.parseInt(DS[10]));
					apa.setView(DS[11]);

					house.add(apa);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public static void InsertHouse(List<House> house) {
		String sql = "INSERT INTO House ([type], [HouseID], [Square], [Direction], [StarDate], [CompletionDate], [RightCertificate], [Price], [ActualPrice], [ProjectName], [Investor], [Floor], [Vieww], [TransferYear]) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try (Connection conn = ConnectFinal.connectDB(); PreparedStatement pr = conn.prepareStatement(sql);) {
			conn.setAutoCommit(false);
			for (House hs : house) {
				if (hs instanceof LuxuryHouse) {
					pr.setInt(1, hs.getType());
					pr.setString(2, hs.getHouseID());
					pr.setDouble(3, hs.getSquare());
					pr.setString(4, hs.getDirection());
					pr.setObject(5, hs.getStarDate());
					pr.setObject(6, hs.getCompletionDate());
					pr.setString(7, hs.getRightCertificate());
					pr.setDouble(8, hs.getPrice());
					pr.setString(9, null);
					pr.setString(10, ((LuxuryHouse) hs).getProjectName());
					pr.setString(11, ((LuxuryHouse) hs).getInvestor());
					pr.setString(12, null);
					pr.setString(13, ((LuxuryHouse) hs).getView());
					pr.setString(14, null);
					pr.addBatch();
				} else if (hs instanceof LowCostHouse) {
					pr.setInt(1, hs.getType());
					pr.setString(2, hs.getHouseID());
					pr.setDouble(3, hs.getSquare());
					pr.setString(4, hs.getDirection());
					pr.setObject(5, hs.getStarDate());
					pr.setObject(6, hs.getCompletionDate());
					pr.setString(7, hs.getRightCertificate());
					pr.setDouble(8, hs.getPrice());
					pr.setString(9, null);
					pr.setString(10, null);
					pr.setString(11, null);
					pr.setString(12, null);
					pr.setString(13, null);
					pr.setString(14, ((LowCostHouse) hs).getTransferYear());

					pr.addBatch();
				} else if (hs instanceof Apartment) {
					pr.setInt(1, hs.getType());
					pr.setString(2, hs.getHouseID());
					pr.setDouble(3, hs.getSquare());
					pr.setString(4, hs.getDirection());
					pr.setObject(5, hs.getStarDate());
					pr.setObject(6, hs.getCompletionDate());
					pr.setString(7, hs.getRightCertificate());
					pr.setDouble(8, hs.getPrice());
					pr.setString(9, null);
					pr.setString(10, null);
					pr.setString(11, null);
					pr.setInt(12, ((Apartment) hs).getFloor());
					pr.setString(13, ((Apartment) hs).getView());
					pr.setString(14, null);

					pr.addBatch();
				}

			}
			pr.executeBatch();
			conn.commit();
			System.out.println("Đã Insert Vào Database");

		} catch (SQLException e) {
			System.out.println("Insert Dữ Liệu Thất Bại");
		}

	}

	public static double CalculatePrice(Double price, Double ThuNhap) {
		Double Gia = 0d;
		if (ThuNhap < 5000000) {
			Gia = (price * 0.9);
		} else if (ThuNhap < 10000000) {
			Gia = (price * 0.95);
		} else {
			Gia = price;
		}
		return Gia;
	}

	public static void ShowHouse(List<House> hu) {
		for (House house : hu) {
			System.out.println(house.toString());
		}
	}

	public static List<House> SelectPiceHouse() {
		String sql = "SELECT * FROM House";
		List<House> hs = new ArrayList<House>();
		try (Connection conn = ConnectFinal.connectDB(); PreparedStatement pr = conn.prepareStatement(sql);) {
			ResultSet rs = pr.executeQuery();
			while (rs.next()) {
				if (rs.getInt(1) == 1) {
					LuxuryHouse lux = new LuxuryHouse();
					lux.setType(rs.getInt(1));
					lux.setHouseID(rs.getString(2));
					lux.setSquare(rs.getDouble(3));
					lux.setDirection(rs.getString(4));
					try {
						String inputDate = rs.getString(5);
						DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

						lux.setStarDate(LocalDate.parse(inputDate, formatter));
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					try {
						String inputDate = rs.getString(6);
						DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
						lux.setCompletionDate(LocalDate.parse(inputDate, formatter));
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					lux.setRightCertificate(rs.getString(7));
					lux.setPrice(rs.getDouble(8));
					lux.setProjectName(rs.getString(9));
					lux.setInvestor(rs.getString(10));
					lux.setView(rs.getString(12));
					hs.add(lux);
				} else if (rs.getInt(1) == 2) {
					LowCostHouse low = new LowCostHouse();
					low.setType(rs.getInt(1));
					low.setHouseID(rs.getString(2));
					low.setSquare(rs.getDouble(3));
					low.setDirection(rs.getString(4));
					try {
						String inputDate = rs.getString(5);
						DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

						low.setStarDate(LocalDate.parse(inputDate, formatter));
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					try {
						String inputDate = rs.getString(6);
						DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
						low.setCompletionDate(LocalDate.parse(inputDate, formatter));
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					low.setRightCertificate(rs.getString(7));
					low.setPrice(rs.getDouble(8));
					low.setTransferYear(rs.getString(13));
					hs.add(low);
				} else if (rs.getInt(1) == 3) {
					Apartment apa = new Apartment();
					apa.setType(rs.getInt(1));
					apa.setHouseID(rs.getString(2));
					apa.setSquare(rs.getDouble(3));
					apa.setDirection(rs.getString(4));
					try {
						String inputDate = rs.getString(5);
						DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

						apa.setStarDate(LocalDate.parse(inputDate, formatter));
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					try {
						String inputDate = rs.getString(6);
						DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
						apa.setCompletionDate(LocalDate.parse(inputDate, formatter));
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					apa.setRightCertificate(rs.getString(7));
					apa.setPrice(rs.getDouble(8));
					apa.setFloor(rs.getInt(11));
					apa.setView(rs.getString(12));
					hs.add(apa);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
          return hs;
		
	}
	public static Double TinhGia() {
		String [] DS = {};
		String input = "D://Data_CSV//thunhap.txt";
		try (BufferedReader DSHoue = new BufferedReader(new FileReader(input))) {
			String ds;
			
			while ((ds = DSHoue.readLine()) != null) {
				System.out.println(ds);
				 DS = ds.split(",");
				
			}
			}catch(Exception e) {
				
			}	
		Double GiaCK = 0d ;
		int i = 0;
		List<House> listgia = new ArrayList<House>();
		listgia.addAll(SelectPiceHouse());
		for (House house : listgia) {
			
			Double thunhap = Double.parseDouble(DS[i]);
			GiaCK = CalculatePrice(house.getPrice(),thunhap);
			i++;
		}
		return GiaCK;
	}
}
