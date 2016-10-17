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
