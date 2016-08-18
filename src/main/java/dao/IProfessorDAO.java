package dao;

import java.util.List;

import model.Professor;

public interface IProfessorDAO {

	public Professor load(Long id);

	public List<Professor> loadAll();
	
	public void save(Professor professor);
}
