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

public class GraduationDate implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private Date registrationFrom;
	private Date registrationTo;
	private Date submissionFrom;
	private Date submissionTo;
	private Date pickupFrom;
	private Date pickupTo;
	private String notes;
	private Boolean special;
	private List<ExaminationDate> dates;
	private List<Enrollment> enrollments;

	public GraduationDate() {
		dates = new ArrayList<ExaminationDate>();
		enrollments = new ArrayList<Enrollment>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getRegistrationFrom() {
		return registrationFrom;
	}

	public void setRegistrationFrom(Date registrationFrom) {
		this.registrationFrom = registrationFrom;
	}

	public Date getRegistrationTo() {
		return registrationTo;
	}

	public void setRegistrationTo(Date registrationTo) {
		this.registrationTo = registrationTo;
	}
	
	public Date getSubmissionFrom() {
		return submissionFrom;
	}

	public void setSubmissionFrom(Date submissionFrom) {
		this.submissionFrom = submissionFrom;
	}

	public Date getSubmissionTo() {
		return submissionTo;
	}

	public void setSubmissionTo(Date submissionTo) {
		this.submissionTo = submissionTo;
	}

	public Date getPickupFrom() {
		return pickupFrom;
	}

	public void setPickupFrom(Date pickupFrom) {
		this.pickupFrom = pickupFrom;
	}

	public Date getPickupTo() {
		return pickupTo;
	}

	public void setPickupTo(Date pickupTo) {
		this.pickupTo = pickupTo;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	public Boolean getSpecial() {
		return special;
	}

	public void setSpecial(Boolean special) {
		this.special = special;
	}

	public List<ExaminationDate> getDates() {
		return dates;
	}

	public void setDates(List<ExaminationDate> dates) {
		this.dates = dates;
	}

	public void addDate(ExaminationDate date) {
		dates.add(date);
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
		if(dates.isEmpty()) {
			return "Ungespeicherter Abschlusstermin";
		}
		SimpleDateFormat stringFormat = new SimpleDateFormat(ResourceBundle.getBundle("messages").getString("stringFormat"));
		StringBuilder sb = new StringBuilder(stringFormat.format(dates.get(0).getDate()));
		sb.append(" - ").append(stringFormat.format(dates.get(dates.size() - 1).getDate()));
		return sb.toString();
	}
}
