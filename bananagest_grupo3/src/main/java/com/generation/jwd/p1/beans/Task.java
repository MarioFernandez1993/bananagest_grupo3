package com.generation.jwd.p1.beans;

import java.io.Serializable;
import java.sql.Timestamp;

public class Task implements Serializable {
	

	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String description;
	private Timestamp date_start;
	private String state;
	private int hours;
	private int id_user;
	
	public Task() {};
	
	public Task(int id, String name, String description, Timestamp date_start,String state, int hours, 
				 int id_user) {
		
		this.id = id;
		this.name = name;
		this.description = description;
		this.date_start = date_start;
		this.state = state;
		this.hours = hours;
		this.id_user = id_user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Timestamp getDate_start() {
		return date_start;
	}

	public void setDate_start(Timestamp date_start) {
		this.date_start = date_start;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}
}

