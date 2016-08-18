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

public class Institute {

	private Long id;
	private String name;
	private List<Professor> advisers;
	private List<Professor> assistants;

	public Institute() {
		advisers = new ArrayList<Professor>();
		assistants = new ArrayList<Professor>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Professor> getAdvisers() {
		return advisers;
	}

	public void setAdvisers(List<Professor> advisers) {
		this.advisers = advisers;
	}

	public void addAdviser(Professor adviser) {
		advisers.add(adviser);
	}

	public List<Professor> getAssistants() {
		return assistants;
	}

	public void setAssistants(List<Professor> assistants) {
		this.assistants = assistants;
	}

	public void addAssistant(Professor assistant) {
		assistants.add(assistant);
	}
	
	public String toString() {
		return name;
	}
}
