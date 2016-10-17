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

package controller.organization;

import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import data.Provider;
import model.Deanery;
import model.Professor;

@ManagedBean
public class DeaneryController {

	@ManagedProperty(value = "#{provider}")
	private Provider provider;
	
	private Deanery deanery;
	private String year;
	private String name;
	private String faculty;
	private String facultyEnglish;
	private String contactData;
	private String emailAddress;
	private Integer examDays;
	private Long principal;
	private Long vicePrincipal;
	private Long dean;
	private List<Professor> professors;
	
	@PostConstruct
	public void init() {
		deanery = provider.loadDeanery();
		year = deanery.getYear();
		name = deanery.getName();
		faculty = deanery.getFaculty();
		facultyEnglish = deanery.getFacultyEnglish();
		contactData = deanery.getContactData();
		emailAddress = deanery.geteMailAddress();
		examDays = deanery.getExamDays();
		principal = deanery.getPrincipal().getId();
		vicePrincipal = deanery.getVicePrincipal().getId();
		dean = deanery.getDean().getId();
		professors = provider.loadAllProfessors();
	}
	
	public String save() {
		deanery.setYear(year);
		deanery.setName(name);
		deanery.setFaculty(faculty);
		deanery.setFacultyEnglish(facultyEnglish);
		deanery.setContactData(contactData);
		deanery.seteMailAddress(emailAddress);
		deanery.setExamDays(examDays);
		deanery.setPrincipal(provider.loadProfessor(principal));
		deanery.setVicePrincipal(provider.loadProfessor(vicePrincipal));
		deanery.setDean(provider.loadProfessor(dean));
		
		return null;
	}
	
	public void validateAddress(FacesContext context, UIComponent component, Object value)
			throws ValidatorException {
		Matcher matcher = Pattern.compile(ResourceBundle.getBundle("messages").getString("emailAddressPattern"))
				.matcher(value.toString());
		if (!matcher.matches()) {
			throw new ValidatorException(
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Bitte geben Sie eine gültige E-Mail-Adresse ein!",
							"Bitte geben Sie eine gültige E-Mail-Adresse ein!"));
		}
	}
	
	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	public List<Professor> getProfessors() {
		return professors;
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

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public Integer getExamDays() {
		return examDays;
	}

	public void setExamDays(Integer examDays) {
		this.examDays = examDays;
	}

	public Long getPrincipal() {
		return principal;
	}

	public void setPrincipal(Long principal) {
		this.principal = principal;
	}

	public Long getVicePrincipal() {
		return vicePrincipal;
	}

	public void setVicePrincipal(Long vicePrincipal) {
		this.vicePrincipal = vicePrincipal;
	}

	public Long getDean() {
		return dean;
	}

	public void setDean(Long dean) {
		this.dean = dean;
	}
}
