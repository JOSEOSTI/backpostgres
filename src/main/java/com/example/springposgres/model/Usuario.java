package com.example.springposgres.model;



public class Usuario {


	private String firstname;
    private String lastname ;
    private String username;
    private String idnumber;
    private String itemname;
    private String rawgrade;
    private String itemid;
    private String timecreated;
    private String timemodified;

	
	public String getTimecreated() {
		return timecreated;
	}
	public void setTimecreated(String timecreated) {
		this.timecreated = timecreated;
	}
	public String getTimemodified() {
		return timemodified;
	}
	public void setTimemodified(String timemodified) {
		this.timemodified = timemodified;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getIdnumber() {
		return idnumber;
	}
	public void setIdnumber(String idnumber) {
		this.idnumber = idnumber;
	}
	public String getItemname() {
		return itemname;
	}
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	public String getRawgrade() {
		return rawgrade;
	}
	public void setRawgrade(String rawgrade) {
		this.rawgrade = rawgrade;
	}
	public String getItemid() {
		return itemid;
	}
	public void setItemid(String itemid) {
		this.itemid = itemid;
	}
	
	
	
}
