package dao;

import model.Deanery;

public interface IDeaneryDAO {

	public Deanery load();

	public void save(Deanery deanery);
}
