package controller.organization;

import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
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
import model.Enrollment;
import model.GraduationCeremony;
import model.Room;

@ManagedBean(name = "graduationCeremonies")
@ViewScoped
public class GraduationCeremoniesController implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{provider}")
	private Provider provider;

	private List<GraduationCeremony> graduationCeremonies;
	private GraduationCeremony selectedGraduationCeremony;
	private List<Room> rooms;
	private Integer tabIndex;

	@PostConstruct
	public void init() {
		tabIndex = 0;
		rooms = provider.loadAllRooms();
		graduationCeremonies = provider.loadAllGraduationCeremonies();
		if (graduationCeremonies != null && !graduationCeremonies.isEmpty()) {
			Collections.sort(graduationCeremonies, new Comparator<GraduationCeremony>() {
				@Override
				public int compare(GraduationCeremony ceremony1, GraduationCeremony ceremony2) {

					return ceremony2.getDate().compareTo(ceremony1.getDate());
				}
			});
			Object graduationCeremony = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("graduationCeremony");
			if(graduationCeremony != null && graduationCeremonies.contains(graduationCeremony)) {
				selectedGraduationCeremony = (GraduationCeremony) graduationCeremony;
			} else {
				selectedGraduationCeremony = graduationCeremonies.get(0);
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("graduationCeremony",
						selectedGraduationCeremony);
			}
		}
	}

	public String save() {
		provider.saveGraduationCeremony(selectedGraduationCeremony);
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO,
						ResourceBundle.getBundle("messages").getString("msgSavedChanges"),
						ResourceBundle.getBundle("messages").getString("msgSavedChanges")));
		return null;
	}
	
	public void delete() {
		for(Enrollment enrollment : selectedGraduationCeremony.getEnrollments()) {
			enrollment.setGraduationDate(null);
		}
		provider.deleteGraduationCeremony(selectedGraduationCeremony);
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO,
						ResourceBundle.getBundle("messages").getString("msgGraduationCeremonyDeleted"),
						ResourceBundle.getBundle("messages").getString("msgGraduationCeremonyDeleted")));
		init();
	}
	
	public void update() {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("graduationCeremony", selectedGraduationCeremony);
	}
	
	public void previous() {
		int index = graduationCeremonies.indexOf(selectedGraduationCeremony);
		if(index > 0) {
			selectedGraduationCeremony = graduationCeremonies.get(index - 1);
			update();
		}
	}
	
	public void next() {
		int index = graduationCeremonies.indexOf(selectedGraduationCeremony);
		if(index < graduationCeremonies.size() - 1) {
			selectedGraduationCeremony = graduationCeremonies.get(index + 1);
			update();
		}
	}
	
	public void updateTabIndex(TabChangeEvent event) {
        tabIndex = event.getComponent().getChildren().indexOf(event.getTab());
    }

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	public List<GraduationCeremony> getGraduationCeremonies() {
		return graduationCeremonies;
	}

	public GraduationCeremony getSelectedGraduationCeremony() {
		return selectedGraduationCeremony;
	}

	public void setSelectedGraduationCeremony(GraduationCeremony selectedGraduationCeremony) {
		this.selectedGraduationCeremony = selectedGraduationCeremony;
	}

	public List<Room> getRooms() {
		return rooms;
	}

	public Integer getTabIndex() {
		return tabIndex;
	}

	public void setTabIndex(Integer tabIndex) {
		this.tabIndex = tabIndex;
	}
}
