package com.lovo.beans;

public class Student {

	private int id;
	private String studentName;
	private int studentClass;
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(int id, String studentName, int studentClass) {
		super();
		this.id = id;
		this.studentName = studentName;
		this.studentClass = studentClass;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public int getStudentClass() {
		return studentClass;
	}
	public void setStudentClass(int studentClass) {
		this.studentClass = studentClass;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", studentName=" + studentName
				+ ", studentClass=" + studentClass + "]";
	}
	
	
	
}
