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

public class Study {

	private String number;
	private String type;
	private String name;
	private String certificateGerman;
	private String certificateEnglish;
	private String optionalNotesGerman;
	private String optionalNotesEnglish;
	private String boardExaminationNameGerman;
	private String boardExaminationNameEnglish;
	private String thesisNameGerman;
	private String thesisNameEnglish;
	private String examinationSubjectThesisNameGerman;
	private String examinationSubjectThesisNameEnglish;
	private String examinationSubjectThesisNamePostfixGerman;
	private String examinationSubjectThesisNamePostfixEnglish;
	private Boolean ectsCertificate;
	private String noticeGerman;
	private String noticeEnglish;
	private List<ExaminationSubject> examinationSubjects;

	public Study() {
		examinationSubjects = new ArrayList<ExaminationSubject>();
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCertificateGerman() {
		return certificateGerman;
	}

	public void setCertificateGerman(String certificateGerman) {
		this.certificateGerman = certificateGerman;
	}

	public String getCertificateEnglish() {
		return certificateEnglish;
	}

	public void setCertificateEnglish(String certificateEnglish) {
		this.certificateEnglish = certificateEnglish;
	}

	public String getOptionalNotesGerman() {
		return optionalNotesGerman;
	}

	public void setOptionalNotesGerman(String optionalNotesGerman) {
		this.optionalNotesGerman = optionalNotesGerman;
	}

	public String getOptionalNotesEnglish() {
		return optionalNotesEnglish;
	}

	public void setOptionalNotesEnglish(String optionalNotesEnglish) {
		this.optionalNotesEnglish = optionalNotesEnglish;
	}

	public String getBoardExaminationNameGerman() {
		return boardExaminationNameGerman;
	}

	public void setBoardExaminationNameGerman(String boardExaminationNameGerman) {
		this.boardExaminationNameGerman = boardExaminationNameGerman;
	}

	public String getBoardExaminationNameEnglish() {
		return boardExaminationNameEnglish;
	}

	public void setBoardExaminationNameEnglish(String boardExaminationNameEnglish) {
		this.boardExaminationNameEnglish = boardExaminationNameEnglish;
	}

	public String getThesisNameGerman() {
		return thesisNameGerman;
	}

	public void setThesisNameGerman(String thesisNameGerman) {
		this.thesisNameGerman = thesisNameGerman;
	}

	public String getThesisNameEnglish() {
		return thesisNameEnglish;
	}

	public void setThesisNameEnglish(String thesisNameEnglish) {
		this.thesisNameEnglish = thesisNameEnglish;
	}

	public String getExaminationSubjectThesisNameGerman() {
		return examinationSubjectThesisNameGerman;
	}

	public void setExaminationSubjectThesisNameGerman(String examinationSubjectThesisNameGerman) {
		this.examinationSubjectThesisNameGerman = examinationSubjectThesisNameGerman;
	}

	public String getExaminationSubjectThesisNameEnglish() {
		return examinationSubjectThesisNameEnglish;
	}

	public void setExaminationSubjectThesisNameEnglish(String examinationSubjectThesisNameEnglish) {
		this.examinationSubjectThesisNameEnglish = examinationSubjectThesisNameEnglish;
	}

	public String getExaminationSubjectThesisNamePostfixGerman() {
		return examinationSubjectThesisNamePostfixGerman;
	}

	public void setExaminationSubjectThesisNamePostfixGerman(String examinationSubjectThesisNamePostfixGerman) {
		this.examinationSubjectThesisNamePostfixGerman = examinationSubjectThesisNamePostfixGerman;
	}

	public String getExaminationSubjectThesisNamePostfixEnglish() {
		return examinationSubjectThesisNamePostfixEnglish;
	}

	public void setExaminationSubjectThesisNamePostfixEnglish(String examinationSubjectThesisNamePostfixEnglish) {
		this.examinationSubjectThesisNamePostfixEnglish = examinationSubjectThesisNamePostfixEnglish;
	}

	public Boolean getEctsCertificate() {
		return ectsCertificate;
	}

	public void setEctsCertificate(Boolean ectsCertificate) {
		this.ectsCertificate = ectsCertificate;
	}

	public String getNoticeGerman() {
		return noticeGerman;
	}

	public void setNoticeGerman(String noticeGerman) {
		this.noticeGerman = noticeGerman;
	}

	public String getNoticeEnglish() {
		return noticeEnglish;
	}

	public void setNoticeEnglish(String noticeEnglish) {
		this.noticeEnglish = noticeEnglish;
	}

	public List<ExaminationSubject> getExaminationSubjects() {
		return examinationSubjects;
	}

	public void setExaminationSubjects(List<ExaminationSubject> examinationSubjects) {
		this.examinationSubjects = examinationSubjects;
	}

	public void addExaminationSubject(ExaminationSubject examinationSubject) {
		examinationSubjects.add(examinationSubject);
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder(number);
		sb.append(" ").append(name);
		return sb.toString();
	}
}
