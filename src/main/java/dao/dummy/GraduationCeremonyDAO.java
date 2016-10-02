package dao.dummy;

import java.util.List;

import dao.IGraduationCeremonyDAO;
import data.Storage;
import model.GraduationCeremony;

public class GraduationCeremonyDAO implements IGraduationCeremonyDAO {

	private Storage storage;

	public GraduationCeremonyDAO(Storage storage) {
		this.storage = storage;
	}
	
	public GraduationCeremony load(Long id) {
		return storage.loadGraduationCeremony(id);
	}
	
	public List<GraduationCeremony> loadAll() {
		return storage.loadAllGraduationCeremonies();
	}

	public void save(GraduationCeremony graduationCeremony) {
		storage.saveGraduationCeremony(graduationCeremony);
	}

	public void delete(GraduationCeremony graduationCeremony) {
		storage.deleteGraduationCeremony(graduationCeremony);
	}
}
