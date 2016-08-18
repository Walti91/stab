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

package dao.dummy;

import dao.IAssignmentDAO;
import dao.ICommissionDAO;
import dao.ICourseDAO;
import dao.ICourseOfferDAO;
import dao.IDeaneryDAO;
import dao.IEnrollmentDAO;
import dao.IExamDAO;
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
import data.Storage;

public class DAOFactory {

	private Storage storage;

	public DAOFactory(Storage storage) {
		this.storage = storage;
	}

	public IAssignmentDAO createAssignmentDAO() {
		return new AssignmentDAO(storage);
	}
	
	public ICommissionDAO createCommissionDAO() {
		return new CommissionDAO(storage);
	}
	
	public ICourseDAO createCourseDAO() {
		return new CourseDAO(storage);
	}
	
	public ICourseOfferDAO createCourseOfferDAO() {
		return new CourseOfferDAO(storage);
	}
	
	public IDeaneryDAO createDeaneryDAO() {
		return new DeaneryDAO(storage);
	}
	
	public IEnrollmentDAO createEnrollmentDAO() {
		return new EnrollmentDAO(storage);
	}
	
	public IExamDAO createExamDAO() {
		return new ExamDAO(storage);
	}
	
	public IExaminationSubjectDAO createExaminationSubjectDAO() {
		return new ExaminationSubjectDAO(storage);
	}
	
	public IGraduationCeremonyDAO createGraduationCeremonyDAO() {
		return new GraduationCeremonyDAO(storage);
	}
	
	public IGraduationDateDAO createGraduationDateDAO() {
		return new GraduationDateDAO(storage);
	}
	
	public IInstituteDAO createInstituteDAO() {
		return new InstituteDAO(storage);
	}
	
	public IModuleDAO createModuleDAO() {
		return new ModuleDAO(storage);
	}
	
	public IModuleAssignmentDAO createModuleAssignmentDAO() {
		return new ModuleAssignmentDAO(storage);
	}
	
	public IProfessorDAO createProfessorDAO() {
		return new ProfessorDAO(storage);
	}
	
	public IRoomDAO createRoomDAO() {
		return new RoomDAO(storage);
	}
	
	public IStudentDAO createStudentDAO() {
		return new StudentDAO(storage);
	}
	
	public IStudyDAO createStudyDAO() {
		return new StudyDAO(storage);
	}
	
	public IThesisDAO createThesisDAO() {
		return new ThesisDAO(storage);
	}
	
	public IUserDAO createUserDAO() {
		return new UserDAO(storage);
	}
}
