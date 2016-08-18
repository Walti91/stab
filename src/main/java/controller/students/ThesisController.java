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

package controller.students;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import data.Provider;
import model.Enrollment;
import model.Institute;
import model.ModelFactory;
import model.Professor;
import model.Thesis;

@ManagedBean
@ViewScoped
public class ThesisController implements Serializable {

	@ManagedProperty(value = "#{provider}")
	private Provider provider;
	
	private static final long serialVersionUID = 1L;
	private List<Institute> institutes;
	private Enrollment enrollment;
	private String name;
	private Integer grade;
	private Date date;
	private Long institute;
	private Long adviser;
	private Long assistant;

	@PostConstruct
	public void init() {
		institutes = provider.loadAllInstitutes();
		enrollment = (Enrollment) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("enrollment");
		if(enrollment.getThesis() == null) {
			Thesis thesis = new ModelFactory().createThesis();
			provider.saveThesis(thesis);
			enrollment.setThesis(thesis);
		} else {
			if(enrollment.getThesis().getName() != null) {
				name = enrollment.getThesis().getName();
			}
			if(enrollment.getThesis().getGrade() != null) {
				grade = enrollment.getThesis().getGrade();
			}
			if(enrollment.getThesis().getDate() != null) {
				date = enrollment.getThesis().getDate();
			}
			if(enrollment.getThesis().getInstitute() != null) {
				institute = enrollment.getThesis().getInstitute().getId();
			}
			if(enrollment.getThesis().getAdviser() != null) {
				adviser = enrollment.getThesis().getAdviser().getId();
			}
			if(enrollment.getThesis().getAssistant() != null) {
				assistant = enrollment.getThesis().getAssistant().getId();
			}
		}
	}

	public List<Institute> getInstitutes() {
		return institutes;
	}
	
	public List<Professor> getAdvisers() {
		if (institute != null) {
			return provider.loadInstitute(institute).getAdvisers();
		}
		return null;
	}
	
	public List<Professor> getAssistants() {
		if (institute != null) {
			return provider.loadInstitute(institute).getAssistants();
		}
		return null;
	}

	public String save() {
		enrollment.getThesis().setName(name);
		enrollment.getThesis().setGrade(grade);
		enrollment.getThesis().setDate(date);
		if(institute != null) {
			enrollment.getThesis().setInstitute(provider.loadInstitute(institute));
			if(adviser != null) {
				enrollment.getThesis().setAdviser(provider.loadProfessor(adviser));
			}
			if(assistant != null) {
				enrollment.getThesis().setAssistant(provider.loadProfessor(assistant));
			}
		}
	
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Änderungen erfolgreich gespeichert!",
						"Änderungen erfolgreich gespeichert!"));
		return null;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Long getInstitute() {
		return institute;
	}

	public void setInstitute(Long institute) {
		this.institute = institute;
	}

	public Long getAdviser() {
		return adviser;
	}

	public void setAdviser(Long adviser) {
		this.adviser = adviser;
	}

	public Long getAssistant() {
		return assistant;
	}

	public void setAssistant(Long assistant) {
		this.assistant = assistant;
	}	
}
