package model;

import java.util.ArrayList;
import java.util.List;

public class CourseOffer {

	private Long id;
	private String type;
	private Double hours;
	private Double ects;
	private String name;
	private List<Course> courses;

	public CourseOffer() {
		courses = new ArrayList<Course>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getHours() {
		return hours;
	}

	public void setHours(Double hours) {
		this.hours = hours;
	}

	public Double getEcts() {
		return ects;
	}

	public void setEcts(Double ects) {
		this.ects = ects;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public void addCourse(Course course) {
		courses.add(course);
	}
}
