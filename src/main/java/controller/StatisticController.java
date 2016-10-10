package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import model.Assignment;
import model.Enrollment;
import model.Exam;
import model.GraduationCeremony;
import model.GraduationDate;
import model.ModuleAssignment;

@SessionScoped
@ManagedBean(name = "statistic")
public class StatisticController implements Serializable {
	
	private static final long serialVersionUID = 1L;

	public List<StatisticResult> createStatistic(List<Enrollment> enrollments) {
		StatisticResult bachelors = new StatisticResult(ResourceBundle.getBundle("messages").getString("labelBachelors"));
		StatisticResult masters = new StatisticResult(ResourceBundle.getBundle("messages").getString("labelMasters"));
		StatisticResult sum = new StatisticResult(ResourceBundle.getBundle("messages").getString("labelSum"));
		
		for(Enrollment enrollment : enrollments) {
			if(enrollment.getStudy().getType().equals("Masterstudium")) {
				masters.increaseCounter();
				if(enrollment.getStudent().getGender().equals("männlich")) {
					masters.increaseMale();
				} else {
					masters.increaseFemale();
				}
				if(enrollment.getAssignments() != null && !enrollment.getAssignments().isEmpty()) {
					Double counter = 0.0;
					for(Assignment assignment : enrollment.getAssignments()) {
						for(ModuleAssignment moduleAssignment : assignment.getModuleAssignments()) {
							for(Exam exam : moduleAssignment.getExams()) {
								counter += exam.getGrade() * exam.getCourse().getCourseOffer().getEcts();
							}
						}
					}
					if(counter / 120 < 1.5) {
						masters.increaseDistinction();
					}
				}
			} else {
				bachelors.increaseCounter();
				if(enrollment.getStudent().getGender().equals("männlich")) {
					bachelors.increaseMale();
				} else {
					bachelors.increaseFemale();
				}
				if(enrollment.getAssignments() != null && !enrollment.getAssignments().isEmpty()) {
					Double counter = 0.0;
					for(Assignment assignment : enrollment.getAssignments()) {
						for(ModuleAssignment moduleAssignment : assignment.getModuleAssignments()) {
							for(Exam exam : moduleAssignment.getExams()) {
								counter += exam.getGrade() * exam.getCourse().getCourseOffer().getEcts();
							}
						}
					}
					if(counter / 180 < 1.5) {
						bachelors.increaseDistinction();
					}
				}
			}
		}
		sum.setCounter(bachelors.getCounter() + masters.getCounter());
		sum.setMale(bachelors.getMale() + masters.getMale());
		sum.setFemale(bachelors.getFemale() + masters.getFemale());
		sum.setDistinction(bachelors.getDistinction() + masters.getDistinction());
		
		List<StatisticResult> result = new ArrayList<StatisticResult>();
		result.add(bachelors);
		result.add(masters);
		result.add(sum);
		
		return result;
	}
	
	public List<StatisticResult> handleGraduationDate() {
		GraduationDate graduationDate = (GraduationDate) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("graduationDate");
		return createStatistic(graduationDate.getEnrollments());
	}
	
	public List<StatisticResult> handleGraduationCeremony() {
		GraduationCeremony graduationCeremony = (GraduationCeremony) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("graduationCeremony");
		return createStatistic(graduationCeremony.getEnrollments());
	}
}
