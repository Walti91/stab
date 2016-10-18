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

package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;

import model.Assignment;
import model.Enrollment;
import model.Exam;
import model.GraduationCeremony;
import model.GraduationDate;
import model.ModuleAssignment;

@SessionScoped
@ManagedBean(name = "statistic")
public class StatisticController implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<StatisticResult> statistic;

	/**
	 * Calculates the number of bachelors and masters for the given enrollments.
	 * Also counts how many are male or female and finished with "Auszeichnung".
	 * 
	 * @param enrollments
	 * @return A list containing three objects of type StatisticResult. One for
	 *         the bachelors, one for the masters and a sum.
	 * @see StatisticResult
	 */
	public List<StatisticResult> createStatistic(List<Enrollment> enrollments) {
		StatisticResult bachelors = new StatisticResult(
				ResourceBundle.getBundle("messages").getString("labelBachelors"));
		StatisticResult masters = new StatisticResult(ResourceBundle.getBundle("messages").getString("labelMasters"));
		StatisticResult sum = new StatisticResult(ResourceBundle.getBundle("messages").getString("labelSum"));

		for (Enrollment enrollment : enrollments) {
			if (enrollment.getStudy().getType().equals("Masterstudium")) {
				masters.increaseCounter();
				if (enrollment.getStudent().getGender().equals("männlich")) {
					masters.increaseMale();
				} else {
					masters.increaseFemale();
				}
				if (enrollment.getAssignments() != null && !enrollment.getAssignments().isEmpty()) {
					Double counter = 0.0;
					for (Assignment assignment : enrollment.getAssignments()) {
						for (ModuleAssignment moduleAssignment : assignment.getModuleAssignments()) {
							for (Exam exam : moduleAssignment.getExams()) {
								counter += exam.getGrade() * exam.getCourse().getCourseOffer().getEcts();
							}
						}
					}
					if (counter / 120 < 1.5) {
						masters.increaseDistinction();
					}
				}
			} else {
				bachelors.increaseCounter();
				if (enrollment.getStudent().getGender().equals("männlich")) {
					bachelors.increaseMale();
				} else {
					bachelors.increaseFemale();
				}
				if (enrollment.getAssignments() != null && !enrollment.getAssignments().isEmpty()) {
					Double counter = 0.0;
					for (Assignment assignment : enrollment.getAssignments()) {
						for (ModuleAssignment moduleAssignment : assignment.getModuleAssignments()) {
							for (Exam exam : moduleAssignment.getExams()) {
								counter += exam.getGrade() * exam.getCourse().getCourseOffer().getEcts();
							}
						}
					}
					if (counter / 180 < 1.5) {
						bachelors.increaseDistinction();
					}
				}
			}
		}
		sum.setCounter(bachelors.getCounter() + masters.getCounter());
		sum.setMale(bachelors.getMale() + masters.getMale());
		sum.setFemale(bachelors.getFemale() + masters.getFemale());
		sum.setDistinction(bachelors.getDistinction() + masters.getDistinction());

		statistic = new ArrayList<StatisticResult>();
		statistic.add(bachelors);
		statistic.add(masters);
		statistic.add(sum);

		return statistic;
	}

	/**
	 * Reads the graduation date from the session and calls the createStatistic
	 * method with the enrollments of the date.
	 * 
	 * @return
	 */
	public List<StatisticResult> handleGraduationDate() {
		GraduationDate graduationDate = (GraduationDate) FacesContext.getCurrentInstance().getExternalContext()
				.getSessionMap().get("graduationDate");
		return createStatistic(graduationDate.getEnrollments());
	}

	/**
	 * Reads the graduation ceremony from the session and calls the
	 * createStatistic method with the enrollments of the ceremony.
	 * 
	 * @return
	 */
	public List<StatisticResult> handleGraduationCeremony() {
		GraduationCeremony graduationCeremony = (GraduationCeremony) FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap().get("graduationCeremony");
		return createStatistic(graduationCeremony.getEnrollments());
	}

	/**
	 * Creates a bar chart using the created statistic. Shows the male and
	 * female participants.
	 * 
	 * @return
	 */
	public BarChartModel createBarModel() {
		BarChartModel barModel = new BarChartModel();

		ChartSeries male = new ChartSeries();
		male.setLabel(ResourceBundle.getBundle("messages").getString("labelMale"));
		ChartSeries female = new ChartSeries();
		female.setLabel(ResourceBundle.getBundle("messages").getString("labelFemale"));

		for (StatisticResult entry : statistic) {
			male.set(entry.getDescription(), entry.getMale());
			female.set(entry.getDescription(), entry.getFemale());
		}

		barModel.addSeries(male);
		barModel.addSeries(female);

		barModel.setLegendPosition("nw");
		barModel.setStacked(true);

		Axis xAxis = barModel.getAxis(AxisType.X);
		xAxis.setLabel(ResourceBundle.getBundle("messages").getString("labelParticipants"));

		return barModel;
	}
}
