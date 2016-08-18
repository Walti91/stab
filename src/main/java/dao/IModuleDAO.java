package dao;

import model.Module;

public interface IModuleDAO {

	public Module load(Long id);

	public void save(Module module);
}
