package com.ushrd;

import java.sql.Timestamp;

public class MemberDTO {
	private String id;
	private String pw;
	private String name;
	private Timestamp rDate;
	private String address;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getrDate() {
		return rDate.toString();
	}
	public void setrDate(Timestamp rDate) {
		this.rDate = rDate;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public MemberDTO(String id, String pw, String name, Timestamp rDate, String address) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.rDate = rDate;
		this.address = address;
	}
	
	
	
}
