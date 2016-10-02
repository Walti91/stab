package model;

import java.util.Date;

public class Commission {

	private Long id;
	private Date from;
	private Date to;
	private Room room;
	private Long[] grades;
	private Professor chairman;
	private Enrollment enrollment;
	private ExaminationDate examinationDate;
	
	public Commission() {
		grades = new Long[3];
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFrom() {
		return from;
	}

	public void setFrom(Date from) {
		this.from = from;
	}

	public Date getTo() {
		return to;
	}

	public void setTo(Date to) {
		this.to = to;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}
	
	public Long[] getGrades() {
		return grades;
	}

	public void setGrades(Long[] grades) {
		this.grades = grades;
	}

	public Professor getChairman() {
		return chairman;
	}

	public void setChairman(Professor chairman) {
		this.chairman = chairman;
	}

	public Enrollment getEnrollment() {
		return enrollment;
	}

	public void setEnrollment(Enrollment enrollment) {
		this.enrollment = enrollment;
	}

	public ExaminationDate getExaminationDate() {
		return examinationDate;
	}

	public void setExaminationDate(ExaminationDate examinationDate) {
		this.examinationDate = examinationDate;
	}
}
