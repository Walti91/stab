package dao.dummy;

import dao.IModuleAssignmentDAO;
import data.Storage;
import model.ModuleAssignment;

public class ModuleAssignmentDAO implements IModuleAssignmentDAO {

	private Storage storage;

	public ModuleAssignmentDAO(Storage storage) {
		this.storage = storage;
	}

	public ModuleAssignment load(Long id) {
		return storage.loadModuleAssignment(id);
	}

	public void save(ModuleAssignment moduleAssignment) {
		storage.saveModuleAssignment(moduleAssignment);
	}
}
