package dao.dummy;

import java.util.List;

import dao.IProfessorDAO;
import data.Storage;
import model.Professor;

public class ProfessorDAO implements IProfessorDAO {

	private Storage storage;

	public ProfessorDAO(Storage storage) {
		this.storage = storage;
	}

	public Professor load(Long id) {
		return storage.loadProfessor(id);
	}
	
	public List<Professor> loadAll() {
		return storage.loadAllProfessors();
	}

	public void save(Professor professor) {
		storage.saveProfessor(professor);
	}
}
