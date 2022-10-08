package com.project.db.model;

public class Customer {
	private int id;
	private String fname;
	private String lname;
	private int phoneno;
	private String location;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public int getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(int phoneno) {
		this.phoneno = phoneno;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		String result = "\nId : " +this.getId()
		                + "\nFName : " +this.getFname()
		                + "\nLName : " +this.getLname()
		                + "\nPhoneno : " +this.getPhoneno()
		                + "\nLocation : " +this.getLocation()
		                + "\n";
		return result;
	}
}
