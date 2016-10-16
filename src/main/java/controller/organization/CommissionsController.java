package controller.organization;

import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import data.Provider;
import model.Commission;
import model.Enrollment;
import model.ExaminationDate;
import model.GraduationDate;

@ManagedBean(name = "commissions")
@ViewScoped
public class CommissionsController implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{provider}")
	private Provider provider;

	private List<GraduationDate> graduationDates;
	private GraduationDate selectedGraduationDate;

	/**
	 * Loads and sorts all graduation dates. If there is already a date saved in
	 * the session it will be selected. Otherwise the first entry of the list
	 * will be selected.
	 */
	@PostConstruct
	public void init() {
		graduationDates = provider.loadAllGraduationDates();
		if (graduationDates != null && !graduationDates.isEmpty()) {
			Collections.sort(graduationDates, new Comparator<GraduationDate>() {
				@Override
				public int compare(GraduationDate date1, GraduationDate date2) {
					return date2.getDates().get(0).getDate().compareTo(date1.getDates().get(0).getDate());
				}
			});
			Object graduationDate = FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
					.get("graduationDate");
			if (graduationDate != null && graduationDates.contains(graduationDate)) {
				selectedGraduationDate = (GraduationDate) graduationDate;
			} else {
				selectedGraduationDate = graduationDates.get(0);
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("graduationDate",
						selectedGraduationDate);
			}
		}
	}

	/**
	 * Checks if the given enrollment is already assigned to a commission in
	 * this case a note is added to the string.
	 * 
	 * @param enrollment
	 * @return a string representing the validated enrollment
	 */
	public String validateEnrollment(Enrollment enrollment) {
		StringBuffer sb = new StringBuffer(enrollment.getStudent().toString());
		if (enrollment.getCommission() != null) {
			sb.append(" (");
			sb.append(ResourceBundle.getBundle("messages").getString("labelAssignedEnrollments"));
			sb.append(")");
		}
		return sb.toString();
	}

	/**
	 * Deletes the commission of the given id and reloads the page to prevent inconsistencies.
	 * @param id
	 */
	public String deleteCommission(Long id) {
		Commission commission = provider.loadCommission(id);
		Enrollment enrollment = commission.getEnrollment();
		ExaminationDate examinationDate = commission.getExaminationDate();
		if (enrollment != null) {
			enrollment.setCommission(null);
		}
		examinationDate.removeCommission(commission);
		return "/organization/commissions";
	}

	/**
	 * Every time a commission gets assigned a enrollment, the bidirectional relation has to be ensured and updated.
	 * @param id
	 */
	public void changeEnrollment(Long id) {
		Commission commission = provider.loadCommission(id);
		Enrollment enrollment = commission.getEnrollment();
		if (enrollment != null) {
			if (enrollment.getCommission() != null && !enrollment.getCommission().equals(commission)) {
				enrollment.getCommission().setEnrollment(null);
			}
			enrollment.setCommission(commission);
		} else {
			for (Enrollment e : selectedGraduationDate.getEnrollments()) {
				if (e.getCommission() != null && e.getCommission().getEnrollment() == null) {
					e.setCommission(null);
				}
			}
		}
	}

	/**
	 * Updates the graduation date of the session every time another element is
	 * selected in the one menu.
	 */
	public void updateSession() {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("graduationDate",
				selectedGraduationDate);
	}

	public GraduationDate getSelectedGraduationDate() {
		return selectedGraduationDate;
	}

	public void setSelectedGraduationDate(GraduationDate selectedGraduationDate) {
		this.selectedGraduationDate = selectedGraduationDate;
	}

	public List<GraduationDate> getGraduationDates() {
		return graduationDates;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}
}
