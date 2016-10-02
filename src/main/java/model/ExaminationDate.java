package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExaminationDate {

	private Long id;
	private Date date;
	private List<Commission> commissions;
	
	public ExaminationDate() {
		commissions = new ArrayList<Commission>();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<Commission> getCommissions() {
		return commissions;
	}

	public void setCommissions(List<Commission> commissions) {
		this.commissions = commissions;
	}
	
	public void addCommission(Commission commission) {
		commissions.add(commission);
	}

	public void removeCommission(Commission commission) {
		commissions.remove(commission);
	}
}
