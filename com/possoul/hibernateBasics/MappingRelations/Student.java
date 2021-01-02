package com.possoul.hibernateBasics.MappingRelations;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;


@Entity
public class Student {
	@Id
	private int rollNo;
	private String sname;
	private int marks;
	//@OneToOne             //1 student uses 1 laptop
	@OneToMany(mappedBy = "student")                      //1 student uses multiple laptops   //no need to create extra table
	private List<Laptop> laptop = new ArrayList<Laptop>();
	
	
	
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	
	
	public List<Laptop> getLaptop() {
		return laptop;
	}
	public void setLaptop(List<Laptop> laptop) {
		this.laptop = laptop;
	}

	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", sname=" + sname + ", marks=" + marks + "]";
	}
	
	
}
