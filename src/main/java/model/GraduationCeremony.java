/**
	Copyright (C) 2016  Florian Waltenberger

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class GraduationCeremony implements Serializable {

	private static final long serialVersionUID = 1L;
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
		if(description != null && !description.isEmpty()) {
			sb.append(" (").append(description).append(")");
		}
		return sb.toString();
	}
}
