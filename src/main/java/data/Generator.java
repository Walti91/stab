/**
	Copyright (C) 2016 Florian Waltenberger

  This program is free software: you can redistribute it and/or modify
  it under the terms of the GNU General Public License as published by
  the Free Software Foundation, either version 3 of the License, or
  (at your option) any later version.

  This program is distributed in the hope that it will be useful,
  but WITHOUT ANY WARRANTY; without even the implied warranty of
  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
  GNU General Public License for more details.

  You should have received a copy of the GNU General Public License
  along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

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
import model.ModelFactory;
import model.Module;
import model.ModuleAssignment;
import model.Professor;
import model.Room;
import model.Student;
import model.Study;
import model.Thesis;
import model.User;

public class Generator {

	private static ModelFactory modelFactory;
	private static SimpleDateFormat inputFormat;

	private static Room room;
	private static Professor chairman;
	private static Enrollment bachelor;
	private static Professor principal;
	private static Professor vicePrincipal;
	private static Professor dean;
	
	public static void fill(Storage storage) {
		try {
			modelFactory = new ModelFactory();
			inputFormat = new SimpleDateFormat(ResourceBundle.getBundle("messages").getString("inputFormat"));
			createUser(storage);
			createStudent1(storage);
			createStudent2(storage);
			createInstitutes(storage);
			createStudy1(storage);
			createStudy2(storage);
			createRooms(storage);
			createEnrollment1(storage);
			createEnrollment2(storage);
			createGraduationCeremony(storage);
			createDeanery(storage);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	private static void createUser(Storage storage) {

		User user = modelFactory.createUser();
		user.setUsername("1234");
		user.setPassword("asdf");
		user.setFirstName("Test");
		user.setLastName("User");
		storage.saveUser(user);
	}

	private static void createStudent1(Storage storage) throws ParseException {

		Student student = modelFactory.createStudent();
		student.setMatriculationNumber("1212345");
		student.setPassword("asdf");
		student.setFirstName("Bachelor");
		student.setLastName("Student");
		student.setBirthdate(inputFormat.parse("01.01.1990 12:00"));
		student.setGender("männlich");
		student.setCitizenship("Österreich");
		student.setStreet("Dummygasse 1");
		student.setPostalcode("1050");
		student.setCity("Wien");
		student.setCountry("Österreich");
		storage.saveStudent(student);
	}

	private static void createStudent2(Storage storage) throws ParseException {

		Student student = modelFactory.createStudent();
		student.setMatriculationNumber("1112345");
		student.setPassword("asdf");
		student.setFirstName("Master");
		student.setLastName("Student");
		student.setTitle("BSc");
		student.setBirthdate(inputFormat.parse("01.01.1980 12:00"));
		student.setGender("weiblich");
		student.setCitizenship("Österreich");
		student.setStreet("Dummygasse 5");
		student.setPostalcode("1050");
		student.setCity("Wien");
		student.setCountry("Österreich");
		storage.saveStudent(student);
	}

	private static void createInstitutes(Storage storage) {

		Institute institute = modelFactory.createInstitute();
		institute.setName("E182 - Institut für Technische Informatik");

		Professor professor = modelFactory.createProfessor();
		professor.setFirstName("Ulrich");
		professor.setLastName("Schmid");
		professor.setTitle("Univ.Prof. Dipl.-Ing. Dr.techn.");
		institute.addAdviser(professor);
		storage.saveProfessor(professor);
		chairman = professor;

		professor = modelFactory.createProfessor();
		professor.setFirstName("Peter");
		professor.setLastName("Puschner");
		professor.setTitle("Ao.Univ.Prof. Dipl.-Ing. Dr.techn");
		institute.addAdviser(professor);
		storage.saveProfessor(professor);
		principal = professor;

		professor = modelFactory.createProfessor();
		professor.setFirstName("Andreas");
		professor.setLastName("Steininger");
		professor.setTitle("Ao.Univ.Prof. Dipl.-Ing. Dr.techn.");
		institute.addAdviser(professor);
		storage.saveProfessor(professor);
		vicePrincipal = professor;

		professor = modelFactory.createProfessor();
		professor.setFirstName("Ezio");
		professor.setLastName("Bartocci");
		professor.setTitle("Assistant Prof. Dr.");
		institute.addAssistant(professor);
		storage.saveProfessor(professor);
		dean = professor;

		professor = modelFactory.createProfessor();
		professor.setFirstName("Bekim");
		professor.setLastName("Chilku");
		professor.setTitle("Projektass. Mag.");
		institute.addAssistant(professor);
		storage.saveProfessor(professor);

		professor = modelFactory.createProfessor();
		professor.setFirstName("Lukas");
		professor.setLastName("Esterle");
		professor.setTitle("Univ.Ass. Dipl.-Ing. Dr.techn. Bakk.techn.");
		institute.addAssistant(professor);
		storage.saveProfessor(professor);

		professor = modelFactory.createProfessor();
		professor.setFirstName("Bernhard");
		professor.setLastName("Frömel");
		professor.setTitle("Projektass. Dipl.-Ing. BSc");
		institute.addAssistant(professor);
		storage.saveProfessor(professor);

		professor = modelFactory.createProfessor();
		professor.setFirstName("Julian");
		professor.setLastName("Grahsl");
		professor.setTitle("Projektass. Dipl.-Ing. BSc");
		institute.addAssistant(professor);
		storage.saveProfessor(professor);

		professor = modelFactory.createProfessor();
		professor.setFirstName("Oliver");
		professor.setLastName("Höftberger");
		professor.setTitle("Projektass. Dipl.-Ing. Dr.techn.");
		institute.addAssistant(professor);
		storage.saveProfessor(professor);

		professor = modelFactory.createProfessor();
		professor.setFirstName("Haris");
		professor.setLastName("Isakovic");
		professor.setTitle("Projektass. Dipl.-Ing. BSc");
		institute.addAssistant(professor);
		storage.saveProfessor(professor);

		professor = modelFactory.createProfessor();
		professor.setFirstName("Hermann");
		professor.setLastName("Kopetz");
		professor.setTitle("O.Univ.Prof. Projektass. Dr.phil. Dr.h.c.");
		institute.addAssistant(professor);
		storage.saveProfessor(professor);

		professor = modelFactory.createProfessor();
		professor.setFirstName("Anna");
		professor.setLastName("Lukina");
		professor.setTitle("Projektass.(FWF) MSc");
		institute.addAssistant(professor);
		storage.saveProfessor(professor);

		professor = modelFactory.createProfessor();
		professor.setFirstName("Jürgen");
		professor.setLastName("Maier");
		professor.setTitle("Projektass.(FWF) Dipl.-Ing. BSc");
		institute.addAssistant(professor);
		storage.saveProfessor(professor);

		professor = modelFactory.createProfessor();
		professor.setFirstName("Hasani Ramin");
		professor.setLastName("Mohammad");
		professor.setTitle("Projektass. Mag.");
		institute.addAssistant(professor);
		storage.saveProfessor(professor);

		professor = modelFactory.createProfessor();
		professor.setFirstName("Robert");
		professor.setLastName("Najvirt");
		professor.setTitle("Univ.Ass. Dipl.-Ing. Bakk.techn.");
		institute.addAssistant(professor);
		storage.saveProfessor(professor);

		professor = modelFactory.createProfessor();
		professor.setFirstName("Martin");
		professor.setLastName("Perner");
		professor.setTitle("Univ.Ass. Dipl.-Ing. BSc");
		institute.addAssistant(professor);
		storage.saveProfessor(professor);

		professor = modelFactory.createProfessor();
		professor.setFirstName("Thomas");
		professor.setLastName("Polzer");
		professor.setTitle("Univ.Ass. Dipl.-Ing. Dr.techn. BSc");
		institute.addAssistant(professor);
		storage.saveProfessor(professor);

		professor = modelFactory.createProfessor();
		professor.setFirstName("Daniel Leo");
		professor.setLastName("Prokesch");
		professor.setTitle("Univ.Ass. Dipl.-Ing. BSc");
		institute.addAssistant(professor);
		storage.saveProfessor(professor);

		professor = modelFactory.createProfessor();
		professor.setFirstName("Denise");
		professor.setLastName("Ratasich");
		professor.setTitle("Univ.Ass. Dipl.-Ing. BSc");
		institute.addAssistant(professor);
		storage.saveProfessor(professor);

		professor = modelFactory.createProfessor();
		professor.setFirstName("Veeravalli Varadan");
		professor.setLastName("Savulimedu");
		professor.setTitle("Projektass.(FWF) MSc");
		institute.addAssistant(professor);
		storage.saveProfessor(professor);

		professor = modelFactory.createProfessor();
		professor.setFirstName("Manfred");
		professor.setLastName("Schwarz");
		professor.setTitle("Projektass.(FWF) Dipl.-Ing. BSc");
		institute.addAssistant(professor);
		storage.saveProfessor(professor);

		professor = modelFactory.createProfessor();
		professor.setFirstName("Konstantin");
		professor.setLastName("Selyunin");
		professor.setTitle("Projektass. MSc");
		institute.addAssistant(professor);
		storage.saveProfessor(professor);

		professor = modelFactory.createProfessor();
		professor.setFirstName("Guodong");
		professor.setLastName("Wang");
		professor.setTitle("Kolleg. MSc");
		institute.addAssistant(professor);
		storage.saveProfessor(professor);

		professor = modelFactory.createProfessor();
		professor.setFirstName("Armin");
		professor.setLastName("Wasicek");
		professor.setTitle("Projektass. Dipl.-Ing. Dr.techn.");
		institute.addAssistant(professor);
		storage.saveProfessor(professor);

		professor = modelFactory.createProfessor();
		professor.setFirstName("Josef");
		professor.setLastName("Widder");
		professor.setTitle("Privatdoz. Dipl.-Ing. Dr.techn.");
		institute.addAssistant(professor);
		storage.saveProfessor(professor);

		professor = modelFactory.createProfessor();
		professor.setFirstName("Kyrill");
		professor.setLastName("Winkler");
		professor.setTitle("Projektass.(FWF) Dipl.-Ing.");
		institute.addAssistant(professor);
		storage.saveProfessor(professor);

		professor = modelFactory.createProfessor();
		professor.setFirstName("Martin");
		professor.setLastName("Zeiner");
		professor.setTitle("Projektass.(FWF) Dipl.-Ing. Dr.techn.");
		institute.addAssistant(professor);
		storage.saveProfessor(professor);

		storage.saveInstitute(institute);

		institute = modelFactory.createInstitute();
		institute.setName("E183 - Institut für Rechnergestützte Automation");

		professor = modelFactory.createProfessor();
		professor.setFirstName("Johann");
		professor.setLastName("Blieberger");
		professor.setTitle("Ao.Univ.Prof. Dipl.-Ing. Dr.techn.");
		institute.addAdviser(professor);
		storage.saveProfessor(professor);

		professor = modelFactory.createProfessor();
		professor.setFirstName("Thomas");
		professor.setLastName("Grechenig");
		professor.setTitle("Ao.Univ.Prof. Dipl.-Ing. Dr.techn.");
		institute.addAdviser(professor);
		storage.saveProfessor(professor);

		professor = modelFactory.createProfessor();
		professor.setFirstName("Wolfgang");
		professor.setLastName("Kastner");
		professor.setTitle("Ao.Univ.Prof. Dipl.-Ing. Dr.techn.");
		institute.addAdviser(professor);
		storage.saveProfessor(professor);

		professor = modelFactory.createProfessor();
		professor.setFirstName("Tehrani Maliheh");
		professor.setLastName("Assadpour");
		professor.setTitle("Kolleg. MSc");
		institute.addAssistant(professor);
		storage.saveProfessor(professor);

		professor = modelFactory.createProfessor();
		professor.setFirstName("Markus");
		professor.setLastName("Bader");
		professor.setTitle("Univ.Ass. Dipl.-Ing. Dr.techn.");
		institute.addAssistant(professor);
		storage.saveProfessor(professor);

		professor = modelFactory.createProfessor();
		professor.setFirstName("Matthias");
		professor.setLastName("Baldauf");
		professor.setTitle("Projektass. Dipl.-Ing. Mag.rer.soc.oec. Dr.techn.");
		institute.addAssistant(professor);
		storage.saveProfessor(professor);

		professor = modelFactory.createProfessor();
		professor.setFirstName("Rene");
		professor.setLastName("Baranyi");
		professor.setTitle("Projektass. Dipl.-Ing. Bakk.techn.");
		institute.addAssistant(professor);
		storage.saveProfessor(professor);

		professor = modelFactory.createProfessor();
		professor.setFirstName("Brigitte");
		professor.setLastName("Brem");
		professor.setTitle("Projektass. Dr.rer.nat. Mag.rer.nat.");
		institute.addAssistant(professor);
		storage.saveProfessor(professor);

		storage.saveInstitute(institute);

		institute = modelFactory.createInstitute();
		institute.setName("E184 - Institut für Informationssysteme");

		professor = modelFactory.createProfessor();
		professor.setFirstName("Schahram");
		professor.setLastName("Dustdar");
		professor.setTitle("Univ.Prof. Mag.rer.soc.oec. Dr.rer.soc.oec.");
		institute.addAdviser(professor);
		storage.saveProfessor(professor);

		professor = modelFactory.createProfessor();
		professor.setFirstName("Uwe");
		professor.setLastName("Egly");
		professor.setTitle("Ao.Univ.Prof. Dipl.-Ing. Dr.rer.nat.");
		institute.addAdviser(professor);
		storage.saveProfessor(professor);

		professor = modelFactory.createProfessor();
		professor.setFirstName("Georg");
		professor.setLastName("Gottlob");
		professor.setTitle("O.Univ.Prof. Dipl.-Ing. Dr.techn.");
		institute.addAdviser(professor);
		storage.saveProfessor(professor);

		professor = modelFactory.createProfessor();
		professor.setFirstName("Michael");
		professor.setLastName("Abseher");
		professor.setTitle("Projektass.(FWF) Dipl.-Ing. BSc");
		institute.addAssistant(professor);
		storage.saveProfessor(professor);

		professor = modelFactory.createProfessor();
		professor.setFirstName("Shqiponja");
		professor.setLastName("Ahmetaj");
		professor.setTitle("Projektass.(FWF) MSc M.Sc.A.");
		institute.addAssistant(professor);
		storage.saveProfessor(professor);

		professor = modelFactory.createProfessor();
		professor.setFirstName("Benjamin");
		professor.setLastName("Aminof");
		professor.setTitle("Projektass. PhD");
		institute.addAssistant(professor);
		storage.saveProfessor(professor);

		professor = modelFactory.createProfessor();
		professor.setFirstName("Labinot");
		professor.setLastName("Bajraktari");
		professor.setTitle("Projektass.(FWF) MSc");
		institute.addAssistant(professor);
		storage.saveProfessor(professor);

		professor = modelFactory.createProfessor();
		professor.setFirstName("Harald");
		professor.setLastName("Beck");
		professor.setTitle("Projektass.(FWF) Dipl.-Ing. Bakk.techn.");
		institute.addAssistant(professor);
		storage.saveProfessor(professor);

		storage.saveInstitute(institute);

		institute = modelFactory.createInstitute();
		institute.setName("E185 - Institut für Computersprachen");

		storage.saveInstitute(institute);

		institute = modelFactory.createInstitute();
		institute.setName("E186 - Institut für Computergraphik und Algorithmen");

		storage.saveInstitute(institute);

		institute = modelFactory.createInstitute();
		institute.setName("E187 - Institut für Gestaltungs- und Wirkungsforschung");

		storage.saveInstitute(institute);

		institute = modelFactory.createInstitute();
		institute.setName("E188 - Institut für Softwaretechnik und Interaktive Systeme");

		professor = modelFactory.createProfessor();
		professor.setFirstName("Stefan");
		professor.setLastName("Biffl");
		professor.setTitle("Ao.Univ.Prof. Dipl.-Ing. Mag. Mag.rer.soc.oec. Dr.techn.");
		institute.addAdviser(professor);
		storage.saveProfessor(professor);

		professor = modelFactory.createProfessor();
		professor.setFirstName("Ivona");
		professor.setLastName("Brandic");
		professor.setTitle("Univ.Prof. Mag.rer.soc.oec. Dr.rer.soc.oec.");
		institute.addAdviser(professor);
		storage.saveProfessor(professor);

		professor = modelFactory.createProfessor();
		professor.setFirstName("Christian");
		professor.setLastName("Breiteneder");
		professor.setTitle("Univ.Prof. Dipl.-Ing. Dr.techn.");
		institute.addAdviser(professor);
		storage.saveProfessor(professor);

		professor = modelFactory.createProfessor();
		professor.setFirstName("Wolfgang");
		professor.setLastName("Aigner");
		professor.setTitle("Privatdoz. Dipl.-Ing. Dr.techn.");
		institute.addAssistant(professor);
		storage.saveProfessor(professor);

		professor = modelFactory.createProfessor();
		professor.setFirstName("Roger");
		professor.setLastName("Almeida Leite");
		professor.setTitle("Projektass. BSc MSc");
		institute.addAssistant(professor);
		storage.saveProfessor(professor);

		professor = modelFactory.createProfessor();
		professor.setFirstName("Albert");
		professor.setLastName("Amor-Amoros");
		professor.setTitle("Projektass. MSc");
		institute.addAssistant(professor);
		storage.saveProfessor(professor);

		professor = modelFactory.createProfessor();
		professor.setFirstName("Linda");
		professor.setLastName("Andersson");
		professor.setTitle("Projektass. M.A.");
		institute.addAssistant(professor);
		storage.saveProfessor(professor);

		professor = modelFactory.createProfessor();
		professor.setFirstName("Luca");
		professor.setLastName("Berardinelli");
		professor.setTitle("Projektass. PhD");
		institute.addAssistant(professor);
		storage.saveProfessor(professor);

		storage.saveInstitute(institute);

		institute = modelFactory.createInstitute();
		institute.setName("E195 - Zentrum für Koordination & Kommunikation der Fakultät für Informatik");

		storage.saveInstitute(institute);

		institute = modelFactory.createInstitute();
		institute.setName("E520 - Studiendekanat für Informatik");

		storage.saveInstitute(institute);

		institute = modelFactory.createInstitute();
		institute.setName("E525 - Studiendekanat für Wirtschaftsinformatik");

		storage.saveInstitute(institute);
	}

	private static void createStudy1(Storage storage) {

		Study study = modelFactory.createStudy();
		study.setNumber("033 534");
		study.setType("Bachelorstudium");
		study.setName("Software & Information Engineering");
		study.setCertificateGerman("Universitätsgesetz 2002");
		study.setThesisNameGerman("Bachelorarbeit");
		study.setThesisNameEnglish("Bachelor Thesis");

		ExaminationSubject examinationSubject = modelFactory.createExaminationSubject();
		examinationSubject.setName("Algorithmen und Programmierung");

		Module module = modelFactory.createModule();
		module.setName("Algorithmen und Datenstrukturen");
		module.setType("Pflichtlehrveranstaltungen");

		CourseOffer courseOffer = modelFactory.createCourseOffer();
		courseOffer.setType("VU");
		courseOffer.setHours(4.0);
		courseOffer.setEcts(6.0);
		courseOffer.setName("Algorithmen und Datenstrukturen 1");
		Course course = modelFactory.createCourse();
		course.setNumber("186.813");
		course.setCourseOffer(courseOffer);
		courseOffer.addCourse(course);
		storage.saveCourse(course);
		storage.saveCourseOffer(courseOffer);
		module.addCourseOffer(courseOffer);

		courseOffer = modelFactory.createCourseOffer();
		courseOffer.setType("VU");
		courseOffer.setHours(2.0);
		courseOffer.setEcts(3.0);
		courseOffer.setName("Algorithmen und Datenstrukturen 2");
		course = modelFactory.createCourse();
		course.setNumber("186.815");
		course.setCourseOffer(courseOffer);
		courseOffer.addCourse(course);
		storage.saveCourse(course);
		storage.saveCourseOffer(courseOffer);
		module.addCourseOffer(courseOffer);

		storage.saveModule(module);
		examinationSubject.addModule(module);

		module = modelFactory.createModule();
		module.setName("Programmierparadigmen");
		module.setType("Pflichtlehrveranstaltungen");

		courseOffer = modelFactory.createCourseOffer();
		courseOffer.setType("VU");
		courseOffer.setHours(2.0);
		courseOffer.setEcts(3.0);
		courseOffer.setName("Objektorientierte Programmiertechniken");
		course = modelFactory.createCourse();
		course.setNumber("185.A01");
		course.setCourseOffer(courseOffer);
		courseOffer.addCourse(course);
		storage.saveCourse(course);
		storage.saveCourseOffer(courseOffer);
		module.addCourseOffer(courseOffer);

		courseOffer = modelFactory.createCourseOffer();
		courseOffer.setType("VU");
		courseOffer.setHours(2.0);
		courseOffer.setEcts(3.0);
		courseOffer.setName("Funktionale Programmierung");
		course = modelFactory.createCourse();
		course.setNumber("185.A03");
		course.setCourseOffer(courseOffer);
		courseOffer.addCourse(course);
		storage.saveCourse(course);
		storage.saveCourseOffer(courseOffer);
		module.addCourseOffer(courseOffer);

		storage.saveModule(module);
		examinationSubject.addModule(module);

		module = modelFactory.createModule();
		module.setName("Programmkonstruktion");
		module.setType("Pflichtlehrveranstaltungen");

		courseOffer = modelFactory.createCourseOffer();
		courseOffer.setType("VU");
		courseOffer.setHours(6.0);
		courseOffer.setEcts(8.8);
		courseOffer.setName("Programmkonstruktion");
		course = modelFactory.createCourse();
		course.setNumber("185.A79");
		course.setCourseOffer(courseOffer);
		courseOffer.addCourse(course);
		storage.saveCourse(course);
		storage.saveCourseOffer(courseOffer);
		module.addCourseOffer(courseOffer);

		storage.saveModule(module);
		examinationSubject.addModule(module);

		module = modelFactory.createModule();
		module.setName("Studieneingangsgespräch");
		module.setType("Pflichtlehrveranstaltungen");

		courseOffer = modelFactory.createCourseOffer();
		courseOffer.setType("UE");
		courseOffer.setHours(1.0);
		courseOffer.setEcts(0.2);
		courseOffer.setName("Studieneingangsgespräch");
		course = modelFactory.createCourse();
		course.setNumber("195.039");
		course.setCourseOffer(courseOffer);
		courseOffer.addCourse(course);
		storage.saveCourse(course);
		storage.saveCourseOffer(courseOffer);
		module.addCourseOffer(courseOffer);

		storage.saveModule(module);
		examinationSubject.addModule(module);

		module = modelFactory.createModule();
		module.setName("Deklaratives Problemlösen");
		module.setType("Wahllehrveranstaltungen");

		storage.saveModule(module);
		examinationSubject.addModule(module);

		module = modelFactory.createModule();
		module.setName("Logikprogrammierung und Constraints");
		module.setType("Wahllehrveranstaltungen");

		storage.saveModule(module);
		examinationSubject.addModule(module);

		module = modelFactory.createModule();
		module.setName("Parallel Computing");
		module.setType("Wahllehrveranstaltungen");

		courseOffer = modelFactory.createCourseOffer();
		courseOffer.setType("VU");
		courseOffer.setHours(4.0);
		courseOffer.setEcts(6.0);
		courseOffer.setName("Parallel Computing Einführung paralleles Rechnen");
		course = modelFactory.createCourse();
		course.setNumber("184.710");
		course.setCourseOffer(courseOffer);
		courseOffer.addCourse(course);
		storage.saveCourse(course);
		storage.saveCourseOffer(courseOffer);
		module.addCourseOffer(courseOffer);

		storage.saveModule(module);
		examinationSubject.addModule(module);

		storage.saveExaminationSubject(examinationSubject);
		study.addExaminationSubject(examinationSubject);

		examinationSubject = modelFactory.createExaminationSubject();
		examinationSubject.setName("Computersysteme");

		module = modelFactory.createModule();
		module.setName("Betriebssysteme");
		module.setType("Pflichtlehrveranstaltungen");

		courseOffer = modelFactory.createCourseOffer();
		courseOffer.setType("VO");
		courseOffer.setHours(2.0);
		courseOffer.setEcts(2.0);
		courseOffer.setName("Betriebssysteme");
		course = modelFactory.createCourse();
		course.setNumber("182.711");
		course.setCourseOffer(courseOffer);
		courseOffer.addCourse(course);
		storage.saveCourse(course);
		storage.saveCourseOffer(courseOffer);
		module.addCourseOffer(courseOffer);

		courseOffer = modelFactory.createCourseOffer();
		courseOffer.setType("UE");
		courseOffer.setHours(2.0);
		courseOffer.setEcts(4.0);
		courseOffer.setName("Betriebssysteme");
		course = modelFactory.createCourse();
		course.setNumber("182.709");
		course.setCourseOffer(courseOffer);
		courseOffer.addCourse(course);
		storage.saveCourse(course);
		storage.saveCourseOffer(courseOffer);
		module.addCourseOffer(courseOffer);

		storage.saveModule(module);
		examinationSubject.addModule(module);

		module = modelFactory.createModule();
		module.setName("Einführung in Visual Computing");
		module.setType("Pflichtlehrveranstaltungen");

		courseOffer = modelFactory.createCourseOffer();
		courseOffer.setType("VU");
		courseOffer.setHours(5.0);
		courseOffer.setEcts(6.0);
		courseOffer.setName("Einführung in Visual Computing");
		course = modelFactory.createCourse();
		course.setNumber("186.822");
		course.setCourseOffer(courseOffer);
		courseOffer.addCourse(course);
		storage.saveCourse(course);
		storage.saveCourseOffer(courseOffer);
		module.addCourseOffer(courseOffer);

		storage.saveModule(module);
		examinationSubject.addModule(module);

		module = modelFactory.createModule();
		module.setName("Technische Grundlagen der Informatik");
		module.setType("Pflichtlehrveranstaltungen");

		courseOffer = modelFactory.createCourseOffer();
		courseOffer.setType("VU");
		courseOffer.setHours(4.0);
		courseOffer.setEcts(6.0);
		courseOffer.setName("Technische Grundlagen für Informatik");
		course = modelFactory.createCourse();
		course.setNumber("183.579");
		course.setCourseOffer(courseOffer);
		courseOffer.addCourse(course);
		storage.saveCourse(course);
		storage.saveCourseOffer(courseOffer);
		module.addCourseOffer(courseOffer);

		storage.saveModule(module);
		examinationSubject.addModule(module);

		module = modelFactory.createModule();
		module.setName("Verteilte Systeme");
		module.setType("Pflichtlehrveranstaltungen");

		courseOffer = modelFactory.createCourseOffer();
		courseOffer.setType("VO");
		courseOffer.setHours(2.0);
		courseOffer.setEcts(3.0);
		courseOffer.setName("Verteilte Systeme");
		course = modelFactory.createCourse();
		course.setNumber("184.237");
		course.setCourseOffer(courseOffer);
		courseOffer.addCourse(course);
		storage.saveCourse(course);
		storage.saveCourseOffer(courseOffer);
		module.addCourseOffer(courseOffer);

		courseOffer = modelFactory.createCourseOffer();
		courseOffer.setType("UE");
		courseOffer.setHours(2.0);
		courseOffer.setEcts(3.0);
		courseOffer.setName("Verteilte Systeme");
		course = modelFactory.createCourse();
		course.setNumber("184.167");
		course.setCourseOffer(courseOffer);
		courseOffer.addCourse(course);
		storage.saveCourse(course);
		storage.saveCourseOffer(courseOffer);
		module.addCourseOffer(courseOffer);

		storage.saveModule(module);
		examinationSubject.addModule(module);

		module = modelFactory.createModule();
		module.setName("Abstrakte Maschinen");
		module.setType("Wahllehrveranstaltungen");

		storage.saveModule(module);
		examinationSubject.addModule(module);

		module = modelFactory.createModule();
		module.setName("Microcontroller und Betriebssysteme");
		module.setType("Wahllehrveranstaltungen");

		storage.saveModule(module);
		examinationSubject.addModule(module);

		module = modelFactory.createModule();
		module.setName("Übersetzerbau");
		module.setType("Wahllehrveranstaltungen");

		storage.saveModule(module);
		examinationSubject.addModule(module);

		module = modelFactory.createModule();
		module.setName("Zuverlässige Echtzeitsysteme");
		module.setType("Wahllehrveranstaltungen");

		storage.saveModule(module);
		examinationSubject.addModule(module);

		storage.saveExaminationSubject(examinationSubject);
		study.addExaminationSubject(examinationSubject);

		examinationSubject = modelFactory.createExaminationSubject();
		examinationSubject.setName("Informatik und Gesellschaft");

		module = modelFactory.createModule();
		module.setName("Grundlagen der Human Computer Interaction");
		module.setType("Pflichtlehrveranstaltungen");

		courseOffer = modelFactory.createCourseOffer();
		courseOffer.setType("VU");
		courseOffer.setHours(2.0);
		courseOffer.setEcts(3.0);
		courseOffer.setName("Gesellschaftliche Spannungsfelder der Informatik");
		course = modelFactory.createCourse();
		course.setNumber("187.237");
		course.setCourseOffer(courseOffer);
		courseOffer.addCourse(course);
		storage.saveCourse(course);
		storage.saveCourseOffer(courseOffer);
		module.addCourseOffer(courseOffer);

		courseOffer = modelFactory.createCourseOffer();
		courseOffer.setType("VU");
		courseOffer.setHours(2.0);
		courseOffer.setEcts(3.0);
		courseOffer.setName("Basics of Human Computer Interaction");
		course = modelFactory.createCourse();
		course.setNumber("187.A21");
		course.setCourseOffer(courseOffer);
		courseOffer.addCourse(course);
		storage.saveCourse(course);
		storage.saveCourseOffer(courseOffer);
		module.addCourseOffer(courseOffer);

		storage.saveModule(module);
		examinationSubject.addModule(module);

		module = modelFactory.createModule();
		module.setName("Kontexte der Systementwicklung");
		module.setType("Pflichtlehrveranstaltungen");

		courseOffer = modelFactory.createCourseOffer();
		courseOffer.setType("VU");
		courseOffer.setHours(2.0);
		courseOffer.setEcts(3.0);
		courseOffer.setName("Gesellschaftswissenschaftliche Grundlagen der Informatik");
		course = modelFactory.createCourse();
		course.setNumber("187.272");
		course.setCourseOffer(courseOffer);
		courseOffer.addCourse(course);
		storage.saveCourse(course);
		storage.saveCourseOffer(courseOffer);
		module.addCourseOffer(courseOffer);

		courseOffer = modelFactory.createCourseOffer();
		courseOffer.setType("VU");
		courseOffer.setHours(2.0);
		courseOffer.setEcts(3.0);
		courseOffer.setName("Interface and Interaction Design");
		course = modelFactory.createCourse();
		course.setNumber("183.289");
		course.setCourseOffer(courseOffer);
		courseOffer.addCourse(course);
		storage.saveCourse(course);
		storage.saveCourseOffer(courseOffer);
		module.addCourseOffer(courseOffer);

		storage.saveModule(module);
		examinationSubject.addModule(module);

		module = modelFactory.createModule();
		module.setName("Security und Recht");
		module.setType("Pflichtlehrveranstaltungen");

		courseOffer = modelFactory.createCourseOffer();
		courseOffer.setType("VU");
		courseOffer.setHours(2.0);
		courseOffer.setEcts(3.0);
		courseOffer.setName("Introduction to Security");
		course = modelFactory.createCourse();
		course.setNumber("188.916");
		course.setCourseOffer(courseOffer);
		courseOffer.addCourse(course);
		storage.saveCourse(course);
		storage.saveCourseOffer(courseOffer);
		module.addCourseOffer(courseOffer);

		courseOffer = modelFactory.createCourseOffer();
		courseOffer.setType("VU");
		courseOffer.setHours(2.0);
		courseOffer.setEcts(3.0);
		courseOffer.setName("Daten- und Informatikrecht");
		course = modelFactory.createCourse();
		course.setNumber("265.068");
		course.setCourseOffer(courseOffer);
		courseOffer.addCourse(course);
		storage.saveCourse(course);
		storage.saveCourseOffer(courseOffer);
		module.addCourseOffer(courseOffer);

		storage.saveModule(module);
		examinationSubject.addModule(module);

		module = modelFactory.createModule();
		module.setName("Security");
		module.setType("Wahllehrveranstaltungen");

		courseOffer = modelFactory.createCourseOffer();
		courseOffer.setType("VU");
		courseOffer.setHours(2.0);
		courseOffer.setEcts(3.0);
		courseOffer.setName("Internet Security");
		course = modelFactory.createCourse();
		course.setNumber("188.366");
		course.setCourseOffer(courseOffer);
		courseOffer.addCourse(course);
		storage.saveCourse(course);
		storage.saveCourseOffer(courseOffer);
		module.addCourseOffer(courseOffer);

		courseOffer = modelFactory.createCourseOffer();
		courseOffer.setType("VU");
		courseOffer.setHours(2.0);
		courseOffer.setEcts(3.0);
		courseOffer.setName("Security for Systems Engineering");
		course = modelFactory.createCourse();
		course.setNumber("183.637");
		course.setCourseOffer(courseOffer);
		courseOffer.addCourse(course);
		storage.saveCourse(course);
		storage.saveCourseOffer(courseOffer);
		module.addCourseOffer(courseOffer);

		storage.saveModule(module);
		examinationSubject.addModule(module);

		module = modelFactory.createModule();
		module.setName("Vertrags-, Daten- und Informatikrecht");
		module.setType("Wahllehrveranstaltungen");

		storage.saveModule(module);
		examinationSubject.addModule(module);

		storage.saveExaminationSubject(examinationSubject);
		study.addExaminationSubject(examinationSubject);

		examinationSubject = modelFactory.createExaminationSubject();
		examinationSubject.setName("Information Engineering");

		module = modelFactory.createModule();
		module.setName("Datenbanksysteme");
		module.setType("Pflichtlehrveranstaltungen");

		courseOffer = modelFactory.createCourseOffer();
		courseOffer.setType("VU");
		courseOffer.setHours(4.0);
		courseOffer.setEcts(6.0);
		courseOffer.setName("Datenbanksysteme");
		course = modelFactory.createCourse();
		course.setNumber("184.686");
		course.setCourseOffer(courseOffer);
		courseOffer.addCourse(course);
		storage.saveCourse(course);
		storage.saveCourseOffer(courseOffer);
		module.addCourseOffer(courseOffer);

		storage.saveModule(module);
		examinationSubject.addModule(module);

		module = modelFactory.createModule();
		module.setName("Grundlagen intelligenter Systeme");
		module.setType("Pflichtlehrveranstaltungen");

		courseOffer = modelFactory.createCourseOffer();
		courseOffer.setType("VU");
		courseOffer.setHours(2.0);
		courseOffer.setEcts(3.0);
		courseOffer.setName("Einführung in die Künstliche Intelligenz");
		course = modelFactory.createCourse();
		course.setNumber("184.735");
		course.setCourseOffer(courseOffer);
		courseOffer.addCourse(course);
		storage.saveCourse(course);
		storage.saveCourseOffer(courseOffer);
		module.addCourseOffer(courseOffer);

		courseOffer = modelFactory.createCourseOffer();
		courseOffer.setType("VU");
		courseOffer.setHours(3.0);
		courseOffer.setEcts(5.0);
		courseOffer.setName("Einführung in wissensbasierte Systeme");
		course = modelFactory.createCourse();
		course.setNumber("184.737");
		course.setCourseOffer(courseOffer);
		courseOffer.addCourse(course);
		storage.saveCourse(course);
		storage.saveCourseOffer(courseOffer);
		module.addCourseOffer(courseOffer);

		storage.saveModule(module);
		examinationSubject.addModule(module);

		module = modelFactory.createModule();
		module.setName("Entwicklung von Web-Anwendungen");
		module.setType("Wahllehrveranstaltungen");

		courseOffer = modelFactory.createCourseOffer();
		courseOffer.setType("VU");
		courseOffer.setHours(2.0);
		courseOffer.setEcts(3.0);
		courseOffer.setName("Semistrukturierte Daten");
		course = modelFactory.createCourse();
		course.setNumber("184.705");
		course.setCourseOffer(courseOffer);
		courseOffer.addCourse(course);
		storage.saveCourse(course);
		storage.saveCourseOffer(courseOffer);
		module.addCourseOffer(courseOffer);

		courseOffer = modelFactory.createCourseOffer();
		courseOffer.setType("VU");
		courseOffer.setHours(2.0);
		courseOffer.setEcts(3.0);
		courseOffer.setName("Web Engineering");
		course = modelFactory.createCourse();
		course.setNumber("188.951");
		course.setCourseOffer(courseOffer);
		courseOffer.addCourse(course);
		storage.saveCourse(course);
		storage.saveCourseOffer(courseOffer);
		module.addCourseOffer(courseOffer);

		storage.saveModule(module);
		examinationSubject.addModule(module);

		module = modelFactory.createModule();
		module.setName("Modelle und Modellierung von statistischen Daten");
		module.setType("Wahllehrveranstaltungen");

		storage.saveModule(module);
		examinationSubject.addModule(module);

		module = modelFactory.createModule();
		module.setName("Statistische Datenanalyse");
		module.setType("Wahllehrveranstaltungen");

		storage.saveModule(module);
		examinationSubject.addModule(module);

		module = modelFactory.createModule();
		module.setName("Wissensrepräsentation");
		module.setType("Wahllehrveranstaltungen");

		storage.saveModule(module);
		examinationSubject.addModule(module);

		storage.saveExaminationSubject(examinationSubject);
		study.addExaminationSubject(examinationSubject);

		examinationSubject = modelFactory.createExaminationSubject();
		examinationSubject.setName("Mathematik, Statistik und Theoretische Informatik");

		module = modelFactory.createModule();
		module.setName("Algebra und Diskrete Mathematik");
		module.setType("Pflichtlehrveranstaltungen");

		courseOffer = modelFactory.createCourseOffer();
		courseOffer.setType("VO");
		courseOffer.setHours(4.0);
		courseOffer.setEcts(4.0);
		courseOffer.setName("Algebra und Diskrete Mathematik für Informatik und Wirtschaftsinformatik");
		course = modelFactory.createCourse();
		course.setNumber("104.265");
		course.setCourseOffer(courseOffer);
		courseOffer.addCourse(course);
		storage.saveCourse(course);
		storage.saveCourseOffer(courseOffer);
		module.addCourseOffer(courseOffer);

		courseOffer = modelFactory.createCourseOffer();
		courseOffer.setType("UE");
		courseOffer.setHours(2.0);
		courseOffer.setEcts(5.0);
		courseOffer.setName("Algebra und Diskrete Mathematik für Informatik und Wirtschaftsinformatik");
		course = modelFactory.createCourse();
		course.setNumber("104.263");
		course.setCourseOffer(courseOffer);
		courseOffer.addCourse(course);
		storage.saveCourse(course);
		storage.saveCourseOffer(courseOffer);
		module.addCourseOffer(courseOffer);

		storage.saveModule(module);
		examinationSubject.addModule(module);

		module = modelFactory.createModule();
		module.setName("Analysis");
		module.setType("Pflichtlehrveranstaltungen");

		courseOffer = modelFactory.createCourseOffer();
		courseOffer.setType("VO");
		courseOffer.setHours(2.0);
		courseOffer.setEcts(2.0);
		courseOffer.setName("Analysis für Informatik und Wirtschaftsinformatik");
		course = modelFactory.createCourse();
		course.setNumber("104.261");
		course.setCourseOffer(courseOffer);
		courseOffer.addCourse(course);
		storage.saveCourse(course);
		storage.saveCourseOffer(courseOffer);
		module.addCourseOffer(courseOffer);

		courseOffer = modelFactory.createCourseOffer();
		courseOffer.setType("UE");
		courseOffer.setHours(2.0);
		courseOffer.setEcts(4.0);
		courseOffer.setName("Analysis für Informatik und Wirtschaftsinformatik");
		course = modelFactory.createCourse();
		course.setNumber("104.262");
		course.setCourseOffer(courseOffer);
		courseOffer.addCourse(course);
		storage.saveCourse(course);
		storage.saveCourseOffer(courseOffer);
		module.addCourseOffer(courseOffer);

		storage.saveModule(module);
		examinationSubject.addModule(module);

		module = modelFactory.createModule();
		module.setName("Statistik und Wahrscheinlichkeitstheorie");
		module.setType("Pflichtlehrveranstaltungen");

		courseOffer = modelFactory.createCourseOffer();
		courseOffer.setType("VO");
		courseOffer.setHours(2.0);
		courseOffer.setEcts(3.0);
		courseOffer.setName("Statistik und Wahrscheinlichkeitstheorie");
		course = modelFactory.createCourse();
		course.setNumber("107.273");
		course.setCourseOffer(courseOffer);
		courseOffer.addCourse(course);
		storage.saveCourse(course);
		storage.saveCourseOffer(courseOffer);
		module.addCourseOffer(courseOffer);

		courseOffer = modelFactory.createCourseOffer();
		courseOffer.setType("UE");
		courseOffer.setHours(2.0);
		courseOffer.setEcts(3.0);
		courseOffer.setName("Statistik und Wahrscheinlichkeitstheorie");
		course = modelFactory.createCourse();
		course.setNumber("107.370");
		course.setCourseOffer(courseOffer);
		courseOffer.addCourse(course);
		storage.saveCourse(course);
		storage.saveCourseOffer(courseOffer);
		module.addCourseOffer(courseOffer);

		storage.saveModule(module);
		examinationSubject.addModule(module);

		module = modelFactory.createModule();
		module.setName("Theoretische Informatik und Logik");
		module.setType("Pflichtlehrveranstaltungen");

		courseOffer = modelFactory.createCourseOffer();
		courseOffer.setType("VU");
		courseOffer.setHours(4.0);
		courseOffer.setEcts(6.0);
		courseOffer.setName("Theoretische Informatik und Logik");
		course = modelFactory.createCourse();
		course.setNumber("185.278");
		course.setCourseOffer(courseOffer);
		courseOffer.addCourse(course);
		storage.saveCourse(course);
		storage.saveCourseOffer(courseOffer);
		module.addCourseOffer(courseOffer);

		storage.saveModule(module);
		examinationSubject.addModule(module);

		module = modelFactory.createModule();
		module.setName("Computernumerik");
		module.setType("Wahllehrveranstaltungen");

		storage.saveModule(module);
		examinationSubject.addModule(module);

		module = modelFactory.createModule();
		module.setName("Multivariate und computerintensive statistische Methoden");
		module.setType("Wahllehrveranstaltungen");

		storage.saveModule(module);
		examinationSubject.addModule(module);

		module = modelFactory.createModule();
		module.setName("Argumentieren und Beweisen");
		module.setType("Wahllehrveranstaltungen");

		storage.saveModule(module);
		examinationSubject.addModule(module);

		storage.saveExaminationSubject(examinationSubject);
		study.addExaminationSubject(examinationSubject);

		examinationSubject = modelFactory.createExaminationSubject();
		examinationSubject.setName("Software Engineering");

		module = modelFactory.createModule();
		module.setName("Modellierung");
		module.setType("Pflichtlehrveranstaltungen");

		courseOffer = modelFactory.createCourseOffer();
		courseOffer.setType("VU");
		courseOffer.setHours(2.0);
		courseOffer.setEcts(3.0);
		courseOffer.setName("Formale Modellierung");
		course = modelFactory.createCourse();
		course.setNumber("185.A06");
		course.setCourseOffer(courseOffer);
		courseOffer.addCourse(course);
		storage.saveCourse(course);
		storage.saveCourseOffer(courseOffer);
		module.addCourseOffer(courseOffer);

		courseOffer = modelFactory.createCourseOffer();
		courseOffer.setType("VU");
		courseOffer.setHours(2.0);
		courseOffer.setEcts(3.0);
		courseOffer.setName("Datenmodellierung");
		course = modelFactory.createCourse();
		course.setNumber("184.685");
		course.setCourseOffer(courseOffer);
		courseOffer.addCourse(course);
		storage.saveCourse(course);
		storage.saveCourseOffer(courseOffer);
		module.addCourseOffer(courseOffer);

		courseOffer = modelFactory.createCourseOffer();
		courseOffer.setType("VU");
		courseOffer.setHours(2.0);
		courseOffer.setEcts(3.0);
		courseOffer.setName("Objektorientierte Modellierung");
		course = modelFactory.createCourse();
		course.setNumber("188.391");
		course.setCourseOffer(courseOffer);
		courseOffer.addCourse(course);
		storage.saveCourse(course);
		storage.saveCourseOffer(courseOffer);
		module.addCourseOffer(courseOffer);

		storage.saveModule(module);
		examinationSubject.addModule(module);

		module = modelFactory.createModule();
		module.setName("Software Engineering und Projektmanagement");
		module.setType("Pflichtlehrveranstaltungen");

		courseOffer = modelFactory.createCourseOffer();
		courseOffer.setType("VO");
		courseOffer.setHours(2.0);
		courseOffer.setEcts(3.0);
		courseOffer.setName("Software Engineering und Projektmanagement");
		course = modelFactory.createCourse();
		course.setNumber("183.239");
		course.setCourseOffer(courseOffer);
		courseOffer.addCourse(course);
		storage.saveCourse(course);
		storage.saveCourseOffer(courseOffer);
		module.addCourseOffer(courseOffer);

		courseOffer = modelFactory.createCourseOffer();
		courseOffer.setType("PR");
		courseOffer.setHours(4.0);
		courseOffer.setEcts(6.0);
		courseOffer.setName("Software Engineering und Projektmanagement");
		course = modelFactory.createCourse();
		course.setNumber("183.241");
		course.setCourseOffer(courseOffer);
		courseOffer.addCourse(course);
		storage.saveCourse(course);
		storage.saveCourseOffer(courseOffer);
		module.addCourseOffer(courseOffer);

		storage.saveModule(module);
		examinationSubject.addModule(module);

		module = modelFactory.createModule();
		module.setName("Programm- und Systemverifikation");
		module.setType("Wahllehrveranstaltungen");

		courseOffer = modelFactory.createCourseOffer();
		courseOffer.setType("VU");
		courseOffer.setHours(4.5);
		courseOffer.setEcts(6.0);
		courseOffer.setName("Programm- und Systemverifikation");
		course = modelFactory.createCourse();
		course.setNumber("184.741");
		course.setCourseOffer(courseOffer);
		courseOffer.addCourse(course);
		storage.saveCourse(course);
		storage.saveCourseOffer(courseOffer);
		module.addCourseOffer(courseOffer);

		storage.saveModule(module);
		examinationSubject.addModule(module);

		module = modelFactory.createModule();
		module.setName("Softwareprojekt-Beobachtung und -Controlling");
		module.setType("Wahllehrveranstaltungen");

		storage.saveModule(module);
		examinationSubject.addModule(module);

		module = modelFactory.createModule();
		module.setName("Softwarequalitätssicherung");
		module.setType("Wahllehrveranstaltungen");

		courseOffer = modelFactory.createCourseOffer();
		courseOffer.setType("VU");
		courseOffer.setHours(4.0);
		courseOffer.setEcts(6.0);
		courseOffer.setName("Softwarequalitätssicherung");
		course = modelFactory.createCourse();
		course.setNumber("180.764");
		course.setCourseOffer(courseOffer);
		courseOffer.addCourse(course);
		storage.saveCourse(course);
		storage.saveCourseOffer(courseOffer);
		module.addCourseOffer(courseOffer);

		storage.saveModule(module);
		examinationSubject.addModule(module);

		module = modelFactory.createModule();
		module.setName("Usability Engineering and Mobile Interaction");
		module.setType("Wahllehrveranstaltungen");

		storage.saveModule(module);
		examinationSubject.addModule(module);

		storage.saveExaminationSubject(examinationSubject);
		study.addExaminationSubject(examinationSubject);

		examinationSubject = modelFactory.createExaminationSubject();
		examinationSubject.setName("Fachübergreifende Qualifikationen und freie Wahl");

		module = modelFactory.createModule();
		module.setName("Fachübergreifende Qualifikationen");
		module.setType("Pflichtlehrveranstaltungen");

		courseOffer = modelFactory.createCourseOffer();
		courseOffer.setType("VU");
		courseOffer.setHours(2.0);
		courseOffer.setEcts(3.0);
		courseOffer.setName("Softskills für TechnikerInnen");
		course = modelFactory.createCourse();
		course.setNumber("181.208");
		course.setCourseOffer(courseOffer);
		courseOffer.addCourse(course);
		storage.saveCourse(course);
		storage.saveCourseOffer(courseOffer);
		module.addCourseOffer(courseOffer);

		courseOffer = modelFactory.createCourseOffer();
		courseOffer.setType("VO");
		courseOffer.setHours(2.0);
		courseOffer.setEcts(3.0);
		courseOffer.setName("Sachverständigenrecht");
		course = modelFactory.createCourse();
		course.setNumber("265.727");
		course.setCourseOffer(courseOffer);
		courseOffer.addCourse(course);
		storage.saveCourse(course);
		storage.saveCourseOffer(courseOffer);
		module.addCourseOffer(courseOffer);

		courseOffer = modelFactory.createCourseOffer();
		courseOffer.setType("VO");
		courseOffer.setHours(2.0);
		courseOffer.setEcts(3.0);
		courseOffer.setName("Unternehmensgründung");
		course = modelFactory.createCourse();
		course.setNumber("015.664");
		course.setCourseOffer(courseOffer);
		courseOffer.addCourse(course);
		storage.saveCourse(course);
		storage.saveCourseOffer(courseOffer);
		module.addCourseOffer(courseOffer);

		storage.saveModule(module);
		examinationSubject.addModule(module);

		module = modelFactory.createModule();
		module.setName("Freie Wahl");
		module.setType("Pflichtlehrveranstaltungen");

		storage.saveModule(module);
		examinationSubject.addModule(module);

		storage.saveExaminationSubject(examinationSubject);
		study.addExaminationSubject(examinationSubject);

		examinationSubject = modelFactory.createExaminationSubject();
		examinationSubject.setName("Bachelorarbeit");

		module = modelFactory.createModule();
		module.setName("Bachelorarbeit");
		module.setType("Pflichtlehrveranstaltungen");

		courseOffer = modelFactory.createCourseOffer();
		courseOffer.setType("SE");
		courseOffer.setHours(2.0);
		courseOffer.setEcts(3.0);
		courseOffer.setName("Wissenschaftliches Arbeiten");
		course = modelFactory.createCourse();
		course.setNumber("188.925");
		course.setCourseOffer(courseOffer);
		courseOffer.addCourse(course);
		storage.saveCourse(course);
		storage.saveCourseOffer(courseOffer);
		module.addCourseOffer(courseOffer);

		storage.saveModule(module);
		examinationSubject.addModule(module);

		storage.saveExaminationSubject(examinationSubject);
		study.addExaminationSubject(examinationSubject);

		storage.saveStudy(study);
	}

	private static void createStudy2(Storage storage) {
		Study study = modelFactory.createStudy();
		study.setNumber("066 935");
		study.setType("Masterstudium");
		study.setName("Medieninformatik");
		study.setCertificateGerman("Universitätsgesetz 2002");
		study.setThesisNameGerman("Diplomarbeit");
		study.setThesisNameEnglish("Master Thesis");

		ExaminationSubject examinationSubject = modelFactory.createExaminationSubject();
		examinationSubject.setName("Theorien der Medieninformatik");

		Module module = modelFactory.createModule();
		module.setName("Designing Technosocial Systems");
		module.setType("Wahllehrveranstaltungen");

		storage.saveModule(module);
		examinationSubject.addModule(module);

		module = modelFactory.createModule();
		module.setName("Formal Methods in Computer Science");
		module.setType("Wahllehrveranstaltungen");

		storage.saveModule(module);
		examinationSubject.addModule(module);

		module = modelFactory.createModule();
		module.setName("Theorien der Medieninformatik");
		module.setType("Pflichtlehrveranstaltungen");

		CourseOffer courseOffer = modelFactory.createCourseOffer();
		courseOffer.setType("VU");
		courseOffer.setHours(2.0);
		courseOffer.setEcts(3.0);
		courseOffer.setName("Grundlagen der Kommunikations- und Medientheorie");
		Course course = modelFactory.createCourse();
		course.setNumber("187.333");
		course.setCourseOffer(courseOffer);
		courseOffer.addCourse(course);
		storage.saveCourse(course);
		storage.saveCourseOffer(courseOffer);
		module.addCourseOffer(courseOffer);

		storage.saveModule(module);
		examinationSubject.addModule(module);

		module = modelFactory.createModule();
		module.setName("Theorien der Wahrnehmung, Interaktion und Visualisierung");
		module.setType("Pflichtlehrveranstaltungen");

		courseOffer = modelFactory.createCourseOffer();
		courseOffer.setType("UE");
		courseOffer.setHours(2.0);
		courseOffer.setEcts(3.0);
		courseOffer.setName("Gestaltung und Evaluation von Visualisierungen");
		course = modelFactory.createCourse();
		course.setNumber("187.A46");
		course.setCourseOffer(courseOffer);
		courseOffer.addCourse(course);
		storage.saveCourse(course);
		storage.saveCourseOffer(courseOffer);
		module.addCourseOffer(courseOffer);

		courseOffer = modelFactory.createCourseOffer();
		courseOffer.setType("VO");
		courseOffer.setHours(2.0);
		courseOffer.setEcts(3.0);
		courseOffer.setName("Psychologische Grundlagen der Visualisierung");
		course = modelFactory.createCourse();
		course.setNumber("187.A44");
		course.setCourseOffer(courseOffer);
		courseOffer.addCourse(course);
		storage.saveCourse(course);
		storage.saveCourseOffer(courseOffer);
		module.addCourseOffer(courseOffer);

		storage.saveModule(module);
		examinationSubject.addModule(module);

		module = modelFactory.createModule();
		module.setName("User Research Methoden");
		module.setType("Wahllehrveranstaltungen");

		courseOffer = modelFactory.createCourseOffer();
		courseOffer.setType("VU");
		courseOffer.setHours(2.0);
		courseOffer.setEcts(3.0);
		courseOffer.setName("User Research Methoden");
		course = modelFactory.createCourse();
		course.setNumber("187.A68");
		course.setCourseOffer(courseOffer);
		courseOffer.addCourse(course);
		storage.saveCourse(course);
		storage.saveCourseOffer(courseOffer);
		module.addCourseOffer(courseOffer);

		courseOffer = modelFactory.createCourseOffer();
		courseOffer.setType("PR");
		courseOffer.setHours(2.0);
		courseOffer.setEcts(3.0);
		courseOffer.setName("User Research Methoden");
		course = modelFactory.createCourse();
		course.setNumber("187.A69");
		course.setCourseOffer(courseOffer);
		courseOffer.addCourse(course);
		storage.saveCourse(course);
		storage.saveCourseOffer(courseOffer);
		module.addCourseOffer(courseOffer);

		storage.saveModule(module);
		examinationSubject.addModule(module);

		storage.saveExaminationSubject(examinationSubject);
		study.addExaminationSubject(examinationSubject);

		examinationSubject = modelFactory.createExaminationSubject();
		examinationSubject.setName("Technologien und Anwendungen der Medieninformatik");

		module = modelFactory.createModule();
		module.setName("Beyond the Desktop");
		module.setType("Wahllehrveranstaltungen");

		courseOffer = modelFactory.createCourseOffer();
		courseOffer.setType("VU");
		courseOffer.setHours(4.0);
		courseOffer.setEcts(6.0);
		courseOffer.setName("Beyond the Desktop");
		course = modelFactory.createCourse();
		course.setNumber("187.A67");
		course.setCourseOffer(courseOffer);
		courseOffer.addCourse(course);
		storage.saveCourse(course);
		storage.saveCourseOffer(courseOffer);
		module.addCourseOffer(courseOffer);

		courseOffer = modelFactory.createCourseOffer();
		courseOffer.setType("PR");
		courseOffer.setHours(4.0);
		courseOffer.setEcts(6.0);
		courseOffer.setName("Building Interaction Interfaces");
		course = modelFactory.createCourse();
		course.setNumber("187.A25");
		course.setCourseOffer(courseOffer);
		courseOffer.addCourse(course);
		storage.saveCourse(course);
		storage.saveCourseOffer(courseOffer);
		module.addCourseOffer(courseOffer);

		courseOffer = modelFactory.createCourseOffer();
		courseOffer.setType("VU");
		courseOffer.setHours(2.0);
		courseOffer.setEcts(3.0);
		courseOffer.setName("Cognitive User Interfaces");
		course = modelFactory.createCourse();
		course.setNumber("185.A08");
		course.setCourseOffer(courseOffer);
		courseOffer.addCourse(course);
		storage.saveCourse(course);
		storage.saveCourseOffer(courseOffer);
		module.addCourseOffer(courseOffer);

		storage.saveModule(module);
		examinationSubject.addModule(module);

		module = modelFactory.createModule();
		module.setName("Virtual and Augmented Reality");
		module.setType("Wahllehrveranstaltungen");

		courseOffer = modelFactory.createCourseOffer();
		courseOffer.setType("PR");
		courseOffer.setHours(2.0);
		courseOffer.setEcts(3.0);
		courseOffer.setName("Virtual and Augmented Reality: Advanced Topics");
		course = modelFactory.createCourse();
		course.setNumber("188.456");
		course.setCourseOffer(courseOffer);
		courseOffer.addCourse(course);
		storage.saveCourse(course);
		storage.saveCourseOffer(courseOffer);
		module.addCourseOffer(courseOffer);

		storage.saveModule(module);
		examinationSubject.addModule(module);

		module = modelFactory.createModule();
		module.setName("Media Understanding");
		module.setType("Wahllehrveranstaltungen");

		storage.saveModule(module);
		examinationSubject.addModule(module);

		module = modelFactory.createModule();
		module.setName("Sound and Music Computing");
		module.setType("Wahllehrveranstaltungen");

		courseOffer = modelFactory.createCourseOffer();
		courseOffer.setType("VU");
		courseOffer.setHours(4.0);
		courseOffer.setEcts(6.0);
		courseOffer.setName("DSP-Processng & Generative Music");
		course = modelFactory.createCourse();
		course.setNumber("187.A63");
		course.setCourseOffer(courseOffer);
		courseOffer.addCourse(course);
		storage.saveCourse(course);
		storage.saveCourseOffer(courseOffer);
		module.addCourseOffer(courseOffer);

		storage.saveModule(module);
		examinationSubject.addModule(module);

		module = modelFactory.createModule();
		module.setName("Computer Vision");
		module.setType("Wahllehrveranstaltungen");

		courseOffer = modelFactory.createCourseOffer();
		courseOffer.setType("VU");
		courseOffer.setHours(3.0);
		courseOffer.setEcts(4.5);
		courseOffer.setName("Computer Vision");
		course = modelFactory.createCourse();
		course.setNumber("183.585");
		course.setCourseOffer(courseOffer);
		courseOffer.addCourse(course);
		storage.saveCourse(course);
		storage.saveCourseOffer(courseOffer);
		module.addCourseOffer(courseOffer);

		courseOffer = modelFactory.createCourseOffer();
		courseOffer.setType("VU");
		courseOffer.setHours(3.0);
		courseOffer.setEcts(4.5);
		courseOffer.setName("Mustererkennung");
		course = modelFactory.createCourse();
		course.setNumber("186.845");
		course.setCourseOffer(courseOffer);
		courseOffer.addCourse(course);
		storage.saveCourse(course);
		storage.saveCourseOffer(courseOffer);
		module.addCourseOffer(courseOffer);

		courseOffer = modelFactory.createCourseOffer();
		courseOffer.setType("SE");
		courseOffer.setHours(2.0);
		courseOffer.setEcts(3.0);
		courseOffer.setName("Seminar aus Computer Vision und Mustererkennung");
		course = modelFactory.createCourse();
		course.setNumber("188.941");
		course.setCourseOffer(courseOffer);
		courseOffer.addCourse(course);
		storage.saveCourse(course);
		storage.saveCourseOffer(courseOffer);
		module.addCourseOffer(courseOffer);

		storage.saveModule(module);
		examinationSubject.addModule(module);

		module = modelFactory.createModule();
		module.setName("Image and Video Analysis & Synthesis");
		module.setType("Wahllehrveranstaltungen");

		storage.saveModule(module);
		examinationSubject.addModule(module);

		module = modelFactory.createModule();
		module.setName("Angewandte Assistierende Technologien");
		module.setType("Wahllehrveranstaltungen");

		storage.saveModule(module);
		examinationSubject.addModule(module);

		module = modelFactory.createModule();
		module.setName("Digitale Kunst");
		module.setType("Wahllehrveranstaltungen");

		storage.saveModule(module);
		examinationSubject.addModule(module);

		module = modelFactory.createModule();
		module.setName("Digital Games");
		module.setType("Wahllehrveranstaltungen");

		courseOffer = modelFactory.createCourseOffer();
		courseOffer.setType("VU");
		courseOffer.setHours(2.0);
		courseOffer.setEcts(3.0);
		courseOffer.setName("Game Design");
		course = modelFactory.createCourse();
		course.setNumber("187.A90");
		course.setCourseOffer(courseOffer);
		courseOffer.addCourse(course);
		storage.saveCourse(course);
		storage.saveCourseOffer(courseOffer);
		module.addCourseOffer(courseOffer);

		courseOffer = modelFactory.createCourseOffer();
		courseOffer.setType("PR");
		courseOffer.setHours(6.0);
		courseOffer.setEcts(9.0);
		courseOffer.setName("Game Design");
		course = modelFactory.createCourse();
		course.setNumber("187.A93");
		course.setCourseOffer(courseOffer);
		courseOffer.addCourse(course);
		storage.saveCourse(course);
		storage.saveCourseOffer(courseOffer);
		module.addCourseOffer(courseOffer);

		courseOffer = modelFactory.createCourseOffer();
		courseOffer.setType("UE");
		courseOffer.setHours(2.0);
		courseOffer.setEcts(3.0);
		courseOffer.setName("Game Production");
		course = modelFactory.createCourse();
		course.setNumber("187.A91");
		course.setCourseOffer(courseOffer);
		courseOffer.addCourse(course);
		storage.saveCourse(course);
		storage.saveCourseOffer(courseOffer);
		module.addCourseOffer(courseOffer);

		storage.saveModule(module);
		examinationSubject.addModule(module);

		module = modelFactory.createModule();
		module.setName("HCI & Health Care");
		module.setType("Wahllehrveranstaltungen");

		storage.saveModule(module);
		examinationSubject.addModule(module);

		module = modelFactory.createModule();
		module.setName("Emergente Technologien und Methoden");
		module.setType("Wahllehrveranstaltungen");

		storage.saveModule(module);
		examinationSubject.addModule(module);

		storage.saveExaminationSubject(examinationSubject);
		study.addExaminationSubject(examinationSubject);

		examinationSubject = modelFactory.createExaminationSubject();
		examinationSubject.setName("Theorie und Praxis der Gestaltung interkativer Systeme");

		module = modelFactory.createModule();
		module.setName("Projektorientierte Recherche und designgenerierende Methoden");
		module.setType("Wahllehrveranstaltungen");

		storage.saveModule(module);
		examinationSubject.addModule(module);

		module = modelFactory.createModule();
		module.setName("Exploratives Design");
		module.setType("Wahllehrveranstaltungen");

		courseOffer = modelFactory.createCourseOffer();
		courseOffer.setType("PR");
		courseOffer.setHours(4.0);
		courseOffer.setEcts(6.0);
		courseOffer.setName("Exploratives Design 1");
		course = modelFactory.createCourse();
		course.setNumber("187.A48");
		course.setCourseOffer(courseOffer);
		courseOffer.addCourse(course);
		storage.saveCourse(course);
		storage.saveCourseOffer(courseOffer);
		module.addCourseOffer(courseOffer);

		courseOffer = modelFactory.createCourseOffer();
		courseOffer.setType("PR");
		courseOffer.setHours(4.0);
		courseOffer.setEcts(6.0);
		courseOffer.setName("Exploratives Design 2");
		course = modelFactory.createCourse();
		course.setNumber("187.A43");
		course.setCourseOffer(courseOffer);
		courseOffer.addCourse(course);
		storage.saveCourse(course);
		storage.saveCourseOffer(courseOffer);
		module.addCourseOffer(courseOffer);

		storage.saveModule(module);
		examinationSubject.addModule(module);

		module = modelFactory.createModule();
		module.setName("From Design to Software");
		module.setType("Wahllehrveranstaltungen");

		courseOffer = modelFactory.createCourseOffer();
		courseOffer.setType("PR");
		courseOffer.setHours(4.0);
		courseOffer.setEcts(6.0);
		courseOffer.setName("From Design to Software 1");
		course = modelFactory.createCourse();
		course.setNumber("188.934");
		course.setCourseOffer(courseOffer);
		courseOffer.addCourse(course);
		storage.saveCourse(course);
		storage.saveCourseOffer(courseOffer);
		module.addCourseOffer(courseOffer);

		courseOffer = modelFactory.createCourseOffer();
		courseOffer.setType("PR");
		courseOffer.setHours(4.0);
		courseOffer.setEcts(6.0);
		courseOffer.setName("From Design to Software 2");
		course = modelFactory.createCourse();
		course.setNumber("188.935");
		course.setCourseOffer(courseOffer);
		courseOffer.addCourse(course);
		storage.saveCourse(course);
		storage.saveCourseOffer(courseOffer);
		module.addCourseOffer(courseOffer);

		storage.saveModule(module);
		examinationSubject.addModule(module);

		storage.saveExaminationSubject(examinationSubject);
		study.addExaminationSubject(examinationSubject);

		examinationSubject = modelFactory.createExaminationSubject();
		examinationSubject.setName("Fachübergreifende Qualifikationen und freie Wahl");

		module = modelFactory.createModule();
		module.setName("Fachübergreifende Qualifikationen");
		module.setType("Wahllehrveranstaltungen");

		courseOffer = modelFactory.createCourseOffer();
		courseOffer.setType("UE");
		courseOffer.setHours(3.0);
		courseOffer.setEcts(6.0);
		courseOffer.setName("Computerunterstütztes Japanisch I");
		course = modelFactory.createCourse();
		course.setNumber("015.710");
		course.setCourseOffer(courseOffer);
		courseOffer.addCourse(course);
		storage.saveCourse(course);
		storage.saveCourseOffer(courseOffer);
		module.addCourseOffer(courseOffer);

		courseOffer = modelFactory.createCourseOffer();
		courseOffer.setType("VO");
		courseOffer.setHours(2.0);
		courseOffer.setEcts(6.0);
		courseOffer.setName("Computerunterstütztes Japanisch I");
		course = modelFactory.createCourse();
		course.setNumber("015.712");
		course.setCourseOffer(courseOffer);
		courseOffer.addCourse(course);
		storage.saveCourse(course);
		storage.saveCourseOffer(courseOffer);
		module.addCourseOffer(courseOffer);

		courseOffer = modelFactory.createCourseOffer();
		courseOffer.setType("UE");
		courseOffer.setHours(3.0);
		courseOffer.setEcts(3.0);
		courseOffer.setName("Computerunterstütztes Japanisch II");
		course = modelFactory.createCourse();
		course.setNumber("015.711");
		course.setCourseOffer(courseOffer);
		courseOffer.addCourse(course);
		storage.saveCourse(course);
		storage.saveCourseOffer(courseOffer);
		module.addCourseOffer(courseOffer);

		courseOffer = modelFactory.createCourseOffer();
		courseOffer.setType("VU");
		courseOffer.setHours(2.0);
		courseOffer.setEcts(3.0);
		courseOffer.setName("Technisches Spanisch I");
		course = modelFactory.createCourse();
		course.setNumber("015.035");
		course.setCourseOffer(courseOffer);
		courseOffer.addCourse(course);
		storage.saveCourse(course);
		storage.saveCourseOffer(courseOffer);
		module.addCourseOffer(courseOffer);

		courseOffer = modelFactory.createCourseOffer();
		courseOffer.setType("VO");
		courseOffer.setHours(2.0);
		courseOffer.setEcts(3.0);
		courseOffer.setName("Recht des geistigen Eigentums, Patentrecht, Urheberrecht, Marken- u. Designschutz");
		course = modelFactory.createCourse();
		course.setNumber("265.077");
		course.setCourseOffer(courseOffer);
		courseOffer.addCourse(course);
		storage.saveCourse(course);
		storage.saveCourseOffer(courseOffer);
		module.addCourseOffer(courseOffer);

		storage.saveModule(module);
		examinationSubject.addModule(module);

		module = modelFactory.createModule();
		module.setName("Freie Wahl");
		module.setType("Wahllehrveranstaltungen");

		courseOffer = modelFactory.createCourseOffer();
		courseOffer.setType("VO");
		courseOffer.setHours(1.0);
		courseOffer.setEcts(1.5);
		courseOffer.setName("Die Europäische Union: Institutionen und Politiken");
		course = modelFactory.createCourse();
		course.setNumber("164.245");
		course.setCourseOffer(courseOffer);
		courseOffer.addCourse(course);
		storage.saveCourse(course);
		storage.saveCourseOffer(courseOffer);
		module.addCourseOffer(courseOffer);

		storage.saveModule(module);
		examinationSubject.addModule(module);

		storage.saveExaminationSubject(examinationSubject);
		study.addExaminationSubject(examinationSubject);

		examinationSubject = modelFactory.createExaminationSubject();
		examinationSubject.setName("Innovation");

		module = modelFactory.createModule();
		module.setName("Innovation and Creativity");
		module.setType("Wahllehrveranstaltungen");

		storage.saveModule(module);
		examinationSubject.addModule(module);

		module = modelFactory.createModule();
		module.setName("Innovation Planning");
		module.setType("Wahllehrveranstaltungen");

		storage.saveModule(module);
		examinationSubject.addModule(module);

		module = modelFactory.createModule();
		module.setName("Innovation Implementation");
		module.setType("Wahllehrveranstaltungen");

		storage.saveModule(module);
		examinationSubject.addModule(module);

		module = modelFactory.createModule();
		module.setName("Innovation Practice");
		module.setType("Wahllehrveranstaltungen");

		storage.saveModule(module);
		examinationSubject.addModule(module);

		storage.saveExaminationSubject(examinationSubject);
		study.addExaminationSubject(examinationSubject);

		storage.saveStudy(study);
	}
	
	private static void createRooms(Storage storage) {
		
		room = modelFactory.createRoom();
		room.setName("Seminarraum irgendwas");
		
		storage.saveRoom(room);
	}

	private static void createEnrollment1(Storage storage) throws ParseException {

		Enrollment enrollment = modelFactory.createEnrollment();
		enrollment.setEnrolled(inputFormat.parse("01.10.2012 12:00"));
		enrollment.setStudent(storage.loadStudent("1212345"));
		enrollment.setStudy(storage.loadStudy("033 534"));

		Thesis thesis = modelFactory.createThesis();
		enrollment.setThesis(thesis);

		for (ExaminationSubject examinationSubject : enrollment.getStudy().getExaminationSubjects()) {
			Assignment assignment = modelFactory.createAssignment();
			assignment.setExaminationSubject(examinationSubject);
			for (Module module : examinationSubject.getModules()) {
				ModuleAssignment moduleAssignment = modelFactory.createModuleAssignment();
				moduleAssignment.setModule(module);
				assignment.addModuleAssignment(moduleAssignment);
				storage.saveModuleAssignment(moduleAssignment);
			}
			enrollment.addAssignment(assignment);
			storage.saveAssignment(assignment);
		}

		Exam exam = modelFactory.createExam();
		exam.setGrade(1);
		exam.setDate(inputFormat.parse("30.06.2013 12:00"));
		exam.setCourse(storage.loadCourse("186.813"));
		storage.saveExam(exam);
		enrollment.addExam(exam);

		exam = modelFactory.createExam();
		exam.setGrade(2);
		exam.setDate(inputFormat.parse("30.06.2013 12:00"));
		exam.setCourse(storage.loadCourse("186.815"));
		storage.saveExam(exam);
		enrollment.addExam(exam);

		exam = modelFactory.createExam();
		exam.setGrade(3);
		exam.setDate(inputFormat.parse("29.01.2014 12:00"));
		exam.setCourse(storage.loadCourse("185.A01"));
		storage.saveExam(exam);
		enrollment.addExam(exam);

		exam = modelFactory.createExam();
		exam.setGrade(4);
		exam.setDate(inputFormat.parse("15.01.2015 12:00"));
		exam.setCourse(storage.loadCourse("185.A03"));
		storage.saveExam(exam);
		enrollment.addExam(exam);

		exam = modelFactory.createExam();
		exam.setGrade(1);
		exam.setDate(inputFormat.parse("29.01.2013 12:00"));
		exam.setCourse(storage.loadCourse("185.A79"));
		storage.saveExam(exam);
		enrollment.addExam(exam);

		exam = modelFactory.createExam();
		exam.setGrade(2);
		exam.setDate(inputFormat.parse("25.09.2012 12:00"));
		exam.setCourse(storage.loadCourse("195.039"));
		storage.saveExam(exam);
		enrollment.addExam(exam);

		exam = modelFactory.createExam();
		exam.setGrade(3);
		exam.setDate(inputFormat.parse("09.02.2015 12:00"));
		exam.setCourse(storage.loadCourse("184.710"));
		storage.saveExam(exam);
		enrollment.addExam(exam);

		exam = modelFactory.createExam();
		exam.setGrade(4);
		exam.setDate(inputFormat.parse("30.10.2015 12:00"));
		exam.setCourse(storage.loadCourse("182.711"));
		storage.saveExam(exam);
		enrollment.addExam(exam);

		exam = modelFactory.createExam();
		exam.setGrade(1);
		exam.setDate(inputFormat.parse("03.02.2014 12:00"));
		exam.setCourse(storage.loadCourse("182.709"));
		storage.saveExam(exam);
		enrollment.addExam(exam);

		exam = modelFactory.createExam();
		exam.setGrade(2);
		exam.setDate(inputFormat.parse("04.10.2013 12:00"));
		exam.setCourse(storage.loadCourse("186.822"));
		storage.saveExam(exam);
		enrollment.addExam(exam);

		exam = modelFactory.createExam();
		exam.setGrade(3);
		exam.setDate(inputFormat.parse("13.02.2013 12:00"));
		exam.setCourse(storage.loadCourse("183.579"));
		storage.saveExam(exam);
		enrollment.addExam(exam);

		exam = modelFactory.createExam();
		exam.setGrade(4);
		exam.setDate(inputFormat.parse("12.10.2015 12:00"));
		exam.setCourse(storage.loadCourse("184.237"));
		storage.saveExam(exam);
		enrollment.addExam(exam);

		exam = modelFactory.createExam();
		exam.setGrade(1);
		exam.setDate(inputFormat.parse("21.01.2015 12:00"));
		exam.setCourse(storage.loadCourse("184.167"));
		storage.saveExam(exam);
		enrollment.addExam(exam);

		exam = modelFactory.createExam();
		exam.setGrade(2);
		exam.setDate(inputFormat.parse("31.07.2013 12:00"));
		exam.setCourse(storage.loadCourse("187.237"));
		storage.saveExam(exam);
		enrollment.addExam(exam);

		exam = modelFactory.createExam();
		exam.setGrade(3);
		exam.setDate(inputFormat.parse("31.07.2013 12:00"));
		exam.setCourse(storage.loadCourse("187.A21"));
		storage.saveExam(exam);
		enrollment.addExam(exam);

		exam = modelFactory.createExam();
		exam.setGrade(4);
		exam.setDate(inputFormat.parse("28.01.2016 12:00"));
		exam.setCourse(storage.loadCourse("187.272"));
		storage.saveExam(exam);
		enrollment.addExam(exam);

		exam = modelFactory.createExam();
		exam.setGrade(1);
		exam.setDate(inputFormat.parse("21.01.2015 12:00"));
		exam.setCourse(storage.loadCourse("183.289"));
		storage.saveExam(exam);
		enrollment.addExam(exam);

		exam = modelFactory.createExam();
		exam.setGrade(2);
		exam.setDate(inputFormat.parse("14.01.2014 12:00"));
		exam.setCourse(storage.loadCourse("188.916"));
		storage.saveExam(exam);
		enrollment.addExam(exam);

		exam = modelFactory.createExam();
		exam.setGrade(3);
		exam.setDate(inputFormat.parse("30.01.2014 12:00"));
		exam.setCourse(storage.loadCourse("265.068"));
		storage.saveExam(exam);
		enrollment.addExam(exam);

		exam = modelFactory.createExam();
		exam.setGrade(4);
		exam.setDate(inputFormat.parse("23.11.2015 12:00"));
		exam.setCourse(storage.loadCourse("188.366"));
		storage.saveExam(exam);
		enrollment.addExam(exam);

		exam = modelFactory.createExam();
		exam.setGrade(1);
		exam.setDate(inputFormat.parse("17.12.2015 12:00"));
		exam.setCourse(storage.loadCourse("183.637"));
		storage.saveExam(exam);
		enrollment.addExam(exam);

		exam = modelFactory.createExam();
		exam.setGrade(2);
		exam.setDate(inputFormat.parse("11.03.2014 12:00"));
		exam.setCourse(storage.loadCourse("184.686"));
		storage.saveExam(exam);
		enrollment.addExam(exam);

		exam = modelFactory.createExam();
		exam.setGrade(3);
		exam.setDate(inputFormat.parse("07.10.2014 12:00"));
		exam.setCourse(storage.loadCourse("184.735"));
		storage.saveExam(exam);
		enrollment.addExam(exam);

		exam = modelFactory.createExam();
		exam.setGrade(4);
		exam.setDate(inputFormat.parse("24.10.2014 12:00"));
		exam.setCourse(storage.loadCourse("184.705"));
		storage.saveExam(exam);
		enrollment.addExam(exam);

		exam = modelFactory.createExam();
		exam.setGrade(1);
		exam.setDate(inputFormat.parse("30.06.2015 12:00"));
		exam.setCourse(storage.loadCourse("188.951"));
		storage.saveExam(exam);
		enrollment.addExam(exam);

		exam = modelFactory.createExam();
		exam.setGrade(2);
		exam.setDate(inputFormat.parse("08.03.2013 12:00"));
		exam.setCourse(storage.loadCourse("104.265"));
		storage.saveExam(exam);
		enrollment.addExam(exam);

		exam = modelFactory.createExam();
		exam.setGrade(3);
		exam.setDate(inputFormat.parse("01.02.2013 12:00"));
		exam.setCourse(storage.loadCourse("104.263"));
		storage.saveExam(exam);
		enrollment.addExam(exam);

		exam = modelFactory.createExam();
		exam.setGrade(4);
		exam.setDate(inputFormat.parse("31.01.2014 12:00"));
		exam.setCourse(storage.loadCourse("104.262"));
		storage.saveExam(exam);
		enrollment.addExam(exam);

		exam = modelFactory.createExam();
		exam.setGrade(1);
		exam.setDate(inputFormat.parse("30.01.2014 12:00"));
		exam.setCourse(storage.loadCourse("107.370"));
		storage.saveExam(exam);
		enrollment.addExam(exam);

		exam = modelFactory.createExam();
		exam.setGrade(2);
		exam.setDate(inputFormat.parse("14.12.2015 12:00"));
		exam.setCourse(storage.loadCourse("185.278"));
		storage.saveExam(exam);
		enrollment.addExam(exam);

		exam = modelFactory.createExam();
		exam.setGrade(3);
		exam.setDate(inputFormat.parse("28.01.2013 12:00"));
		exam.setCourse(storage.loadCourse("185.A06"));
		storage.saveExam(exam);
		enrollment.addExam(exam);

		exam = modelFactory.createExam();
		exam.setGrade(4);
		exam.setDate(inputFormat.parse("25.01.2013 12:00"));
		exam.setCourse(storage.loadCourse("184.685"));
		storage.saveExam(exam);
		enrollment.addExam(exam);

		exam = modelFactory.createExam();
		exam.setGrade(1);
		exam.setDate(inputFormat.parse("27.06.2013 12:00"));
		exam.setCourse(storage.loadCourse("188.391"));
		storage.saveExam(exam);
		enrollment.addExam(exam);

		exam = modelFactory.createExam();
		exam.setGrade(2);
		exam.setDate(inputFormat.parse("27.06.2014 12:00"));
		exam.setCourse(storage.loadCourse("183.241"));
		storage.saveExam(exam);
		enrollment.addExam(exam);

		exam = modelFactory.createExam();
		exam.setGrade(3);
		exam.setDate(inputFormat.parse("17.06.2015 12:00"));
		exam.setCourse(storage.loadCourse("184.741"));
		storage.saveExam(exam);
		enrollment.addExam(exam);

		exam = modelFactory.createExam();
		exam.setGrade(4);
		exam.setDate(inputFormat.parse("30.06.2014 12:00"));
		exam.setCourse(storage.loadCourse("180.764"));
		storage.saveExam(exam);
		enrollment.addExam(exam);

		exam = modelFactory.createExam();
		exam.setGrade(1);
		exam.setDate(inputFormat.parse("01.12.2015 12:00"));
		exam.setCourse(storage.loadCourse("181.208"));
		storage.saveExam(exam);
		enrollment.addExam(exam);

		exam = modelFactory.createExam();
		exam.setGrade(2);
		exam.setDate(inputFormat.parse("16.11.2015 12:00"));
		exam.setCourse(storage.loadCourse("265.727"));
		storage.saveExam(exam);
		enrollment.addExam(exam);

		exam = modelFactory.createExam();
		exam.setGrade(3);
		exam.setDate(inputFormat.parse("08.09.2015 12:00"));
		exam.setCourse(storage.loadCourse("015.664"));
		storage.saveExam(exam);
		enrollment.addExam(exam);

		exam = modelFactory.createExam();
		exam.setGrade(4);
		exam.setDate(inputFormat.parse("31.01.2016 12:00"));
		exam.setCourse(storage.loadCourse("188.925"));
		storage.saveExam(exam);
		enrollment.addExam(exam);
		
		bachelor = enrollment;

		storage.saveEnrollment(enrollment);
	}

	private static void createEnrollment2(Storage storage) throws ParseException {

		Enrollment enrollment = modelFactory.createEnrollment();
		enrollment.setEnrolled(inputFormat.parse("01.10.2014 12:00"));
		enrollment.setStudent(storage.loadStudent("1112345"));
		enrollment.setStudy(storage.loadStudy("066 935"));

		Thesis thesis = modelFactory.createThesis();
		enrollment.setThesis(thesis);

		for (ExaminationSubject examinationSubject : enrollment.getStudy().getExaminationSubjects()) {
			Assignment assignment = modelFactory.createAssignment();
			assignment.setExaminationSubject(examinationSubject);
			for (Module module : examinationSubject.getModules()) {
				ModuleAssignment moduleAssignment = modelFactory.createModuleAssignment();
				moduleAssignment.setModule(module);
				assignment.addModuleAssignment(moduleAssignment);
				storage.saveModuleAssignment(moduleAssignment);
			}
			enrollment.addAssignment(assignment);
			storage.saveAssignment(assignment);
		}

		for (ExaminationSubject examinationSubject : enrollment.getStudy().getExaminationSubjects()) {
			for (Module module : examinationSubject.getModules()) {
				for (CourseOffer courseOffer : module.getCourseOffers()) {
					Course course = courseOffer.getCourses().get(0);
					Exam exam = modelFactory.createExam();
					exam.setGrade((int) (course.getCourseOffer().getId() % 5));
					exam.setDate(inputFormat.parse("01.01.2014 12:00"));
					exam.setCourse(course);
					storage.saveExam(exam);
					enrollment.addExam(exam);
				}
			}
		}
		
		GraduationDate graduationDate = modelFactory.createGraduationDate();
		graduationDate.setRegistrationFrom(inputFormat.parse("15.12.2015 12:00"));
		graduationDate.setRegistrationTo(inputFormat.parse("05.01.2016 12:00"));
		ExaminationDate examinationDate = modelFactory.createExaminationDate();
		examinationDate.setDate(inputFormat.parse("11.01.2016 12:00"));
		storage.saveExaminationDate(examinationDate);
		graduationDate.addDate(examinationDate);
		examinationDate = modelFactory.createExaminationDate();
		examinationDate.setDate(inputFormat.parse("12.01.2016 12:00"));
		storage.saveExaminationDate(examinationDate);
		graduationDate.addDate(examinationDate);
		examinationDate = modelFactory.createExaminationDate();
		examinationDate.setDate(inputFormat.parse("13.01.2016 12:00"));
		storage.saveExaminationDate(examinationDate);
		graduationDate.addDate(examinationDate);
		examinationDate = modelFactory.createExaminationDate();
		examinationDate.setDate(inputFormat.parse("14.01.2016 12:00"));
		storage.saveExaminationDate(examinationDate);
		graduationDate.addDate(examinationDate);
		Commission commission = modelFactory.createCommission();
		commission.setFrom(inputFormat.parse("13.01.2016 14:00"));
		commission.setTo(inputFormat.parse("13.01.2016 15:30"));
		commission.setRoom(room);
		commission.setChairman(chairman);
		commission.setExaminationDate(examinationDate);
		commission.setEnrollment(enrollment);
		examinationDate.addCommission(commission);
		enrollment.setCommission(commission);
		enrollment.setGraduationDate(graduationDate);
		graduationDate.addEnrollment(enrollment);
		
		storage.saveCommission(commission);
		storage.saveGraduationDate(graduationDate);
		storage.saveEnrollment(enrollment);
		
		graduationDate = modelFactory.createGraduationDate();
		examinationDate = modelFactory.createExaminationDate();
		examinationDate.setDate(inputFormat.parse("01.06.2015 12:00"));
		storage.saveExaminationDate(examinationDate);
		graduationDate.addDate(examinationDate);
		examinationDate = modelFactory.createExaminationDate();
		examinationDate.setDate(inputFormat.parse("02.06.2015 12:00"));
		storage.saveExaminationDate(examinationDate);
		graduationDate.addDate(examinationDate);
		examinationDate = modelFactory.createExaminationDate();
		examinationDate.setDate(inputFormat.parse("03.06.2015 12:00"));
		storage.saveExaminationDate(examinationDate);
		graduationDate.addDate(examinationDate);
		examinationDate = modelFactory.createExaminationDate();
		examinationDate.setDate(inputFormat.parse("04.06.2015 12:00"));
		storage.saveExaminationDate(examinationDate);
		graduationDate.addDate(examinationDate);
		
		storage.saveGraduationDate(graduationDate);
	}
	
	private static void createGraduationCeremony(Storage storage) throws ParseException {
		GraduationCeremony graduationCeremony = modelFactory.createGraduationCeremony();
		graduationCeremony.setDate(inputFormat.parse("10.12.1991 14:00"));
		graduationCeremony.setTime(inputFormat.parse("10.12.1991 14:00"));
		graduationCeremony.setDescription("Bachelorfeier");
		graduationCeremony.setRoom(room);
		graduationCeremony.addEnrollment(bachelor);
		bachelor.setGraduationCeremony(graduationCeremony);
		storage.saveGraduationCeremony(graduationCeremony);
	}
	
	private static void createDeanery(Storage storage) {
		Deanery deanery = modelFactory.createDeanery();
		deanery.setYear("2015/2016");
		deanery.setName("Informatik");
		deanery.setFaculty("Fakultät für Informatik");
		deanery.setFacultyEnglish("Faculty of Informatics");
		deanery.setContactData("Dekanat der Fakultät für Informatik, Erzherzog-Johann-Platz 1/180, 1040 Wien");
		deanery.seteMailAddress("dekanat@informatik.tuwien.ac.at");
		deanery.setExamDays(0);
		deanery.setPrincipal(principal);
		deanery.setVicePrincipal(vicePrincipal);
		deanery.setDean(dean);
		storage.saveDeanery(deanery);
	}
}
