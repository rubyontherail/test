package org.hibernate.ch01;

public class History {
	private Integer eventCode ;
	private String  athlete   ;
	private Integer hostYear  ;
	private String  score     ;
	private String  unit      ;
	
	
	public Integer getEventCode() {
		return eventCode;
	}
	public void setEventCode(Integer eventCode) {
		this.eventCode = eventCode;
	}
	public String getAthlete() {
		return athlete;
	}
	public void setAthlete(String athlete) {
		this.athlete = athlete;
	}
	public Integer getHostYear() {
		return hostYear;
	}
	public void setHostYear(Integer hostYear) {
		this.hostYear = hostYear;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	
}
