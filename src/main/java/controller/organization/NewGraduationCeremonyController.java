package controller.organization;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import data.Provider;
import model.GraduationCeremony;
import model.ModelFactory;
import model.Room;

@ManagedBean(name = "newGraduationCeremony")
@ViewScoped
public class NewGraduationCeremonyController implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{provider}")
	private Provider provider;

	private GraduationCeremony graduationCeremony;
	private List<Room> rooms;

	@PostConstruct
	public void init() {
		rooms = provider.loadAllRooms();
		graduationCeremony = new ModelFactory().createGraduationCeremony();
	}

	/**
	 * Saves the created graduation ceremony and stores it in the session.
	 * 
	 * @return
	 */
	public String save() {
		provider.saveGraduationCeremony(graduationCeremony);
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO,
						ResourceBundle.getBundle("messages").getString("msgGraduationCeremonyCreated"),
						ResourceBundle.getBundle("messages").getString("msgGraduationCeremonyCreated")));
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("graduationCeremony",
				graduationCeremony);
		return "/organization/graduationCeremonies";
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	public List<Room> getRooms() {
		return rooms;
	}

	public GraduationCeremony getGraduationCeremony() {
		return graduationCeremony;
	}

	public void setGraduationCeremony(GraduationCeremony graduationCeremony) {
		this.graduationCeremony = graduationCeremony;
	}
}
