package com.possoul.hibernateBasics.FetchingDB;
//this class is pojo

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Allien {
	@Id
	private int aid;  
	private String aname;
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	
	@Override
	public String toString() {
		return "Allien [aid=" + aid + ", aname=" + aname + ", colour=" +  "]";
	}
	
}
