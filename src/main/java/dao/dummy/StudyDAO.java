package dao.dummy;

import java.util.List;

import dao.IStudyDAO;
import data.Storage;
import model.Study;

public class StudyDAO implements IStudyDAO {

	private Storage storage;

	public StudyDAO(Storage storage) {
		this.storage = storage;
	}

	public Study load(String number) {
		return storage.loadStudy(number);
	}
	
	public List<Study> loadAll() {
		return storage.loadAllStudies();
	}

	public void save(Study study) {
		storage.saveStudy(study);
	}
}
