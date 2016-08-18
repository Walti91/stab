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
