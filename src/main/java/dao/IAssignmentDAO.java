package dao;

import model.Assignment;

public interface IAssignmentDAO {

	public Assignment load(Long id);

	public void save(Assignment assignment);
}
