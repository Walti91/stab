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

public class Deanery {

	private Long id;
	private String year;
	private String name;
	private String faculty;
	private String facultyEnglish;
	private String contactData;
	private String eMailAddress;
	private Integer examDays;
	private Professor principal;
	private Professor vicePrincipal;
	private Professor dean;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFaculty() {
		return faculty;
	}

	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}

	public String getFacultyEnglish() {
		return facultyEnglish;
	}

	public void setFacultyEnglish(String facultyEnglish) {
		this.facultyEnglish = facultyEnglish;
	}

	public String getContactData() {
		return contactData;
	}

	public void setContactData(String contactData) {
		this.contactData = contactData;
	}

	public String geteMailAddress() {
		return eMailAddress;
	}

	public void seteMailAddress(String eMailAddress) {
		this.eMailAddress = eMailAddress;
	}

	public Integer getExamDays() {
		return examDays;
	}

	public void setExamDays(Integer examDays) {
		this.examDays = examDays;
	}

	public Professor getPrincipal() {
		return principal;
	}

	public void setPrincipal(Professor principal) {
		this.principal = principal;
	}

	public Professor getVicePrincipal() {
		return vicePrincipal;
	}

	public void setVicePrincipal(Professor vicePrincipal) {
		this.vicePrincipal = vicePrincipal;
	}

	public Professor getDean() {
		return dean;
	}

	public void setDean(Professor dean) {
		this.dean = dean;
	}
}
