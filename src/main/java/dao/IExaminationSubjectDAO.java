package dao;

import model.ExaminationSubject;

public interface IExaminationSubjectDAO {

	public ExaminationSubject load(Long id);

	public void save(ExaminationSubject examinationSubject);
}
