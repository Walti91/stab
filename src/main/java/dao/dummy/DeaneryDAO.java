package dao.dummy;

import dao.IDeaneryDAO;
import data.Storage;
import model.Deanery;

public class DeaneryDAO implements IDeaneryDAO {

	private Storage storage;

	public DeaneryDAO(Storage storage) {
		this.storage = storage;
	}
	
	public Deanery load() {
		return storage.loadDeanery();
	}

	public void save(Deanery deanery) {
		storage.saveDeanery(deanery);
	}
}
