package com.lovo.beans;

public class PTbean {
	
	private int id;
	
	private int userId;
	
	private int musicId;
	
	private String ptName;
	
	private String ptLink;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getMusicId() {
		return musicId;
	}

	public void setMusicId(int musicId) {
		this.musicId = musicId;
	}

	public String getPtName() {
		return ptName;
	}

	public void setPtName(String ptName) {
		this.ptName = ptName;
	}

	public String getPtLink() {
		return ptLink;
	}

	public void setPtLink(String ptLink) {
		this.ptLink = ptLink;
	}

	@Override
	public String toString() {
		return "PTbean [id=" + id + ", userId=" + userId + ", musicId="
				+ musicId + ", ptName=" + ptName + ", ptLink=" + ptLink + "]";
	}
	
	

}
