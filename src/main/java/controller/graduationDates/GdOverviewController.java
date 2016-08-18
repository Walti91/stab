package controller.graduationDates;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import data.Provider;
import model.GraduationDate;

@ManagedBean(name = "gdOverview")
@ViewScoped
public class GdOverviewController implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ManagedProperty(value = "#{provider}")
	private Provider provider;
	
	private GraduationDate graduationDate;
	private List<Date> dates;
	private Date registrationFrom;
	private Date registrationTo;
	private Date submissionFrom;
	private Date submissionTo;
	private Date pickupFrom;
	private Date pickupTo;
	private String notes;
	private Date newDate;
	
	@PostConstruct
	public void init() {
		graduationDate = (GraduationDate) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("graduationDate");
		dates = new ArrayList<Date>(graduationDate.getDates());
		registrationFrom = graduationDate.getRegistrationFrom();
		registrationTo = graduationDate.getRegistrationTo();
		submissionFrom = graduationDate.getSubmissionFrom();
		submissionTo = graduationDate.getSubmissionTo();
		pickupFrom = graduationDate.getPickupFrom();
		pickupTo = graduationDate.getPickupTo();
		notes = graduationDate.getNotes();
	}
	
	public String saveGraduationDate() {
		if(!dates.isEmpty() && registrationFrom != null && registrationTo != null) {
			graduationDate.setDates(dates);
			graduationDate.setRegistrationFrom(registrationFrom);
			graduationDate.setRegistrationTo(registrationTo);
			graduationDate.setSubmissionFrom(submissionFrom);
			graduationDate.setSubmissionTo(submissionTo);
			graduationDate.setPickupFrom(pickupFrom);
			graduationDate.setPickupTo(pickupTo);
			graduationDate.setNotes(notes);
			provider.saveGraduationDate(graduationDate);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Abschlusstermin erfolgreich gespeichert!", "Abschlusstermin erfolgreich gespeichert!"));
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
					"Bitte geben Sie zumindest einen Prüfungstag sowie ein gültiges Datum für den Beginn und das Ende der Anmeldung an!", "Bitte geben Sie zumindest einen Prüfungstag sowie ein gültiges Datum für den Beginn und das Ende der Anmeldung an!"));
		}
		return null;
	}
	
	public String removeDate(Date date) {
		dates.remove(date);
		return null;
	}
	
	public String addDate() {
		if(newDate != null) {
			dates.add(newDate);
			newDate = null;
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
					"Bitte geben Sie einen gültigen Prüfungstag ein!", "Bitte geben Sie einen gültigen Prüfungstag ein!"));
		}
		return null;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	public List<Date> getDates() {
		return dates;
	}

	public Date getRegistrationFrom() {
		return registrationFrom;
	}

	public void setRegistrationFrom(Date registrationFrom) {
		this.registrationFrom = registrationFrom;
	}

	public Date getRegistrationTo() {
		return registrationTo;
	}

	public void setRegistrationTo(Date registrationTo) {
		this.registrationTo = registrationTo;
	}

	public Date getSubmissionFrom() {
		return submissionFrom;
	}

	public void setSubmissionFrom(Date submissionFrom) {
		this.submissionFrom = submissionFrom;
	}

	public Date getSubmissionTo() {
		return submissionTo;
	}

	public void setSubmissionTo(Date submissionTo) {
		this.submissionTo = submissionTo;
	}

	public Date getPickupFrom() {
		return pickupFrom;
	}

	public void setPickupFrom(Date pickupFrom) {
		this.pickupFrom = pickupFrom;
	}

	public Date getPickupTo() {
		return pickupTo;
	}

	public void setPickupTo(Date pickupTo) {
		this.pickupTo = pickupTo;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Date getNewDate() {
		return newDate;
	}

	public void setNewDate(Date newDate) {
		this.newDate = newDate;
	}
}
