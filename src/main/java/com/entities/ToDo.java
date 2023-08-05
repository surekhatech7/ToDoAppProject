package com.entities;

import java.util.Date;
import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Todo_info")
public class ToDo {

	@Id
	private int id;
	private String task;
	private String detail;
	private Date tdate;
	
	public ToDo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ToDo(String task, String detail, Date tdate) {
		super();
		this.id = new Random().nextInt(1000);
		this.task = task;
		this.detail = detail;
		this.tdate = tdate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public Date getTdate() {
		return tdate;
	}

	public void setTdate(Date tdate) {
		this.tdate = tdate;
	}

	@Override
	public String toString() {
		return "ToDo [id=" + id + ", task=" + task + ", detail=" + detail + ", tdate=" + tdate + "]";
	}
}
