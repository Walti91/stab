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

package data;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import model.Assignment;
import model.Commission;
import model.Course;
import model.CourseOffer;
import model.Deanery;
import model.Enrollment;
import model.Exam;
import model.ExaminationSubject;
import model.GraduationCeremony;
import model.GraduationDate;
import model.Institute;
import model.Module;
import model.ModuleAssignment;
import model.Professor;
import model.Room;
import model.Student;
import model.Study;
import model.Thesis;
import model.User;

public class Storage {

	private Long id;
	private LinkedHashMap<Long, Assignment> assignments;
	private LinkedHashMap<Long, Commission> commissions;
	private LinkedHashMap<String, Course> courses;
	private LinkedHashMap<Long, CourseOffer> courseOffers;
	private Deanery deanery;
	private LinkedHashMap<Long, Enrollment> enrollments;
	private LinkedHashMap<Long, Exam> exams;
	private LinkedHashMap<Long, ExaminationSubject> examinationSubjects;
	private LinkedHashMap<Long, GraduationCeremony> graduationCeremonies;
	private LinkedHashMap<Long, GraduationDate> graduationDates;
	private LinkedHashMap<Long, Institute> institutes;
	private LinkedHashMap<Long, Module> modules;
	private LinkedHashMap<Long, ModuleAssignment> moduleAssignments;
	private LinkedHashMap<Long, Professor> professors;
	private LinkedHashMap<Long, Room> rooms;
	private LinkedHashMap<String, Student> students;
	private LinkedHashMap<String, Study> studies;
	private LinkedHashMap<Long, Thesis> theses;
	private LinkedHashMap<String, User> users;

	public Storage() {
		id = 1L;
		assignments = new LinkedHashMap<Long, Assignment>();
		commissions = new LinkedHashMap<Long, Commission>();
		courses = new LinkedHashMap<String, Course>();
		courseOffers = new LinkedHashMap<Long, CourseOffer>();
		enrollments = new LinkedHashMap<Long, Enrollment>();
		exams = new LinkedHashMap<Long, Exam>();
		examinationSubjects = new LinkedHashMap<Long, ExaminationSubject>();
		graduationCeremonies = new LinkedHashMap<Long, GraduationCeremony>();
		graduationDates = new LinkedHashMap<Long, GraduationDate>();
		institutes = new LinkedHashMap<Long, Institute>();
		modules = new LinkedHashMap<Long, Module>();
		moduleAssignments = new LinkedHashMap<Long, ModuleAssignment>();
		professors = new LinkedHashMap<Long, Professor>();
		rooms = new LinkedHashMap<Long, Room>();
		students = new LinkedHashMap<String, Student>();
		studies = new LinkedHashMap<String, Study>();
		theses = new LinkedHashMap<Long, Thesis>();
		users = new LinkedHashMap<String, User>();
		
		Generator.fill(this);
	}
	
	public Assignment loadAssignment(Long id) {
		return assignments.get(id);
	}
	
	public void saveAssignment(Assignment assignment) {
		if(assignment.getId() == null) {
			assignment.setId(id++);
		}
		assignments.put(assignment.getId(), assignment);
	}
	
	public Commission loadCommission(Long id) {
		return commissions.get(id);
	}
	
	public void saveCommission(Commission commission) {
		if(commission.getId() == null) {
			commission.setId(id++);
		}
		commissions.put(commission.getId(), commission);
	}
	
	public Course loadCourse(String number) {
		return courses.get(number);
	}

	public void saveCourse(Course course) {
		courses.put(course.getNumber(), course);
	}
	
	public CourseOffer loadCourseOffer(Long id) {
		return courseOffers.get(id);
	}

	public void saveCourseOffer(CourseOffer courseOffer) {
		if(courseOffer.getId() == null) {
			courseOffer.setId(id++);
		}
		courseOffers.put(courseOffer.getId(), courseOffer);
	}
	
	public Deanery loadDeanery() {
		return deanery;
	}
	
	public void saveDeanery(Deanery deanery) {
		if(deanery.getId() == null) {
			deanery.setId(id++);
		}
		this.deanery = deanery;
	}
	
	public Enrollment loadEnrollment(Long id) {
		return enrollments.get(id);
	}

	public List<Enrollment> loadAllEnrollments() {
		return new ArrayList<Enrollment>(enrollments.values());
	}

