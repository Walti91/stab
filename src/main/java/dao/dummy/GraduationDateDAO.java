package dao.dummy;

import java.util.List;

import dao.IGraduationDateDAO;
import data.Storage;
import model.GraduationDate;

public class GraduationDateDAO implements IGraduationDateDAO {

	private Storage storage;

	public GraduationDateDAO(Storage storage) {
		this.storage = storage;
	}
	
	public GraduationDate load(Long id) {
		return storage.loadGraduationDate(id);
	}
	
	public List<GraduationDate> loadAll() {
		return storage.loadAllGraduationDates();
	}

	public void save(GraduationDate graduationDate) {
		storage.saveGraduationDate(graduationDate);
	}
}
