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

public class ModelFactory {

	public Assignment createAssignment() {
		return new Assignment();
	}
	
	public Commission createCommission() {
		return new Commission();
	}
	
	public Course createCourse() {
		return new Course();
	}
	
	public CourseOffer createCourseOffer() {
		return new CourseOffer();
	}
	
	public Deanery createDeanery() {
		return new Deanery();
	}
	
	public Enrollment createEnrollment() {
		return new Enrollment();
	}

	public Exam createExam() {
		return new Exam();
	}
	
	public ExaminationSubject createExaminationSubject() {
		return new ExaminationSubject();
	}
	
	public GraduationCeremony createGraduationCeremony() {
		return new GraduationCeremony();
	}

	public GraduationDate createGraduationDate() {
		return new GraduationDate();
	}

	public Institute createInstitute() {
		return new Institute();
	}
	
	public Module createModule() {
		return new Module();
	}
	
	public ModuleAssignment createModuleAssignment() {
		return new ModuleAssignment();
	}

	public Professor createProfessor() {
		return new Professor();
	}
	
	public Room createRoom() {
		return new Room();
	}

	public Student createStudent() {
		return new Student();
	}

	public Study createStudy() {
		return new Study();
	}

	public Thesis createThesis() {
		return new Thesis();
	}
	
	public User createUser() {
		return new User();
	}
	
	public ExaminationDate createExaminationDate() {
		return new ExaminationDate();
	}
}
