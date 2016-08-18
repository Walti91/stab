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

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class Exam {

	private Long id;
	private Integer grade;
	private Date date;
	private Course course;
	private ModuleAssignment moduleAssignment;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public ModuleAssignment getModuleAssignment() {
		return moduleAssignment;
	}

	public void setModuleAssignment(ModuleAssignment moduleAssignment) {
		this.moduleAssignment = moduleAssignment;
	}
	
	public String toString() {
		SimpleDateFormat dateFormat = new SimpleDateFormat(ResourceBundle.getBundle("messages").getString("dateFormat"));
		StringBuilder sb = new StringBuilder(course.getNumber());
		sb.append("\t").append(course.getCourseOffer().getType());
		sb.append("\t").append(course.getCourseOffer().getName());
		sb.append("\t(").append(course.getCourseOffer().getHours());
		sb.append("h / ").append(course.getCourseOffer().getEcts());
		sb.append("EC)\tNote ").append(grade);
		sb.append("\t").append(dateFormat.format(date));
		return sb.toString();
	}
}
