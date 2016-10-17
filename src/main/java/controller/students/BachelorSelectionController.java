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
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import data.Provider;
import model.Enrollment;

@ManagedBean(name = "bachelorSelection")
@SessionScoped
public class BachelorSelectionController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ManagedProperty(value = "#{provider}")
	private Provider provider;
	
	private Long selectedEnrollment;
	private List<Enrollment> enrollments;
	
	@PostConstruct
	public void init() {
		enrollments = new ArrayList<Enrollment>();
		for(Enrollment enrollment : provider.loadAllEnrollments()) {
			if(enrollment.getStudy().getType().equals("Bachelorstudium")) {
				this.enrollments.add(enrollment);
			} 
		}
	}
	
	public String editStudent() {
		if(selectedEnrollment != null) {
			Enrollment enrollment = provider.loadEnrollment(selectedEnrollment);
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("enrollment", enrollment);

			return "/students/overview";
		} 
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Bitte wählen Sie einen Studenten aus!", "Bitte wählen Sie einen Studenten aus!"));
		return null;
	}
	
	public void setProvider(Provider provider) {
		this.provider = provider;
	}
	
	public List<Enrollment> getEnrollments() {
		return enrollments;
	}

	public Long getSelectedEnrollment() {
		return selectedEnrollment;
	}

	public void setSelectedEnrollment(Long selectedEnrollment) {
		this.selectedEnrollment = selectedEnrollment;
	}
}
