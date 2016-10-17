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

	/**
	 * Loads and sorts all graduation ceremonies. If there is already a ceremony
	 * saved in the session it will be selected. Otherwise the first entry of
	 * the list will be selected.
	 */
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
			Object graduationCeremony = FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
					.get("graduationCeremony");
			if (graduationCeremony != null && graduationCeremonies.contains(graduationCeremony)) {
				selectedGraduationCeremony = (GraduationCeremony) graduationCeremony;
			} else {
				selectedGraduationCeremony = graduationCeremonies.get(0);
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("graduationCeremony",
						selectedGraduationCeremony);
			}
		}
	}

	/**
	 * Saved the graduation ceremony and displays a message to the user.
	 * 
	 * @return
	 */
	public String save() {
		provider.saveGraduationCeremony(selectedGraduationCeremony);
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO,
						ResourceBundle.getBundle("messages").getString("msgSavedChanges"),
						ResourceBundle.getBundle("messages").getString("msgSavedChanges")));
		return null;
	}

	/**
	 * Deletes the selected graduation ceremony and reloads the page.
	 * 
	 * @return
	 */
	public String delete() {
		for (Enrollment enrollment : selectedGraduationCeremony.getEnrollments()) {
			enrollment.setGraduationDate(null);
		}
		provider.deleteGraduationCeremony(selectedGraduationCeremony);
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO,
						ResourceBundle.getBundle("messages").getString("msgGraduationCeremonyDeleted"),
						ResourceBundle.getBundle("messages").getString("msgGraduationCeremonyDeleted")));
		return "/organization/graduationCeremonies";
	}

	/**
	 * Keeps the session in sync with the selected graduation ceremony.
	 */
	public void updateSession() {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("graduationCeremony",
				selectedGraduationCeremony);
	}

	/**
	 * Saves the selected tab while switching graduation ceremonies.
	 * 
	 * @param event
	 */
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
