package dao.dummy;

import java.util.List;

import dao.IEnrollmentDAO;
import data.Storage;
import model.Enrollment;

public class EnrollmentDAO implements IEnrollmentDAO {

	private Storage storage;

	public EnrollmentDAO(Storage storage) {
		this.storage = storage;
	}

	public Enrollment load(Long id) {
		return storage.loadEnrollment(id);
	}

	public void save(Enrollment enrollment) {
		storage.saveEnrollment(enrollment);
	}
	
	public List<Enrollment> loadAll() {
		return storage.loadAllEnrollments();
	}
}