package fa.training.dao;

import java.util.List;

import fa.training.entities.Employee;


public interface EmployeeDao {
	public void InsertEmployee(List<Employee> Emp);

	public void UpdateEmployee(Employee Emp);

	public void DeleteEmployee(int ID);

	public void RetrieveEmployee(Employee Emp);
}
