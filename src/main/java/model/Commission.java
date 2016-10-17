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
