package com.lovo.beans;

public class tempPlat {
	
	private String platName;
	
	private String platLink;

	public String getPlatName() {
		return platName;
	}

	public void setPlatName(String platName) {
		this.platName = platName;
	}

	public String getPlatLink() {
		return platLink;
	}

	public void setPlatLink(String platLink) {
		this.platLink = platLink;
	}

	@Override
	public String toString() {
		return "tempPlat [platName=" + platName + ", platLink=" + platLink
				+ "]";
	}

}
