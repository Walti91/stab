/**
	Copyright (C) 2016 Florian Waltenberger

 This program is free software: you can redistribute it and/or modify
 it under the terms of the GNU General public  License as published by
 the Free Software Foundation, either version 3 of the License, or
 (at your option) any later version.

 This program is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 GNU General public  License for more details.

 You should have received a copy of the GNU General public  License
 along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package data;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import dao.IAssignmentDAO;
import dao.ICommissionDAO;
import dao.ICourseDAO;
import dao.ICourseOfferDAO;
import dao.IDeaneryDAO;
import dao.IEnrollmentDAO;
import dao.IExamDAO;
import dao.IExaminationDateDAO;
import dao.IExaminationSubjectDAO;
import dao.IGraduationCeremonyDAO;
import dao.IGraduationDateDAO;
import dao.IInstituteDAO;
import dao.IModuleAssignmentDAO;
import dao.IModuleDAO;
import dao.IProfessorDAO;
import dao.IRoomDAO;
import dao.IStudentDAO;
import dao.IStudyDAO;
import dao.IThesisDAO;
import dao.IUserDAO;
import dao.dummy.DAOFactory;
import model.Assignment;
import model.Commission;
import model.Course;
import model.CourseOffer;
import model.Deanery;
import model.Enrollment;
import model.Exam;
import model.ExaminationDate;
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

@ManagedBean(eager = true)
@ApplicationScoped
public class Provider {

	private Storage storage;
	private IAssignmentDAO assignmentDAO;
	private ICommissionDAO commissionDAO;
	private ICourseDAO courseDAO;
	private ICourseOfferDAO courseOfferDAO;
	private IDeaneryDAO deaneryDAO;
	private IEnrollmentDAO enrollmentDAO;
	private IExamDAO examDAO;
	private IExaminationSubjectDAO examinationSubjectDAO;
	private IGraduationCeremonyDAO graduationCeremonyDAO;
	private IGraduationDateDAO graduationDateDAO;
	private IInstituteDAO instituteDAO;
	private IModuleAssignmentDAO moduleAssignmentDAO;
	private IModuleDAO moduleDAO;
	private IProfessorDAO professorDAO;
	private IRoomDAO roomDAO;
	private IStudentDAO studentDAO;
	private IStudyDAO studyDAO;
	private IThesisDAO thesisDAO;
	private IUserDAO userDAO;
	private IExaminationDateDAO examinationDateDAO;

	@PostConstruct
	public void init() {
		storage = new Storage();
		DAOFactory factory = new DAOFactory(storage);
		assignmentDAO = factory.createAssignmentDAO();
		commissionDAO = factory.createCommissionDAO();
		courseDAO = factory.createCourseDAO();
		courseOfferDAO = factory.createCourseOfferDAO();
		deaneryDAO = factory.createDeaneryDAO();
		enrollmentDAO = factory.createEnrollmentDAO();
		examDAO = factory.createExamDAO();
		examinationSubjectDAO = factory.createExaminationSubjectDAO();
		graduationCeremonyDAO = factory.createGraduationCeremonyDAO();
		graduationDateDAO = factory.createGraduationDateDAO();
		instituteDAO = factory.createInstituteDAO();
		moduleDAO = factory.createModuleDAO();
		moduleAssignmentDAO = factory.createModuleAssignmentDAO();
		professorDAO = factory.createProfessorDAO();
		roomDAO = factory.createRoomDAO();
		studentDAO = factory.createStudentDAO();
		studyDAO = factory.createStudyDAO();
		thesisDAO = factory.createThesisDAO();
		userDAO = factory.createUserDAO();
		examinationDateDAO = factory.createExaminationDateDAO();
	}

	public Assignment loadAssignment(Long id) {
		return assignmentDAO.load(id);
	}

	public void saveAssignment(Assignment assignment) {
		assignmentDAO.save(assignment);
	}

	public Commission loadCommission(Long id) {
		return commissionDAO.load(id);
	}

	public void saveCommission(Commission commission) {
		commissionDAO.save(commission);
	}

	public Course loadCourse(String number) {
		return courseDAO.load(number);
	}

	public void saveCourse(Course course) {
		courseDAO.save(course);
	}

	public CourseOffer loadCourseOffer(Long id) {
		return courseOfferDAO.load(id);
	}

	public void saveCourseOffer(CourseOffer courseOffer) {
		courseOfferDAO.save(courseOffer);
	}

	public Deanery loadDeanery() {
		return deaneryDAO.load();
	}

	public void saveDeanery(Deanery deanery) {
		deaneryDAO.save(deanery);
	}

	public Enrollment loadEnrollment(Long id) {
		return enrollmentDAO.load(id);
	}

	public List<Enrollment> loadAllEnrollments() {
		return enrollmentDAO.loadAll();
	}

	public void saveEnrollment(Enrollment enrollment) {
		enrollmentDAO.save(enrollment);
	}

	public Exam loadExam(Long id) {
		return examDAO.load(id);
	}

	public void saveExam(Exam exam) {
		examDAO.save(exam);
	}

	public ExaminationSubject loadExaminationSubject(Long id) {
		return examinationSubjectDAO.load(id);
	}

	public void saveExaminationSubject(ExaminationSubject examinationSubject) {
		examinationSubjectDAO.save(examinationSubject);
	}

	public GraduationCeremony loadGraduationCeremony(Long id) {
		return graduationCeremonyDAO.load(id);
	}

	public List<GraduationCeremony> loadAllGraduationCeremonies() {
		return graduationCeremonyDAO.loadAll();
	}

	public void saveGraduationCeremony(GraduationCeremony graduationCeremony) {
		graduationCeremonyDAO.save(graduationCeremony);
	}

	public GraduationDate loadGraduationDate(Long id) {
		return graduationDateDAO.load(id);
	}

	public List<GraduationDate> loadAllGraduationDates() {
		return graduationDateDAO.loadAll();
	}

	public void saveGraduationDate(GraduationDate graduationDate) {
		graduationDateDAO.save(graduationDate);
	}

	public Institute loadInstitute(Long id) {
		return instituteDAO.load(id);
	}

	public List<Institute> loadAllInstitutes() {
		return instituteDAO.loadAll();
	}

	public void saveInstitute(Institute institute) {
		instituteDAO.save(institute);
	}

	public Module loadModule(Long id) {
		return moduleDAO.load(id);
	}

	public void saveModule(Module module) {
		moduleDAO.save(module);
	}

	public ModuleAssignment loadModuleAssignment(Long id) {
		return moduleAssignmentDAO.load(id);
	}

	public void saveModuleAssignment(ModuleAssignment moduleAssignment) {
		moduleAssignmentDAO.save(moduleAssignment);
	}

	public Professor loadProfessor(Long id) {
		return professorDAO.load(id);
	}

	public List<Professor> loadAllProfessors() {
		return professorDAO.loadAll();
	}

	public void saveProfessor(Professor professor) {
		professorDAO.save(professor);
	}

	public Room loadRoom(Long id) {
		return roomDAO.load(id);
	}

	public List<Room> loadAllRooms() {
		return roomDAO.loadAll();
	}

	public void saveRoom(Room room) {
		roomDAO.save(room);
	}

	public Student loadStudent(String matriculationnumber) {
		return studentDAO.load(matriculationnumber);
	}

	public void saveStudent(Student student) {
		studentDAO.save(student);
	}

	public Study loadStudy(String number) {
		return studyDAO.load(number);
	}

	public List<Study> loadAllStudies() {
		return studyDAO.loadAll();
	}

	public void saveStudy(Study study) {
		studyDAO.save(study);
	}

	public Thesis loadThesis(Long id) {
		return thesisDAO.load(id);
	}

	public void saveThesis(Thesis thesis) {
		thesisDAO.save(thesis);
	}

	public User loadUser(String username) {
		return userDAO.load(username);
	}

	public void saveUser(User user) {
		userDAO.save(user);
	}
	
	public void deleteGraduationCeremony(GraduationCeremony graduationCeremony) {
		graduationCeremonyDAO.delete(graduationCeremony);
	}

	public void deleteGraduationDate(GraduationDate graduationDate) {
		graduationDateDAO.delete(graduationDate);
	}
	
	public ExaminationDate loadExaminationDate(Long id) {
		return examinationDateDAO.load(id);
	}

	public void saveExaminationDate(ExaminationDate examinationDate) {
		examinationDateDAO.save(examinationDate);
	}
}
