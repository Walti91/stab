package model;

import java.util.ArrayList;
import java.util.List;

public class ModuleAssignment {

	private Long id;
	private Module module;
	private List<Exam> exams;

	public ModuleAssignment() {
		exams = new ArrayList<Exam>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	public List<Exam> getExams() {
		return exams;
	}

	public void setExams(List<Exam> exams) {
		this.exams = exams;
	}

	public void addExam(Exam exam) {
		exams.add(exam);
	}
	
	public void removeExam(Exam exam) {
		exams.remove(exam);
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder(module.getName());
		sb.append(" (").append(module.getType()).append(")");
		return sb.toString();
	}
}
