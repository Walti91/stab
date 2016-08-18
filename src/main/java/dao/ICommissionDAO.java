package dao;

import model.Commission;

public interface ICommissionDAO {

	public Commission load(Long id);

	public void save(Commission commission);
}
