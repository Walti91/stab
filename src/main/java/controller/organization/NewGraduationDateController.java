package controller.organization;

import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import data.Provider;
import model.ExaminationDate;
import model.GraduationDate;
import model.ModelFactory;

@ManagedBean(name = "newGraduationDate")
@ViewScoped
public class NewGraduationDateController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ManagedProperty(value = "#{provider}")
	private Provider provider;
	
	private GraduationDate graduationDate;
	private Date newDate;
	
	@PostConstruct
	public void init() {
		graduationDate = new ModelFactory().createGraduationDate();
	}
	
	public String save() {
		if(!graduationDate.getDates().isEmpty()) {
		provider.saveGraduationDate(graduationDate);
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO,
						ResourceBundle.getBundle("messages").getString("msgGraduationDateCreated"),
						ResourceBundle.getBundle("messages").getString("msgGraduationDateCreated")));
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("graduationDate", graduationDate);
		return "/organization/graduationDates";
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_WARN,
							ResourceBundle.getBundle("messages").getString("msgNoExaminationDate"),
							ResourceBundle.getBundle("messages").getString("msgNoExaminationDate")));
			return null;
		}
	}
	
	public String remove(Long id) {
		ExaminationDate date = provider.loadExaminationDate(id);
		graduationDate.getDates().remove(date);
		return null;
	}
	
	public String add() {
		if(newDate != null) {
			ExaminationDate date = new ModelFactory().createExaminationDate();
			date.setDate(newDate);
			provider.saveExaminationDate(date);
			graduationDate.getDates().add(date);
			newDate = null;
			Collections.sort(graduationDate.getDates(), new Comparator<ExaminationDate>() {
				@Override
				public int compare(ExaminationDate date1, ExaminationDate date2) {
					return date1.getDate().compareTo(date2.getDate());
				}
			});
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
					ResourceBundle.getBundle("messages").getString("msgInvalidExaminationDate"), ResourceBundle.getBundle("messages").getString("msgInvalidExaminationDate")));
		}
		return null;
	}

	public GraduationDate getGraduationDate() {
		return graduationDate;
	}

	public void setGraduationDate(GraduationDate graduationDate) {
		this.graduationDate = graduationDate;
	}

	public Date getNewDate() {
		return newDate;
	}

	public void setNewDate(Date newDate) {
		this.newDate = newDate;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}
}
