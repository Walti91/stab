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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import data.Provider;
import model.Commission;
import model.ModelFactory;
import model.Professor;
import model.Room;

@ManagedBean(name = "newCommission")
@ViewScoped
public class NewCommissionController implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{provider}")
	private Provider provider;

	private Commission commission;
	private List<Room> rooms;
	private List<Professor> professors;

	private SimpleDateFormat dateFormat;

	@PostConstruct
	public void init() {
		rooms = provider.loadAllRooms();
		professors = provider.loadAllProfessors();
		commission = new ModelFactory().createCommission();
		dateFormat = new SimpleDateFormat(ResourceBundle.getBundle("messages").getString("dateFormat"));
	}

	public String save() {
		if (commission.getFrom().getTime() < commission.getTo().getTime()) {
			provider.saveCommission(commission);
			commission.getExaminationDate().addCommission(commission);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							ResourceBundle.getBundle("messages").getString("msgCommissionCreated"),
							ResourceBundle.getBundle("messages").getString("msgCommissionCreated")));
			return "/organization/commissions";
		}
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR,
						ResourceBundle.getBundle("messages").getString("msgCommissionInvalidTime"),
						ResourceBundle.getBundle("messages").getString("msgCommissionInvalidTime")));
		return null;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	public String format(Date date) {
		return dateFormat.format(date);
	}

	public Commission getCommission() {
		return commission;
	}

	public void setCommission(Commission commission) {
		this.commission = commission;
	}

	public List<Room> getRooms() {
		return rooms;
	}

	public List<Professor> getProfessors() {
		return professors;
	}
}
