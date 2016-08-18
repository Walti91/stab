package controller.graduationDates;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import data.Provider;
import model.Commission;
import model.Enrollment;
import model.GraduationDate;

@ManagedBean(name = "gdCommissions")
@ViewScoped
public class GdCommissionsController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ManagedProperty(value = "#{provider}")
	private Provider provider;
	
	private GraduationDate graduationDate;
	private List<Enrollment> unassignedEnrollments;
	private Long selectedEnrollment;
	
	@PostConstruct
	public void init() {
		graduationDate = (GraduationDate) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("graduationDate");
		unassignedEnrollments = new ArrayList<Enrollment>();
		for(Enrollment enrollment : graduationDate.getEnrollments()) {
			if(enrollment.getCommission() == null) {
				unassignedEnrollments.add(enrollment);
			}
		}
	}
	
	public String assignEnrollment(Long id) {
		Commission commission = provider.loadCommission(id);
		if (commission.getEnrollment() == null && selectedEnrollment != null) {
			Enrollment enrollment = provider.loadEnrollment(selectedEnrollment);
			enrollment.setCommission(commission);
			commission.setEnrollment(enrollment);
			unassignedEnrollments.remove(enrollment);
		}
		return null;
	}
	
	public String unassignEnrollment(Long id) {
		Commission commission = provider.loadCommission(id);
		Enrollment enrollment = commission.getEnrollment();
		if (enrollment != null) {
			enrollment.setCommission(null);
			commission.setEnrollment(null);
			unassignedEnrollments.add(enrollment);
		}
		return null;
	}
	
	public String deleteCommission(Long id) {
		Commission commission = provider.loadCommission(id);
		Enrollment enrollment = commission.getEnrollment();
		GraduationDate graduationDate = commission.getGraduationDate();
		if(enrollment != null) {
			enrollment.setCommission(null);
			unassignedEnrollments.add(enrollment);
		}
		graduationDate.removeCommission(commission);
		commission.setEnrollment(null);
		commission.setGraduationDate(null);
		return null;
	}
	
	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	public List<Enrollment> getUnassignedEnrollments() {
		return unassignedEnrollments;
	}

	public Long getSelectedEnrollment() {
		return selectedEnrollment;
	}

	public void setSelectedEnrollment(Long selectedEnrollment) {
		this.selectedEnrollment = selectedEnrollment;
	}
}
