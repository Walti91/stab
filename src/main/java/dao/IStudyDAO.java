package dao;

import java.util.List;

import model.Study;

public interface IStudyDAO {
	
	public Study load(String number);
	
	public List<Study> loadAll();

	public void save(Study enrollment);
}
