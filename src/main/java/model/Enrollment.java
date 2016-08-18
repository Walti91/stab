package model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class Enrollment implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private Date enrolled;
	private Date finished;
	private Student student;
	private Study study;
	private List<Exam> exams;
	private List<Assignment> assignments;
	private Thesis thesis;
	private GraduationDate graduationDate;
	private Commission commission;
	private GraduationCeremony graduationCeremony;

	public Enrollment() {
		exams = new ArrayList<Exam>();
		assignments = new ArrayList<Assignment>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getEnrolled() {
		return enrolled;
	}

	public void setEnrolled(Date enrolled) {
		this.enrolled = enrolled;
	}

	public Date getFinished() {
		return finished;
	}

	public void setFinished(Date finished) {
		this.finished = finished;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Study getStudy() {
		return study;
	}

	public void setStudy(Study study) {
		this.study = study;
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

	public List<Assignment> getAssignments() {
		return assignments;
	}

	public void setAssignments(List<Assignment> assignments) {
		this.assignments = assignments;
	}

	public void addAssignment(Assignment assignment) {
		assignments.add(assignment);
	}

	public Thesis getThesis() {
		return thesis;
	}

	public void setThesis(Thesis thesis) {
		this.thesis = thesis;
	}

	public GraduationDate getGraduationDate() {
		return graduationDate;
	}

	public void setGraduationDate(GraduationDate graduationDate) {
		this.graduationDate = graduationDate;
	}

	public Commission getCommission() {
		return commission;
	}

	public void setCommission(Commission commission) {
		this.commission = commission;
	}
	
	public GraduationCeremony getGraduationCeremony() {
		return graduationCeremony;
	}

	public void setGraduationCeremony(GraduationCeremony graduationCeremony) {
		this.graduationCeremony = graduationCeremony;
	}

	public String toString() {
		SimpleDateFormat dateFormat = new SimpleDateFormat(ResourceBundle.getBundle("messages").getString("dateFormat"));
		StringBuilder sb = new StringBuilder(student.getLastName());
		sb.append(" ").append(student.getFirstName());
		sb.append(" ").append(student.getMatriculationNumber());
		sb.append(" / ").append(study.getNumber());
		if(finished != null) {
			sb.append(" Abgeschlossen am ").append(dateFormat.format(finished));
		}
		return sb.toString();
	}
}
