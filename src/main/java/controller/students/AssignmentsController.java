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

package controller.students;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import data.Provider;
import model.Assignment;
import model.Course;
import model.CourseOffer;
import model.Enrollment;
import model.Exam;
import model.ExaminationSubject;
import model.ModelFactory;
import model.Module;
import model.ModuleAssignment;

@ManagedBean
@ViewScoped
public class AssignmentsController implements Serializable {

	@ManagedProperty(value = "#{provider}")
	private Provider provider;
	
	private static final long serialVersionUID = 1L;
	private List<Assignment> assignments;
	private Enrollment enrollment;
	private Long selectedAssignment;
	private Long selectedExam;
	private List<Exam> exams;

	@PostConstruct
	public void init() {
		enrollment = (Enrollment) FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
				.get("enrollment");
		assignments = enrollment.getAssignments();
		if(assignments.isEmpty()) {
			ModelFactory modelFactory = new ModelFactory();
			for (ExaminationSubject examinationSubject : enrollment.getStudy().getExaminationSubjects()) {
				Assignment assignment = modelFactory.createAssignment();
				assignment.setExaminationSubject(examinationSubject);
				for (Module module : examinationSubject.getModules()) {
					ModuleAssignment moduleAssignment = modelFactory.createModuleAssignment();
					moduleAssignment.setModule(module);
					assignment.addModuleAssignment(moduleAssignment);
					provider.saveModuleAssignment(moduleAssignment);
				}
				enrollment.addAssignment(assignment);
				provider.saveAssignment(assignment);
			}
		}
		selectedAssignment = assignments.get(0).getId();
		exams = new ArrayList<Exam>();
		for (Exam exam : enrollment.getExams()) {
			if (exam.getModuleAssignment() == null) {
				exams.add(exam);
			}
		}
	}

	public String deleteAssignments() {
		for (Assignment assignment : assignments) {
			if (assignment.getConfirmed() == false) {
				for (ModuleAssignment moduleAssignment : assignment.getModuleAssignments()) {
					for (Exam exam : moduleAssignment.getExams()) {
						exam.setModuleAssignment(null);
						exams.add(exam);
					}
					moduleAssignment.setExams(new ArrayList<Exam>());
				}
			}
		}

		return null;
	}

	public String defaultAssignments() {
		deleteAssignments();
		for (Assignment assignment : assignments) {
			if (assignment.getConfirmed() == false) {
				for (ModuleAssignment moduleAssignment : assignment.getModuleAssignments()) {
					for (CourseOffer courseOffer : moduleAssignment.getModule().getCourseOffers()) {
						for (Course course : courseOffer.getCourses()) {
							Iterator<Exam> examIterator = exams.iterator();
							while (examIterator.hasNext()) {
								Exam exam = examIterator.next();
								if (exam.getCourse().getNumber().equals(course.getNumber())) {
									moduleAssignment.addExam(exam);
									exam.setModuleAssignment(moduleAssignment);
									examIterator.remove();
								}
							}
						}
					}
				}
			}
		}

		return null;
	}

	public String fromExamsToModule(Long id) {
		if (selectedExam != null && provider.loadAssignment(selectedAssignment).getConfirmed() == false) {
			ModuleAssignment moduleAssignment = provider.loadModuleAssignment(id);
			Exam exam = provider.loadExam(selectedExam);
			exam.setModuleAssignment(moduleAssignment);
			moduleAssignment.addExam(exam);
			exams.remove(exam);
		}
		return null;
	}

	public String fromModuleToExams(Long id) {
		if (selectedExam != null && provider.loadAssignment(selectedAssignment).getConfirmed() == false) {
			ModuleAssignment moduleAssignment = provider.loadModuleAssignment(id);
			Exam exam = provider.loadExam(selectedExam);
			exam.setModuleAssignment(null);
			moduleAssignment.removeExam(exam);
			exams.add(exam);
		}
		return null;

	}
	
	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	public List<Assignment> getAssignments() {
		return assignments;
	}

	public List<ModuleAssignment> getModuleAssignments() {
		if (selectedAssignment != null) {
			return provider.loadAssignment(selectedAssignment).getModuleAssignments();
		}
		return null;
	}

	public Double getAssigned() {
		return provider.loadAssignment(selectedAssignment).getAssigned();
	}

	public Boolean getConfirmed() {
		return provider.loadAssignment(selectedAssignment).getConfirmed();
	}

	public void setConfirmed(Boolean confirmed) {
		provider.loadAssignment(selectedAssignment).setConfirmed(confirmed);
	}

	public List<Exam> getExams() {
		return exams;
	}

	public Long getSelectedAssignment() {
		return selectedAssignment;
	}

	public void setSelectedAssignment(Long selectedAssignment) {
		this.selectedAssignment = selectedAssignment;
	}

	public Long getSelectedExam() {
		return selectedExam;
	}

	public void setSelectedExam(Long selectedExam) {
		this.selectedExam = selectedExam;
	}
}
