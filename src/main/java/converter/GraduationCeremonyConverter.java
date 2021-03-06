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

package converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import data.Provider;
import model.GraduationCeremony;

/**
 * Converter for graduation ceremonies. Uses the id and reloads the enrollments
 * via provider.
 * 
 * @author Florian Waltenberger
 * @see Provider
 * @see GraduationCeremony
 */
@FacesConverter("graduationCeremonyConverter")
public class GraduationCeremonyConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value != null && value.trim().length() > 0) {
			Provider provider = (Provider) context.getExternalContext().getApplicationMap().get("provider");
			return provider.loadGraduationCeremony(Long.parseLong(value));
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			return String.valueOf(((GraduationCeremony) value).getId());
		}
		return null;
	}
}
