package model;

import java.util.ArrayList;
import java.util.List;

public class Assignment {

	private Long id;
	private Boolean confirmed;
	private ExaminationSubject examinationSubject;
	private List<ModuleAssignment> moduleAssignments;

	public Assignment() {
		moduleAssignments = new ArrayList<ModuleAssignment>();
		confirmed = false;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Boolean getConfirmed() {
		return confirmed;
	}

	public void setConfirmed(Boolean confirmed) {
		this.confirmed = confirmed;
	}

	public ExaminationSubject getExaminationSubject() {
		return examinationSubject;
	}

	public void setExaminationSubject(ExaminationSubject examinationSubject) {
		this.examinationSubject = examinationSubject;
	}

	public List<ModuleAssignment> getModuleAssignments() {
		return moduleAssignments;
	}

	public void setModuleAssignments(List<ModuleAssignment> moduleAssignments) {
		this.moduleAssignments = moduleAssignments;
	}

	public void addModuleAssignment(ModuleAssignment moduleAssignment) {
		moduleAssignments.add(moduleAssignment);
	}
	
	public Double getAssigned() {
		Double assigned = 0.0;
		for(ModuleAssignment moduleAssignment : getModuleAssignments()) {
			for(Exam exam : moduleAssignment.getExams()) {
				assigned += exam.getCourse().getCourseOffer().getEcts();
			}
		}
		
		return assigned;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder(examinationSubject.toString());
		if(confirmed == true) {
			sb.append(" (bestätigt)");
		}
		return sb.toString();
	}
}