	public void saveEnrollment(Enrollment enrollment) {
		if(enrollment.getId() == null) {
			enrollment.setId(id++);
		}
		enrollments.put(enrollment.getId(), enrollment);
	}
	
	public Exam loadExam(Long id) {
		return exams.get(id);
	}

	public void saveExam(Exam exam) {
		if(exam.getId() == null) {
			exam.setId(id++);
		}
		exams.put(exam.getId(), exam);
	}
	
	public ExaminationSubject loadExaminationSubject(Long id) {
		return examinationSubjects.get(id);
	}

	public void saveExaminationSubject(ExaminationSubject examinationSubject) {
		if(examinationSubject.getId() == null) {
			examinationSubject.setId(id++);
		}
		examinationSubjects.put(examinationSubject.getId(), examinationSubject);
	}
	
	public GraduationCeremony loadGraduationCeremony(Long id) {
		return graduationCeremonies.get(id);
	}
	
	public List<GraduationCeremony> loadAllGraduationCeremonies() {
		return new ArrayList<GraduationCeremony>(graduationCeremonies.values());
	}
	
	public void saveGraduationCeremony(GraduationCeremony graduationCeremony) {
		if(graduationCeremony.getId() == null) {
			graduationCeremony.setId(id++);
		}
		graduationCeremonies.put(graduationCeremony.getId(), graduationCeremony);
	}
	
	public GraduationDate loadGraduationDate(Long id) {
		return graduationDates.get(id);
	}
	
	public List<GraduationDate> loadAllGraduationDates() {
		return new ArrayList<GraduationDate>(graduationDates.values());
	}

	public void saveGraduationDate(GraduationDate graduationDate) {
		if(graduationDate.getId() == null) {
			graduationDate.setId(id++);
		}
		graduationDates.put(graduationDate.getId(), graduationDate);
	}
	
	public Institute loadInstitute(Long id) {
		return institutes.get(id);
	}

	public List<Institute> loadAllInstitutes() {
		return new ArrayList<Institute>(institutes.values());
	}

	public void saveInstitute(Institute institute) {
		if(institute.getId() == null) {
			institute.setId(id++);
		}
		institutes.put(institute.getId(), institute);
	}
	
	public Module loadModule(Long id) {
		return modules.get(id);
	}

	public void saveModule(Module module) {
		if(module.getId() == null) {
			module.setId(id++);
		}
		modules.put(module.getId(), module);
	}

	public ModuleAssignment loadModuleAssignment(Long id) {
		return moduleAssignments.get(id);
	}
	
	public void saveModuleAssignment(ModuleAssignment moduleAssignment) {
		if(moduleAssignment.getId() == null) {
			moduleAssignment.setId(id++);
		}
		moduleAssignments.put(moduleAssignment.getId(), moduleAssignment);
	}
	
	public Professor loadProfessor(Long id) {
		return professors.get(id);
	}
	
	public List<Professor> loadAllProfessors() {
		return new ArrayList<Professor>(professors.values());
	}
	
	public void saveProfessor(Professor professor) {
		if(professor.getId() == null) {
			professor.setId(id++);
		}
		professors.put(professor.getId(), professor);
	}
	
	public Room loadRoom(Long id) {
		return rooms.get(id);
	}
	
	public List<Room> loadAllRooms() {
		return new ArrayList<Room>(rooms.values());
	}
	
	public void saveRoom(Room room) {
		if(room.getId() == null) {
			room.setId(id++);
		}
		rooms.put(room.getId(), room);
	}
	
	public Student loadStudent(String matriculationnumber) {
		return students.get(matriculationnumber);
	}

	public void saveStudent(Student student) {
		students.put(student.getMatriculationNumber(), student);
	}
	
	public Study loadStudy(String number) {
		return studies.get(number);
	}
	
	public List<Study> loadAllStudies() {
		return new ArrayList<Study>(studies.values());
	}

	public void saveStudy(Study study) {
		studies.put(study.getNumber(), study);
	}
	
	public Thesis loadThesis(Long id) {
		return theses.get(id);
	}

	public void saveThesis(Thesis thesis) {
		if(thesis.getId() == null) {
			thesis.setId(id++);
		}
		theses.put(thesis.getId(), thesis);
	}
	
	public User loadUser(String username) {
		return users.get(username);
	}

	public void saveUser(User user) {
		users.put(user.getUsername(), user);
	}
}
