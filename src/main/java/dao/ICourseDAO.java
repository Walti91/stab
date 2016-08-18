package dao;

import model.Course;

public interface ICourseDAO {

	public Course load(String number);

	public void save(Course course);
}
