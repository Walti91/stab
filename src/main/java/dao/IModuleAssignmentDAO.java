package dao;

import model.ModuleAssignment;

public interface IModuleAssignmentDAO {

	public ModuleAssignment load(Long id);

	public void save(ModuleAssignment moduleAssignment);
}
