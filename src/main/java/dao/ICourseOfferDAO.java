package dao;

import model.CourseOffer;

public interface ICourseOfferDAO {

	public CourseOffer load(Long id);

	public void save(CourseOffer courseOffer);
}
