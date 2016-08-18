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

package controller;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import data.Provider;
import model.User;


/**
 * Controller for the login/logout functionality.
 * 
 * @author Florian Waltenberger
 */

@ManagedBean(name = "authentication")
@SessionScoped
public class AuthenticationController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ManagedProperty(value = "#{provider}")
	private Provider provider;
	
	private User user;
	/**
	 * This property is mapped to a textfield on the login.xhtml page.
	 */
	private String username;
	/**
	 * This property is mapped to a textfield on the login.xhtml page.
	 */
	private String password;

	/**
	 * This method is called once the login button on the login.xhtml page is
	 * pressed. Loads a student via the provider and with the specified
	 * matriculationnumber. If there is no student with that number or the
	 * password does not match with the one entered, a error message is
	 * displayed and null is returned. If the login succeeds the loaded student
	 * will be saved in the session and the user will be forwarded to the
	 * welcome.xhtml page.
	 * 
	 * @return Welcome page if the login was successful, null otherwise.
	 */

	public String login() {
		User user = provider.loadUser(username);
		if (user != null && user.getPassword().equals(password)) {
			this.user = user;
			return "/students/bachelorStudents";
		}
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ungültige Anmeldedaten!", "Ungültige Anmeldedaten!"));
		return null;
	}

	/**
	 * This method is called when the logout link, specified in the
	 * template.xhtml file and therefore available on every page, is clicked.
	 * The session is invalidated, the user is returned to the start page and a
	 * info message is displayed.
	 * 
	 * @return The login page.
	 */
	public String logout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Abmeldung erfolgreich!", "Abmeldung erfolgreich!"));
		return "/login";
	}
	
	public Boolean isLoggedIn() {
		if(user != null) {
			return true;
		}
		return false;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
