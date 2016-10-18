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
		if (!graduationDate.getDates().isEmpty()) {
			if (graduationDate.getRegistrationFrom().getTime() < graduationDate.getRegistrationTo().getTime()) {
				if (graduationDate.getRegistrationTo().getTime() < graduationDate.getDates().get(0).getDate()
						.getTime()) {
					provider.saveGraduationDate(graduationDate);
					FacesContext.getCurrentInstance().addMessage(null,
							new FacesMessage(FacesMessage.SEVERITY_INFO,
									ResourceBundle.getBundle("messages").getString("msgGraduationDateCreated"),
									ResourceBundle.getBundle("messages").getString("msgGraduationDateCreated")));
					FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("graduationDate",
							graduationDate);
					return "/organization/graduationDates";
				} else {
					FacesContext.getCurrentInstance().addMessage(null,
							new FacesMessage(FacesMessage.SEVERITY_ERROR,
									ResourceBundle.getBundle("messages").getString("msgInvalidRegistrationEnd"),
									ResourceBundle.getBundle("messages").getString("msgInvalidRegistrationEnd")));
				}
			} else {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR,
								ResourceBundle.getBundle("messages").getString("msgInvalidRegistrationTime"),
								ResourceBundle.getBundle("messages").getString("msgInvalidRegistrationTime")));
			}
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							ResourceBundle.getBundle("messages").getString("msgNoExaminationDate"),
							ResourceBundle.getBundle("messages").getString("msgNoExaminationDate")));
		}
		return null;
	}

	public String removeDate(Long id) {
		ExaminationDate date = provider.loadExaminationDate(id);
		graduationDate.getDates().remove(date);
		return null;
	}

	public String addDate() {
		if (newDate != null) {
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
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_WARN,
							ResourceBundle.getBundle("messages").getString("msgInvalidExaminationDate"),
							ResourceBundle.getBundle("messages").getString("msgInvalidExaminationDate")));
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
