package converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import data.Provider;
import model.GraduationCeremony;

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
