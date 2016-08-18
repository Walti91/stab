package dao;

import model.Thesis;

public interface IThesisDAO {

	public Thesis load(Long id);

	public void save(Thesis thesis);
}
