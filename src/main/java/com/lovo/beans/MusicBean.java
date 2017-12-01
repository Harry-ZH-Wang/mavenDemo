package com.lovo.beans;

import java.util.List;

public class MusicBean {
	
	/**
	 * 主键ID
	 */
	private int id;
	
	private int UserId;
	
	private String musicName;
	
	private String musicCount;
	
	private String ptName01;
	
	private String ptLink01;

	private String ptName02;
	
	private String ptLink02;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return UserId;
	}

	public void setUserId(int userId) {
		UserId = userId;
	}

	public String getMusicName() {
		return musicName;
	}

	public void setMusicName(String musicName) {
		this.musicName = musicName;
	}

	public String getMusicCount() {
		return musicCount;
	}

	public void setMusicCount(String musicCount) {
		this.musicCount = musicCount;
	}

	public String getPtName01() {
		return ptName01;
	}

	public void setPtName01(String ptName01) {
		this.ptName01 = ptName01;
	}

	public String getPtLink01() {
		return ptLink01;
	}

	public void setPtLink01(String ptLink01) {
		this.ptLink01 = ptLink01;
	}

	public String getPtName02() {
		return ptName02;
	}

	public void setPtName02(String ptName02) {
		this.ptName02 = ptName02;
	}

	public String getPtLink02() {
		return ptLink02;
	}

	public void setPtLink02(String ptLink02) {
		this.ptLink02 = ptLink02;
	}

	@Override
	public String toString() {
		return "MusicBean [id=" + id + ", UserId=" + UserId + ", musicName="
				+ musicName + ", musicCount=" + musicCount + ", ptName01="
				+ ptName01 + ", ptLink01=" + ptLink01 + ", ptName02="
				+ ptName02 + ", ptLink02=" + ptLink02 + "]";
	}
	
}
