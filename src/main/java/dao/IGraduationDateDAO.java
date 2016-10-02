package dao;

import java.util.List;

import model.GraduationDate;

public interface IGraduationDateDAO {

	public GraduationDate load(Long id);

	public List<GraduationDate> loadAll();
	
	public void save(GraduationDate graduationDate);

	public void delete(GraduationDate graduationDate);
}
