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

public class ModuleAssignment {

	private Long id;
	private Module module;
	private List<Exam> exams;

	public ModuleAssignment() {
		exams = new ArrayList<Exam>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
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
	
	public void removeExam(Exam exam) {
		exams.remove(exam);
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder(module.getName());
		sb.append(" (").append(module.getType()).append(")");
		return sb.toString();
	}
}
