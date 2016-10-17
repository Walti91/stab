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

package controller.organization;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import data.Provider;
import model.Study;

@ManagedBean
@ViewScoped
public class StudyPlanController implements Serializable {

	@ManagedProperty(value = "#{provider}")
	private Provider provider;
	
	private static final long serialVersionUID = 1L;
	private List<Study> studyPlans;
	private String selection;
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

	@PostConstruct
	public void init() {
		studyPlans = provider.loadAllStudies();
		if (!studyPlans.isEmpty()) {
			selection = studyPlans.get(0).getNumber();
			update();
		}
	}

	public void update() {
		if (selection != null) {
			Study study = provider.loadStudy(selection);
			certificateGerman = study.getCertificateGerman();
			certificateEnglish = study.getCertificateEnglish();
			optionalNotesGerman = study.getOptionalNotesGerman();
			optionalNotesEnglish = study.getOptionalNotesEnglish();
			boardExaminationNameGerman = study.getBoardExaminationNameGerman();
			boardExaminationNameEnglish = study.getBoardExaminationNameEnglish();
			thesisNameGerman = study.getThesisNameGerman();
			thesisNameEnglish = study.getThesisNameEnglish();
			examinationSubjectThesisNameGerman = study.getExaminationSubjectThesisNameGerman();
			examinationSubjectThesisNameEnglish = study.getExaminationSubjectThesisNameEnglish();
			examinationSubjectThesisNamePostfixGerman = study.getExaminationSubjectThesisNamePostfixGerman();
			examinationSubjectThesisNamePostfixEnglish = study.getExaminationSubjectThesisNamePostfixEnglish();
			ectsCertificate = study.getEctsCertificate();
			noticeGerman = study.getNoticeGerman();
			noticeEnglish = study.getNoticeEnglish();
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Bitte wählen Sie einen Studienplan aus!", "Bitte wählen Sie einen Studienplan aus!"));
		}
	}

	public String save() {
		if (selection != null) {
			Study study = provider.loadStudy(selection);
			study.setCertificateGerman(certificateGerman);
			study.setCertificateEnglish(certificateEnglish);
			study.setOptionalNotesGerman(optionalNotesGerman);
			study.setOptionalNotesEnglish(optionalNotesEnglish);
			study.setBoardExaminationNameGerman(boardExaminationNameGerman);
			study.setBoardExaminationNameEnglish(boardExaminationNameEnglish);
			study.setThesisNameGerman(thesisNameGerman);
			study.setThesisNameEnglish(thesisNameEnglish);
			study.setExaminationSubjectThesisNameGerman(examinationSubjectThesisNameGerman);
			study.setExaminationSubjectThesisNameEnglish(examinationSubjectThesisNameEnglish);
			study.setExaminationSubjectThesisNamePostfixGerman(examinationSubjectThesisNamePostfixGerman);
			study.setExaminationSubjectThesisNamePostfixEnglish(examinationSubjectThesisNamePostfixEnglish);
			study.setEctsCertificate(ectsCertificate);
			study.setNoticeGerman(noticeGerman);
			study.setNoticeEnglish(noticeEnglish);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Studienplan erfolgreich gespeichert!", "Studienplan erfolgreich gespeichert!"));
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Studienplan konnte nicht gespeichert werden!", "Studienplan konnte nicht gespeichert werden!"));
		}
		return null;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	public String getSelection() {
		return selection;
	}

	public void setSelection(String selection) {
		this.selection = selection;
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

	public List<Study> getStudyPlans() {
		return studyPlans;
	}
}
