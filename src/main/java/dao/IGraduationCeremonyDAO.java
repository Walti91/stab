package dao;

import java.util.List;

import model.GraduationCeremony;

public interface IGraduationCeremonyDAO {

	public GraduationCeremony load(Long id);

	public List<GraduationCeremony> loadAll();
	
	public void save(GraduationCeremony graduationCeremony);
}
