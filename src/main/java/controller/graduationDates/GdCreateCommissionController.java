package controller.graduationDates;

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
import model.GraduationDate;
import model.ModelFactory;
import model.Professor;
import model.Room;

@ManagedBean(name = "gdCreateCommission")
@ViewScoped
public class GdCreateCommissionController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ManagedProperty(value = "#{provider}")
	private Provider provider;
	
	private GraduationDate graduationDate;
	private SimpleDateFormat dateFormat;
	private List<Professor> professors;
	private List<Room> rooms;
	private Date date;
	private Date from;
	private Date to;
	private Long room;
	private Long chairman;
	
	@PostConstruct
	public void init() {
		graduationDate = (GraduationDate) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("graduationDate");
		dateFormat = new SimpleDateFormat(ResourceBundle.getBundle("messages").getString("dateFormat"));
		professors = provider.loadAllProfessors();
		rooms = provider.loadAllRooms();
	}
	
	public String saveCommission() {
		if(date != null && from != null && to != null && room != null && chairman != null) {
			Commission commission = new ModelFactory().createCommission();
			commission.setDate(date);
			commission.setFrom(from);
			commission.setTo(to);
			commission.setRoom(provider.loadRoom(room));
			commission.setChairman(provider.loadProfessor(chairman));
			commission.setGraduationDate(graduationDate);
			graduationDate.addCommission(commission);
			provider.saveCommission(commission);
			return "/graduationDates/commissions";
		}

		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
				"Bitte beachten Sie das alle Felder Pflichtfelder sind!", "Bitte beachten Sie das alle Felder Pflichtfelder sind!"));
		
		return null;
	}
	
	public String format(Date date) {
		return dateFormat.format(date);
	}
	
	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	public List<Professor> getProfessors() {
		return professors;
	}

	public List<Room> getRooms() {
		return rooms;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getFrom() {
		return from;
	}

	public void setFrom(Date from) {
		this.from = from;
	}

	public Date getTo() {
		return to;
	}

	public void setTo(Date to) {
		this.to = to;
	}
	
	public Long getRoom() {
		return room;
	}

	public void setRoom(Long room) {
		this.room = room;
	}

	public Long getChairman() {
		return chairman;
	}

	public void setChairman(Long chairman) {
		this.chairman = chairman;
	}
}
