package fa.training.dao;

import java.util.List;
import fa.training.entities.Product;

public interface ProductDAO {
	public void InsertProduct(List<Product> product);

	public void UpdateProduct(Product pro);

	public void DeleteProduct(int ID);

	public void RetrieveProduct(Product pro);
}
