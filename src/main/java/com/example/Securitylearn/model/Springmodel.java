package com.example.Securitylearn.model;

import org.springframework.web.bind.annotation.RestController;


public class Springmodel {

	private int rno;
	private String name;
	private String technology;

	public int getRno() {
		return rno;
	}

	public void setRno(int rno) {
		this.rno = rno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTrchnology() {
		return technology;
	}

	public void setTrchnology(String technology) {
		this.technology = technology;
	}

	public Springmodel(int rno, String name, String technology) {
		super();
		this.rno = rno;
		this.name = name;
		this.technology = technology;
	}

	public Springmodel() {
		super();
	}

}
