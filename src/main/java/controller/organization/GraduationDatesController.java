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
	
	public String save() {
		if (!dates.isEmpty()) {
			selectedGraduationDate.setDates(dates);
			provider.saveGraduationDate(selectedGraduationDate);
			for (Enrollment enrollment : selectedGraduationDate.getEnrollments()) {
				if (!selectedGraduationDate.getDates().contains(enrollment.getCommission().getExaminationDate())) {
					enrollment.setCommission(null);
				}
			}
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							ResourceBundle.getBundle("messages").getString("msgSavedChanges"),
							ResourceBundle.getBundle("messages").getString("msgSavedChanges")));
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_WARN,
							ResourceBundle.getBundle("messages").getString("msgNoExaminationDate"),
							ResourceBundle.getBundle("messages").getString("msgNoExaminationDate")));
		}
		return null;
	}

	public void delete() {
		for (Enrollment enrollment : selectedGraduationDate.getEnrollments()) {
			enrollment.setGraduationDate(null);
			enrollment.setCommission(null);
		}
		provider.deleteGraduationDate(selectedGraduationDate);
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO,
						ResourceBundle.getBundle("messages").getString("msgGraduationDateDeleted"),
						ResourceBundle.getBundle("messages").getString("msgGraduationDateDeleted")));
		init();
	}

	public void update() {
		dates = new ArrayList<ExaminationDate>(selectedGraduationDate.getDates());
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("graduationDate",
				selectedGraduationDate);
	}

	public String remove(Long id) {
		ExaminationDate date = provider.loadExaminationDate(id);
		dates.remove(date);
		return null;
	}

	public String add() {
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
	
	public Integer countDistinctions() {
		return selectedGraduationDate.getEnrollments().size() / 2;
	}
	
	public Integer countMales() {
		Integer counter = 0;
		for(Enrollment enrollment : selectedGraduationDate.getEnrollments()) {
			if(enrollment.getStudent().getGender().equals("männlich")) {
				counter++;
			}
		}
		return counter;
	}
	
	public void previous() {
		int index = graduationDates.indexOf(selectedGraduationDate);
		if (index > 0) {
			selectedGraduationDate = graduationDates.get(index - 1);
			update();
		}
	}

	public void next() {
		int index = graduationDates.indexOf(selectedGraduationDate);
		if (index < graduationDates.size() - 1) {
			selectedGraduationDate = graduationDates.get(index + 1);
			update();
		}
	}

	public void updateTabIndex(TabChangeEvent event) {
		tabIndex = event.getComponent().getChildren().indexOf(event.getTab());
	}

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

	public String validateAgreement() {
		String text = ResourceBundle.getBundle("messages").getString("msgValidateAgreement");
		return MessageFormat.format(text, selectedGraduationDate.getEnrollments().size());
	}

	public String calculateSum(Long[] grades) {
		if (grades[0] != null && grades[1] != null && grades[2] != null) {
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
