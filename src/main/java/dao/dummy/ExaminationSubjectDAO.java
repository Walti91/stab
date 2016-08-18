package dao.dummy;

import dao.IExaminationSubjectDAO;
import data.Storage;
import model.ExaminationSubject;

public class ExaminationSubjectDAO implements IExaminationSubjectDAO {

	private Storage storage;

	public ExaminationSubjectDAO(Storage storage) {
		this.storage = storage;
	}
	
	public ExaminationSubject load(Long id) {
		return storage.loadExaminationSubject(id);
	}

	public void save(ExaminationSubject examinationSubject) {
		storage.saveExaminationSubject(examinationSubject);
	}
}
