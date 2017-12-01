package com.lovo.beans;

import java.util.List;

public class UserInfo {

	private int id;
	
	private String userName;
	
	private List<MusicBean> music;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<MusicBean> getMusic() {
		return music;
	}

	public void setMusic(List<MusicBean> music) {
		this.music = music;
	}

	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", userName=" + userName + ", music="
				+ music + "]";
	}
	
	
}
