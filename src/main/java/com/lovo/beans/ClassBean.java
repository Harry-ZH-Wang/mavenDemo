package com.lovo.beans;
/*
 * 
 * 测试-2
 */
public class ClassBean {

	private Long id;
	
	private String className;

	
	
	
	public ClassBean(Long id, String className) {
		super();
		this.id = id;
		this.className = className;
	}

	public ClassBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	@Override
	public String toString() {
		return "ClassBean [id=" + id + ", className=" + className + "]";
	}
	
	
}
