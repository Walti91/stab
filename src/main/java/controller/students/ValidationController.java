package controller.students;

import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import data.Provider;
import model.Assignment;
import model.Exam;
import model.ModuleAssignment;

@ManagedBean
public class ValidationController {

	@ManagedProperty(value = "#{provider}")
	private Provider provider;
	
	public String validateAssignment(Long id) {
		Assignment assignment = provider.loadAssignment(id);
		StringBuilder sb = new StringBuilder();
		if(assignment.getConfirmed()) {
			Double ects = 0.0;
			Double grade = 0.0;
			for(ModuleAssignment moduleAssignment : assignment.getModuleAssignments()) {
				for(Exam exam : moduleAssignment.getExams()) {
					grade += exam.getGrade() * exam.getCourse().getCourseOffer().getEcts();
					ects += exam.getCourse().getCourseOffer().getEcts();
				}
			}
			if(ects.equals(0.0)) {
				sb.append("keine Zuordnungen\t0.0 EC");
			} else {
				sb.append("Zuordnungen vollst‰ndig,\tÿ-Note ");
				sb.append(new BigDecimal(grade / ects).setScale(2, RoundingMode.HALF_UP));
				sb.append("\t").append(assignment.getAssigned());
				sb.append(" EC");
			}
		} else {
			sb.append("Zuordnungen unvollst‰ndig");
		}
		
		return sb.toString();
	}
	
	public Boolean hasCommission(Long id) {
		return provider.loadEnrollment(id).getStudy().getType().equals("Masterstudium");
	}
	
	public void setProvider(Provider provider) {
		this.provider = provider;
	}
}
