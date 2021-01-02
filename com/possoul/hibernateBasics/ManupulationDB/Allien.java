package com.possoul.hibernateBasics.ManupulationDB;
//this class is pojo

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="hib_table")
public class Allien {
	@Id
	private int aid;  
	private AllienName aname;
	private String colour;
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	
	public AllienName getAname() {
		return aname;
	}
	public void setAname(AllienName aname) {
		this.aname = aname;
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	@Override
	public String toString() {
		return "Allien [aid=" + aid + ", aname=" + aname + ", colour=" + colour + "]";
	}
	
}
