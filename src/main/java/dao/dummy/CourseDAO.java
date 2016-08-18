package dao.dummy;

import dao.ICourseDAO;
import data.Storage;
import model.Course;

public class CourseDAO implements ICourseDAO {

	private Storage storage;

	public CourseDAO(Storage storage) {
		this.storage = storage;
	}

	public Course load(String number) {
		return storage.loadCourse(number);
	}

	public void save(Course course) {
		storage.saveCourse(course);
	}
}
