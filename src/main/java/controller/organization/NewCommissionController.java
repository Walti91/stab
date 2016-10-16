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
				new FacesMessage(FacesMessage.SEVERITY_WARN,
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
