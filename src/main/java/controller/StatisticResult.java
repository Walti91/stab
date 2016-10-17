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

/**
 * This class is used by the StatisticController and used for the display of the
 * data via a data table.
 * 
 * @author Florian
 * @see StatisticController
 */
public class StatisticResult {

	private String description;
	private Integer counter;
	private Integer male;
	private Integer female;
	private Integer distinction;

	public StatisticResult(String description) {
		this.description = description;
		counter = 0;
		male = 0;
		female = 0;
		distinction = 0;
	}

	public String getDescription() {
		return description;
	}

	public void setCounter(Integer counter) {
		this.counter = counter;
	}

	public void setMale(Integer male) {
		this.male = male;
	}

	public void setFemale(Integer female) {
		this.female = female;
	}

	public void setDistinction(Integer distinction) {
		this.distinction = distinction;
	}

	public Integer getCounter() {
		return counter;
	}

	public void increaseCounter() {
		counter++;
	}

	public Integer getMale() {
		return male;
	}

	public void increaseMale() {
		male++;
	}

	public Integer getFemale() {
		return female;
	}

	public void increaseFemale() {
		female++;
	}

	public Integer getDistinction() {
		return distinction;
	}

	public void increaseDistinction() {
		distinction++;
	}

}
