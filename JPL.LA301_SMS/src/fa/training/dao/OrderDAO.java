package fa.training.dao;

import java.util.List;

import fa.training.entities.Order;

public  interface  OrderDAO {
	public void InsertOrder(List<Order> order);

	public void UpdateOrder(Order ord);

	public void DeleteOrder(int ID);

	public void RetrieveOrder(Order ord);

}
