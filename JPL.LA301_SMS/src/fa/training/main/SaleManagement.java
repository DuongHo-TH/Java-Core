package fa.training.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import fa.training.dao.CustomerDaoImp;
import fa.training.dao.CustomerSevices;
import fa.training.dao.EmployeeDaoImp;
import fa.training.dao.EmployeeSevices;
import fa.training.dao.LineItemDaoImp;
import fa.training.dao.LineItemSevices;
import fa.training.dao.OrderDAOImpl;
import fa.training.dao.OrderSevices;
import fa.training.dao.ProductDAOImpl;
import fa.training.dao.ProductSevices;
import fa.training.entities.Customer;
import fa.training.entities.Employee;
import fa.training.entities.LineItem;
import fa.training.entities.Order;
import fa.training.entities.Product;

public class SaleManagement {
	public static void main(String[] args) {
		List<Employee> listofEmployee = new ArrayList<Employee>();
		List<Customer> listofCustomer = new ArrayList<Customer>();
		List<LineItem> listofLineItem = new ArrayList<LineItem>();
		List<Product> listofProduct = new ArrayList<Product>();
		List<Order> listofOrder = new ArrayList<Order>();
		try (Scanner sc = new Scanner(System.in)) {
			int key;
			do {
				System.out.println("================== Menu Quản Lý Order =====================");
				System.out.println("1, Quản Lý Employee");
				System.out.println("2, Quản Lý Customer");
				System.out.println("3, Quản Lý LineItem");
				System.out.println("4, Quản Lý Product");
				System.out.println("5, Quản Lý Order");
				System.out.println("6, Kết Thúc Trương Trình");
				key = Integer.parseInt(sc.nextLine());
				switch (key) {
				case 1: {
					do {
						EmployeeDaoImp dao = new EmployeeDaoImp();
						System.out.println("Chọn Chức Năng Muốn Thực Hiện Với Employee");
						System.out.println("1, Thêm mới Employee vào ListEmployee");
						System.out.println("2, Insert ListEmployee vào Database");
						System.out.println("3, Kiểm Tra Update or Insert Employee trong database Theo Employee ID");
						System.out.println("4, Update Employee Trong Database");
						System.out.println("5, Delete Employee Trong Database");
						int menu = Integer.parseInt(sc.nextLine());
						switch (menu) {
						case 1: {
							do {
								listofEmployee.add(EmployeeSevices.CreateEmployee(sc));
								System.out.println("Bạn Có Muốn Nhập Thêm Employee vào Danh Sách");
								System.out.println("Chọn Y/N");
								String next = sc.nextLine();
								if (next.equalsIgnoreCase("n")) {
									break;
								}
							} while (true);
						}
						case 2: {
							dao.InsertEmployee(listofEmployee);
							break;
						}
						case 3: {
							dao.RetrieveEmployee(EmployeeSevices.CreateEmployee(sc));
							break;
						}
						case 4: {
							dao.UpdateEmployee(EmployeeSevices.CreateEmployee(sc));
							break;
						}
						case 5: {
							System.out.println("Nhập EmployeeID cần Xóa ");
							int ID = Integer.parseInt(sc.nextLine());
							dao.DeleteEmployee(ID);
							break;
						}

						}
						System.out.println("Bạn Có Muốn Quay Về Menu Chính. Chọn Y/N");
						String next = sc.nextLine();
						if (next.equalsIgnoreCase("y")) {
							break;
						}
					} while (true);
				}
				case 2: {
					do {
						CustomerDaoImp cus = new CustomerDaoImp();
						System.out.println("Chọn Chức Năng Muốn Thực Hiện Với Customer");
						System.out.println("1, Thêm mới Customer vào ListCustomer");
						System.out.println("2, Insert Customer vào Database");
						System.out.println("3, Kiểm Tra Update or Insert Employee trong database Theo CustomerID");
						System.out.println("4, Update Customer Trong Database");
						System.out.println("5, Delete Customer Trong Database");
						System.out.println("6, Liệt kê tất cả khách hàng có trong Order");
						System.out.println("7, Thêm Khách Hàng Vào Database");
						int menu = Integer.parseInt(sc.nextLine());
						switch (menu) {
						case 1: {
							listofCustomer.add(CustomerSevices.CreateCustomer(sc));
							System.out.println("Bạn Có Muốn Nhập Thêm Employee vào Danh Sách");
							System.out.println("Chọn Y/N");
							String next = sc.nextLine();
							if (next.equalsIgnoreCase("n")) {
								break;
							}
						}
						case 2: {
							cus.InsertCustomer(listofCustomer);
							break;
						}
						case 3: {
							cus.RetrieveCustomer(CustomerSevices.CreateCustomer(sc));
							break;
						}
						case 4: {
							cus.UpdateCustomer(CustomerSevices.CreateCustomer(sc));
							break;
						}
						case 5: {
							System.out.println("Nhập CustomerID muốn xóa");
							int ID = Integer.parseInt(sc.nextLine());
							cus.DeleteCustomer(ID);
							break;
						}
						case 6: {
							for (Customer cusoforder : CustomerSevices.getAllCustomer()) {
								System.out.println(cusoforder.toString());
							}
						}
						case 7:
							List<Customer> addnew = new ArrayList<Customer>();
							addnew.add(CustomerSevices.CreateCustomer(sc));
							cus.InsertCustomer(addnew);

						}
						System.out.println("Bạn Có Muốn Quay Về Menu Chính. Chọn Y/N");
						String next = sc.nextLine();
						if (next.equalsIgnoreCase("y")) {
							break;
						}
					} while (true);
				}
				case 3: {
					do {
						LineItemDaoImp line = new LineItemDaoImp();
						System.out.println("Chọn Chức Năng Muốn Thực Hiện Với LineItem");
						System.out.println("1, Thêm mới LineItem vào ListLineItem");
						System.out.println("2, Insert LineItem vào Database");
						System.out.println("3, Kiểm Tra Update or Insert LineItem trong database Theo LineItemID");
						System.out.println("4, Update LineItem Trong Database");
						System.out.println("5, Delete LineItem Trong Database");
						System.out.println("6, Tìm Kiếm Toàn Bộ LineItem của Order");
						int menu = Integer.parseInt(sc.nextLine());
						switch (menu) {
						case 1: {
							listofLineItem.add(LineItemSevices.CreateLine(sc));
							System.out.println("Bạn Có Muốn Nhập Thêm Employee vào Danh Sách");
							System.out.println("Chọn Y/N");
							String next = sc.nextLine();
							if (next.equalsIgnoreCase("n")) {
								break;
							}
						}
						case 2: {
							line.InsertLineItem(listofLineItem);
							break;
						}
						case 3: {
							line.RetrieveLineItem(LineItemSevices.CreateLine(sc));
							break;
						}
						case 4: {
							System.out.println("Nhập OrderID Hoặc ProductID");
							int ID = Integer.parseInt(sc.nextLine());
							line.UpdateLineItem(LineItemSevices.CreateLine(sc), ID);
							break;
						}
						case 5: {
							System.out.println("Nhập OrderID Hoặc ProductID");
							int ID = Integer.parseInt(sc.nextLine());
							line.DeleteLineItem(ID);
							break;
						}
						case 6: {
							System.out.println("Nhập [orderID] cần tìm kiếm");
							int orderID = Integer.parseInt(sc.nextLine());
							LineItemSevices.getAllItemsByOrderId(orderID);
							break;
						}
						}
						System.out.println("Bạn Có Muốn Quay Về Menu Chính. Chọn Y/N");
						String next = sc.nextLine();
						if (next.equalsIgnoreCase("y")) {
							break;
						}
					} while (true);
				}
				case 4: {
					do {
						ProductDAOImpl pro = new ProductDAOImpl();
						System.out.println("Chọn Chức Năng Muốn Thực Hiện Với Product");
						System.out.println("1, Thêm mới Product vào ListProduct");
						System.out.println("2, Insert Product vào Database");
						System.out.println("3, Kiểm Tra Update or Insert Product trong database Theo ProductID");
						System.out.println("4, Update Product Trong Database");
						System.out.println("5, Delete Product Trong Database");
						int menu = Integer.parseInt(sc.nextLine());
						switch (menu) {
						case 1: {
							listofProduct.add(ProductSevices.CreateProduct(sc));
							break;
						}
						case 2: {
							pro.InsertProduct(listofProduct);
							break;
						}
						case 3: {
							pro.RetrieveProduct(ProductSevices.CreateProduct(sc));
							break;
						}
						case 4: {
							pro.UpdateProduct(ProductSevices.CreateProduct(sc));
							break;
						}
						case 5: {
							System.out.println("Nhập ProductID muốn Xóa");
							int ID = Integer.parseInt(sc.nextLine());
							pro.DeleteProduct(ID);
						}
						case 6: {
							System.out.println("Nhập ID Khách Hàng Cần Tìm Order");
							int ID = Integer.parseInt(sc.nextLine());
							for (Order order : OrderSevices.getAllOrdersByCustomerId(ID)) {
								System.out.println(
										order.getOrderID() + "||" + order.getDate() + "||" + order.getCustomerID()
												+ "||" + order.getEmployeeID() + "||" + order.getTotal());
							}
						}
						}
						System.out.println("Bạn Có Muốn Quay Về Menu Chính. Chọn Y/N");
						String next = sc.nextLine();
						if (next.equalsIgnoreCase("y")) {
							break;
						}
					} while (true);
				}
				case 5: {

					do {
						OrderDAOImpl ord = new OrderDAOImpl();
						System.out.println("Chọn Chức Năng Muốn Thực Hiện Với Order");
						System.out.println("1, Thêm mới Order vào ListOrder");
						System.out.println("2, Insert Order vào Database");
						System.out.println("3, Kiểm Tra Update or Insert Order trong database Theo OrderID");
						System.out.println("4, Update Order Trong Database");
						System.out.println("5, Delete Order Trong Database");
						System.out.println("6, Tìm Kiếm Tổng Giá Tiền Của Một Order");
						int menu = Integer.parseInt(sc.nextLine());
						switch (menu) {
						case 1: {
							listofOrder.add(OrderSevices.CreateOrder(sc));
							break;
						}
						case 2: {
							ord.InsertOrder(listofOrder);
							break;
						}
						case 3: {
							ord.RetrieveOrder(OrderSevices.CreateOrder(sc));
							break;
						}
						case 4: {
							ord.UpdateOrder(OrderSevices.CreateOrder(sc));
							break;
						}
						case 5: {
							System.out.println("Nhập ProductID muốn Xóa");
							int ID = Integer.parseInt(sc.nextLine());
							ord.DeleteOrder(ID);
						}
						case 6:
							System.out.println("Nhập OrderrID cần tìm kiếm");
							int ID = Integer.parseInt(sc.nextLine());
							System.out.println(OrderSevices.computeOrderTotal(ID));
						}
						System.out.println("Bạn Có Muốn Quay Về Menu Chính. Chọn Y/N");
						String next = sc.nextLine();
						if (next.equalsIgnoreCase("y")) {
							break;
						}
					} while (true);
				}
				}

			} while (true);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}
}
