package fa.training.dao;

import java.util.List;

import fa.training.entities.LineItem;

public interface LineItemDao {
	public void InsertLineItem(List<LineItem> lineitem);

	public void UpdateLineItem(LineItem line, int ID);

	public void DeleteLineItem(int ID);

	public void RetrieveLineItem(LineItem line);
}
