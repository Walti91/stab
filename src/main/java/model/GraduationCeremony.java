package model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class GraduationCeremony {

	private Long id;
	private Date date;
	private Date time;
	private String description;
	private Room room;
	private List<Enrollment> enrollments;

	public GraduationCeremony() {
		this.enrollments = new ArrayList<Enrollment>();
	}
	
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

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public List<Enrollment> getEnrollments() {
		return enrollments;
	}

	public void setEnrollments(List<Enrollment> enrollments) {
		this.enrollments = enrollments;
	}
	
	public void addEnrollment(Enrollment enrollment) {
		enrollments.add(enrollment);
	}
	
	public String toString() {
		SimpleDateFormat stringFormat = new SimpleDateFormat(ResourceBundle.getBundle("messages").getString("stringFormat"));
		StringBuilder sb = new StringBuilder(stringFormat.format(date));
		if(description != null) {
			sb.append(" (").append(description).append(")");
		}
		return sb.toString();
	}
}
