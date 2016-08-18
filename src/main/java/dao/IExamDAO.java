package dao;

import model.Exam;

public interface IExamDAO {
	
	public Exam load(Long id);

	public void save(Exam exam);
}
