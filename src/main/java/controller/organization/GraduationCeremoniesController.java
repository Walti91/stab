package controller.organization;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import data.Provider;
import model.Enrollment;
import model.GraduationCeremony;
import model.ModelFactory;
import model.Room;

@ManagedBean(name = "graduationCeremonies")
@ViewScoped
public class GraduationCeremoniesController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ManagedProperty(value = "#{provider}")
	private Provider provider;
	
	private List<GraduationCeremony> graduationCeremonies;
	private Long selectedGraduationCeremony;
	private Date date;
	private Date time;
	private Long room;
	private List<Room> rooms;
	private String description;
	private Boolean newGraduationCeremony;
	private List<Enrollment> enrollments;

	@PostConstruct
	public void init() {
		graduationCeremonies = provider.loadAllGraduationCeremonies();
		rooms = provider.loadAllRooms();
		newGraduationCeremony = false;
		if (!graduationCeremonies.isEmpty()) {
			selectedGraduationCeremony = graduationCeremonies.get(0).getId();
			update();
		}
	}

	public void update() {
		if (selectedGraduationCeremony != null) {
			GraduationCeremony graduationCeremony = provider.loadGraduationCeremony(selectedGraduationCeremony);
			date = graduationCeremony.getDate();
			time = graduationCeremony.getTime();
			room = graduationCeremony.getRoom().getId();
			description = graduationCeremony.getDescription();
			enrollments = graduationCeremony.getEnrollments();
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Bitte wählen Sie eine Sponsion aus!", "Bitte wählen Sie eine Sponsion aus!"));
		}
	}

	public String save() {
		if(date == null || time == null || room == null) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Bitte beachten Sie die verpflichtenden Felder!", "Bitte beachten Sie die verpflichtenden Felder!"));
			return null;
		}
		GraduationCeremony graduationCeremony;
		if (newGraduationCeremony) {
			graduationCeremony = new ModelFactory().createGraduationCeremony();
			provider.saveGraduationCeremony(graduationCeremony);
			graduationCeremonies.add(graduationCeremony);
			newGraduationCeremony = false;
			selectedGraduationCeremony = graduationCeremony.getId();
		} else if (selectedGraduationCeremony != null) {
			graduationCeremony = provider.loadGraduationCeremony(selectedGraduationCeremony);
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Fehler beim Speichern der Sponsion!", "Fehler beim Speichern der Sponsion!"));
			return null;
		}
		graduationCeremony.setDate(date);
		graduationCeremony.setTime(time);
		graduationCeremony.setRoom(provider.loadRoom(room));
		graduationCeremony.setDescription(description);
		return null;
	}

	public String add() {
		newGraduationCeremony = true;
		date = null;
		time = null;
		if(!rooms.isEmpty()) {
			room = rooms.get(0).getId();
		}
		description = null;
		enrollments = null;
		return null;
	}
	
	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	public List<GraduationCeremony> getGraduationCeremonies() {
		return graduationCeremonies;
	}

	public Long getSelectedGraduationCeremony() {
		return selectedGraduationCeremony;
	}

	public void setSelectedGraduationCeremony(Long selection) {
		this.selectedGraduationCeremony = selection;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Long getRoom() {
		return room;
	}

	public void setRoom(Long room) {
		this.room = room;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Room> getRooms() {
		return rooms;
	}

	public Boolean getNewGraduationCeremony() {
		return newGraduationCeremony;
	}
	
	public List<Enrollment> getEnrollments() {
		return enrollments;
	}
}
