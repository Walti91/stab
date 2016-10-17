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

import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import data.Provider;
import model.Assignment;
import model.Exam;
import model.ModuleAssignment;

@ManagedBean
public class ValidationController {

	@ManagedProperty(value = "#{provider}")
	private Provider provider;
	
	public String validateAssignment(Long id) {
		Assignment assignment = provider.loadAssignment(id);
		StringBuilder sb = new StringBuilder();
		if(assignment.getConfirmed()) {
			Double ects = 0.0;
			Double grade = 0.0;
			for(ModuleAssignment moduleAssignment : assignment.getModuleAssignments()) {
				for(Exam exam : moduleAssignment.getExams()) {
					grade += exam.getGrade() * exam.getCourse().getCourseOffer().getEcts();
					ects += exam.getCourse().getCourseOffer().getEcts();
				}
			}
			if(ects.equals(0.0)) {
				sb.append("keine Zuordnungen\t0.0 EC");
			} else {
				sb.append("Zuordnungen vollst‰ndig,\tÿ-Note ");
				sb.append(new BigDecimal(grade / ects).setScale(2, RoundingMode.HALF_UP));
				sb.append("\t").append(assignment.getAssigned());
				sb.append(" EC");
			}
		} else {
			sb.append("Zuordnungen unvollst‰ndig");
		}
		
		return sb.toString();
	}
	
	public Boolean hasCommission(Long id) {
		return provider.loadEnrollment(id).getStudy().getType().equals("Masterstudium");
	}
	
	public void setProvider(Provider provider) {
		this.provider = provider;
	}
}
