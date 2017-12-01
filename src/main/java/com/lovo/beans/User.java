package com.lovo.beans;

public class User {
	
	private String userName;
	private String password;
	private String name;
	private String sex;
	private String file;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public User(String userName, String password, String name, String sex,
			String file) {
		super();
		this.userName = userName;
		this.password = password;
		this.name = name;
		this.sex = sex;
		this.file = file;
	}


	public String getFile() {
		return file;
	}


	public void setFile(String file) {
		this.file = file;
	}


	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	@Override
	public String toString() {
		return "User [userName=" + userName + ", password=" + password
				+ ", name=" + name + ", sex=" + sex + ", file=" + file + "]";
	}
	
}
