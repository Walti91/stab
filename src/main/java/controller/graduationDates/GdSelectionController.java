package controller.graduationDates;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import data.Provider;
import model.GraduationDate;
import model.ModelFactory;

@ManagedBean(name = "gdSelection")
@ViewScoped
public class GdSelectionController implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{provider}")
	private Provider provider;
	
	private List<GraduationDate> graduationDates;
	private Long selectedGraduationDate;

	@PostConstruct
	public void init() {
		graduationDates = provider.loadAllGraduationDates();
	}

	public String editGraduationDate() {
		if (selectedGraduationDate != null) {
			GraduationDate graduationDate = provider.loadGraduationDate(selectedGraduationDate);
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("graduationDate", graduationDate);

			return "/graduationDates/overview";
		}
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
				"Bitte wählen Sie einen Abschlusstermin aus!", "Bitte wählen Sie einen Abschlusstermin aus!"));
		return null;
	}

	public String createGraduationDate() {
		GraduationDate graduationDate = new ModelFactory().createGraduationDate();
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("graduationDate", graduationDate);

		return "/graduationDates/overview";
	}
	
	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	public List<GraduationDate> getGraduationDates() {
		return graduationDates;
	}

	public Long getSelectedGraduationDate() {
		return selectedGraduationDate;
	}

	public void setSelectedGraduationDate(Long selectedGraduationDate) {
		this.selectedGraduationDate = selectedGraduationDate;
	}
}
