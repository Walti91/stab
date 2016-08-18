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

import java.util.ArrayList;
import java.util.List;

public class Module {

	private Long id;
	private String name;
	private String type;
	private List<CourseOffer> courseOffers;

	public Module() {
		courseOffers = new ArrayList<CourseOffer>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<CourseOffer> getCourseOffers() {
		return courseOffers;
	}

	public void setCourseOffers(List<CourseOffer> courseOffers) {
		this.courseOffers = courseOffers;
	}

	public void addCourseOffer(CourseOffer courseOffer) {
		courseOffers.add(courseOffer);
	}
}
