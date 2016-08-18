package dao.dummy;

import dao.IExamDAO;
import data.Storage;
import model.Exam;

public class ExamDAO implements IExamDAO {

	private Storage storage;

	public ExamDAO(Storage storage) {
		this.storage = storage;
	}

	public Exam load(Long id) {
		return storage.loadExam(id);
	}

	public void save(Exam exam) {
		storage.saveExam(exam);
	}
}
