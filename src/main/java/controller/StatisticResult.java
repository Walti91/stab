package controller;

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
