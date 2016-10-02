package dao.dummy;

import dao.IExaminationDateDAO;
import data.Storage;
import model.ExaminationDate;

public class ExaminationDateDAO implements IExaminationDateDAO {

	private Storage storage;

	public ExaminationDateDAO(Storage storage) {
		this.storage = storage;
	}

	public ExaminationDate load(Long id) {
		return storage.loadExaminationDate(id);
	}

	public void save(ExaminationDate examinationDate) {
		storage.saveExaminationDate(examinationDate);
	}
}
