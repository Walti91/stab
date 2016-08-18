package model;

import java.util.Date;

public class Commission {

	private Long id;
	private Date date;
	private Date from;
	private Date to;
	private Room room;
	private Professor chairman;
	private Enrollment enrollment;
	private GraduationDate graduationDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
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

	public GraduationDate getGraduationDate() {
		return graduationDate;
	}

	public void setGraduationDate(GraduationDate graduationDate) {
		this.graduationDate = graduationDate;
	}
}
