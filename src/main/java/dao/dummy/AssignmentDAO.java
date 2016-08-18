package dao.dummy;

import dao.IAssignmentDAO;
import data.Storage;
import model.Assignment;

public class AssignmentDAO implements IAssignmentDAO {

	private Storage storage;

	public AssignmentDAO(Storage storage) {
		this.storage = storage;
	}

	public Assignment load(Long id) {
		return storage.loadAssignment(id);
	}

	public void save(Assignment assignment) {
		storage.saveAssignment(assignment);
	}
}
