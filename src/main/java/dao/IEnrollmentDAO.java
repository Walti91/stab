package dao;

import java.util.List;

import model.Enrollment;

public interface IEnrollmentDAO {

	public Enrollment load(Long id);

	public void save(Enrollment enrollment);
	
	public List<Enrollment> loadAll();
}
