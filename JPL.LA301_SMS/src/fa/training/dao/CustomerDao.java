package fa.training.dao;

import java.util.List;

import fa.training.entities.Customer;


public interface CustomerDao {
	public void InsertCustomer(List<Customer> Customer);

	public void UpdateCustomer(Customer Custom);

	public void DeleteCustomer(int ID);

	public void RetrieveCustomer(Customer Custom);
}
