package com.project.db.model;

public class Location {
	private int id;
	private String picklocation;
	private String droplocation;
	private String date;
	private String time;
	private int custid;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPicklocation() {
		return picklocation;
	}
	public void setPicklocation(String picklocation) {
		this.picklocation = picklocation;
	}
	public String getDroplocation() {
		return droplocation;
	}
	public void setDroplocation(String droplocation) {
		this.droplocation = droplocation;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	public int getCustid() {
		return custid;
	}
	public void setCustid(int custid) {
		this.custid = custid;
	}
	@Override
	public String toString() {
		String result = "\nId : " +this.getId()
        + "\nPicklocation : " +this.getPicklocation()
        + "\nDroplocation : " +this.getDroplocation()
        + "\nDate : " +this.getDate()
        + "\nTime : " +this.getTime()
        + "\n";
		
		return result;
	}
	
	
}
