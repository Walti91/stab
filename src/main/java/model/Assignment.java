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
