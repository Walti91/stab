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

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.TabChangeEvent;

import data.Provider;
import model.Assignment;
import model.Enrollment;
import model.ExaminationDate;
import model.GraduationDate;
import model.ModelFactory;

@ManagedBean(name = "graduationDates")
@ViewScoped
public class GraduationDatesController implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{provider}")
	private Provider provider;

	private List<GraduationDate> graduationDates;
	private GraduationDate selectedGraduationDate;
	private Integer tabIndex;
	private List<ExaminationDate> dates;
	private Date newDate;

	/**
	 * Loads and sorts all graduation dates. If there is already a ceremony
	 * saved in the session it will be selected. Otherwise the first entry of
	 * the list will be selected. Afterwards the examination dates will be saved
	 * in a variable in order to reset them, if the changes are discarded.
	 */
	@PostConstruct
	public void init() {
		tabIndex = 0;
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
		dates = new ArrayList<ExaminationDate>(selectedGraduationDate.getDates());
	}

	/**
	 * Saves the changes. There has to be at least one examination date. The
	 * rest of the validation is done in the xhtml files. In case the
	 * examination dates changed, the enrollments have to be updated.
	 * 
	 * @return
	 */
	public String save() {
		if (!dates.isEmpty()) {
			if (selectedGraduationDate.getRegistrationFrom().getTime() < selectedGraduationDate.getRegistrationTo()
					.getTime()) {
				if (selectedGraduationDate.getRegistrationTo().getTime() < selectedGraduationDate.getDates().get(0)
						.getDate().getTime()) {
					selectedGraduationDate.setDates(dates);
					provider.saveGraduationDate(selectedGraduationDate);
					for (Enrollment enrollment : selectedGraduationDate.getEnrollments()) {
						if (!selectedGraduationDate.getDates()
								.contains(enrollment.getCommission().getExaminationDate())) {
							enrollment.setCommission(null);
						}
					}
					FacesContext.getCurrentInstance().addMessage(null,
							new FacesMessage(FacesMessage.SEVERITY_INFO,
									ResourceBundle.getBundle("messages").getString("msgSavedChanges"),
									ResourceBundle.getBundle("messages").getString("msgSavedChanges")));
				} else {
					FacesContext.getCurrentInstance().addMessage(null,
							new FacesMessage(FacesMessage.SEVERITY_ERROR,
									ResourceBundle.getBundle("messages").getString("msgInvalidRegistrationEnd"),
									ResourceBundle.getBundle("messages").getString("msgInvalidRegistrationEnd")));
				}
			} else {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR,
								ResourceBundle.getBundle("messages").getString("msgInvalidRegistrationTime"),
								ResourceBundle.getBundle("messages").getString("msgInvalidRegistrationTime")));
			}
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							ResourceBundle.getBundle("messages").getString("msgNoExaminationDate"),
							ResourceBundle.getBundle("messages").getString("msgNoExaminationDate")));
		}
		return null;
	}

	/**
	 * Deletes the selected graduation date and updates the registered
	 * enrollments.
	 * 
	 * @return
	 */
	public String delete() {
		for (Enrollment enrollment : selectedGraduationDate.getEnrollments()) {
			enrollment.setGraduationDate(null);
			enrollment.setCommission(null);
		}
		provider.deleteGraduationDate(selectedGraduationDate);
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO,
						ResourceBundle.getBundle("messages").getString("msgGraduationDateDeleted"),
						ResourceBundle.getBundle("messages").getString("msgGraduationDateDeleted")));
		return "organization/graduationDates";
	}

	/**
	 * Keeps the session in sync with the selection.
	 */
	public void updateSession() {
		dates = new ArrayList<ExaminationDate>(selectedGraduationDate.getDates());
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("graduationDate",
				selectedGraduationDate);
	}

	/**
	 * Deletes the examination date to the given id.
	 * 
	 * @param id
	 * @return
	 */
	public String removeDate(Long id) {
		ExaminationDate date = provider.loadExaminationDate(id);
		dates.remove(date);
		return null;
	}

	/**
	 * Adds a examination date to the list.
	 * 
	 * @return
	 */
	public String addDate() {
		if (newDate != null) {
			ExaminationDate date = new ModelFactory().createExaminationDate();
			date.setDate(newDate);
			provider.saveExaminationDate(date);
			dates.add(date);
			newDate = null;
			Collections.sort(dates, new Comparator<ExaminationDate>() {
				@Override
				public int compare(ExaminationDate date1, ExaminationDate date2) {
					return date1.getDate().compareTo(date2.getDate());
				}
			});
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_WARN,
							ResourceBundle.getBundle("messages").getString("msgInvalidExaminationDate"),
							ResourceBundle.getBundle("messages").getString("msgInvalidExaminationDate")));
		}
		return null;
	}

	/**
	 * The selected tab index is saved between different graduation dates.
	 * 
	 * @param event
	 */
	public void updateTabIndex(TabChangeEvent event) {
		tabIndex = event.getComponent().getChildren().indexOf(event.getTab());
	}

	/**
	 * Prints a message for the information tab, about the registered and
	 * confirmed students for this date.
	 * 
	 * @return
	 */
	public String validateConfirmed() {
		Integer totalStudents = selectedGraduationDate.getEnrollments().size();
		Integer confirmedStudents = 0;
		for (Enrollment enrollment : selectedGraduationDate.getEnrollments()) {
			Boolean confirmed = true;
			for (Assignment assignment : enrollment.getAssignments()) {
				if (!assignment.getConfirmed()) {
					confirmed = false;
					break;
				}
			}
			if (confirmed) {
				confirmedStudents++;
			}
		}
		String text = ResourceBundle.getBundle("messages").getString("msgValidateConfirmed");
		return MessageFormat.format(text, totalStudents, totalStudents - confirmedStudents);
	}

	/**
	 * Prints a message for the information tab about the agreement to pass on
	 * data.
	 * 
	 * @return
	 */
	public String validateAgreement() {
		String text = ResourceBundle.getBundle("messages").getString("msgValidateAgreement");
		return MessageFormat.format(text, selectedGraduationDate.getEnrollments().size());
	}

	/**
	 * Calculates the average of the given grades array. The array has to have
	 * size 3.
	 * 
	 * @param grades
	 * @return
	 */
	public String calculateSum(Long[] grades) {
		if (grades != null && grades[0] != null && grades[1] != null && grades[2] != null) {
			Double sum = ((double) grades[0] + grades[1] + grades[2]) / 3;
			return sum.toString();
		}
		return null;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	public List<GraduationDate> getGraduationDates() {
		return graduationDates;
	}

	public GraduationDate getSelectedGraduationDate() {
		return selectedGraduationDate;
	}

	public void setSelectedGraduationDate(GraduationDate selectedGraduationDate) {
		this.selectedGraduationDate = selectedGraduationDate;
	}

	public Integer getTabIndex() {
		return tabIndex;
	}

	public void setTabIndex(Integer tabIndex) {
		this.tabIndex = tabIndex;
	}

	public List<ExaminationDate> getDates() {
		return dates;
	}

	public void setDates(List<ExaminationDate> dates) {
		this.dates = dates;
	}

	public Date getNewDate() {
		return newDate;
	}

	public void setNewDate(Date newDate) {
		this.newDate = newDate;
	}
}
