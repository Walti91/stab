package dao.dummy;

import dao.IModuleDAO;
import data.Storage;
import model.Module;

public class ModuleDAO implements IModuleDAO {

	private Storage storage;

	public ModuleDAO(Storage storage) {
		this.storage = storage;
	}
	
	public Module load(Long id) {
		return storage.loadModule(id);
	}

	public void save(Module module) {
		storage.saveModule(module);
	}
}
