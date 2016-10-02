package dao;

import model.ExaminationDate;

public interface IExaminationDateDAO {

	public ExaminationDate load(Long id);

	public void save(ExaminationDate examinationDate);
}
