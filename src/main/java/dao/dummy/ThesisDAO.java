package dao.dummy;

import dao.IThesisDAO;
import data.Storage;
import model.Thesis;

public class ThesisDAO implements IThesisDAO {

	private Storage storage;

	public ThesisDAO(Storage storage) {
		this.storage = storage;
	}
	
	public Thesis load(Long id) {
		return storage.loadThesis(id);
	}

	public void save(Thesis thesis) {
		storage.saveThesis(thesis);
	}
}
