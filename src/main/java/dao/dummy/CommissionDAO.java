package dao.dummy;

import dao.ICommissionDAO;
import data.Storage;
import model.Commission;

public class CommissionDAO implements ICommissionDAO {

	private Storage storage;

	public CommissionDAO(Storage storage) {
		this.storage = storage;
	}
	
	public Commission load(Long id) {
		return storage.loadCommission(id);
	}

	public void save(Commission commission) {
		storage.saveCommission(commission);
	}
}
