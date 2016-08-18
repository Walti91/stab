package dao.dummy;

import dao.ICourseOfferDAO;
import data.Storage;
import model.CourseOffer;

public class CourseOfferDAO implements ICourseOfferDAO {

	private Storage storage;

	public CourseOfferDAO(Storage storage) {
		this.storage = storage;
	}

	public CourseOffer load(Long id) {
		return storage.loadCourseOffer(id);
	}

	public void save(CourseOffer courseOffer) {
		storage.saveCourseOffer(courseOffer);
	}
}
