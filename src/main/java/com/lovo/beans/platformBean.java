package com.lovo.beans;

import java.util.List;

public class platformBean {
	
	private String platName1;
	
	private String platLink1;
	
	private String platName2;
	
	private String platLink2;
	
	private String platName3;
	
	private String platLink3;
	
	private String platName4;
	
	private String platLink4;
	
	private List<tempPlat> listPlat;

	public platformBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public platformBean(String platName1, String platLink1, String platName2,
			String platLink2, String platName3, String platLink3,
			String platName4, String platLink4) {
		super();
		this.platName1 = platName1;
		this.platLink1 = platLink1;
		this.platName2 = platName2;
		this.platLink2 = platLink2;
		this.platName3 = platName3;
		this.platLink3 = platLink3;
		this.platName4 = platName4;
		this.platLink4 = platLink4;
	}

	public String getPlatName1() {
		return platName1;
	}

	public void setPlatName1(String platName1) {
		this.platName1 = platName1;
	}

	public String getPlatLink1() {
		return platLink1;
	}

	public void setPlatLink1(String platLink1) {
		this.platLink1 = platLink1;
	}

	public String getPlatName2() {
		return platName2;
	}

	public void setPlatName2(String platName2) {
		this.platName2 = platName2;
	}

	public String getPlatLink2() {
		return platLink2;
	}

	public void setPlatLink2(String platLink2) {
		this.platLink2 = platLink2;
	}

	public String getPlatName3() {
		return platName3;
	}

	public void setPlatName3(String platName3) {
		this.platName3 = platName3;
	}

	public String getPlatLink3() {
		return platLink3;
	}

	public void setPlatLink3(String platLink3) {
		this.platLink3 = platLink3;
	}

	public String getPlatName4() {
		return platName4;
	}

	public void setPlatName4(String platName4) {
		this.platName4 = platName4;
	}

	public String getPlatLink4() {
		return platLink4;
	}

	public void setPlatLink4(String platLink4) {
		this.platLink4 = platLink4;
	}

	public List<tempPlat> getListPlat() {
		return listPlat;
	}

	public void setListPlat(List<tempPlat> listPlat) {
		this.listPlat = listPlat;
	}

	@Override
	public String toString() {
		return "platformBean [platName1=" + platName1 + ", platLink1="
				+ platLink1 + ", platName2=" + platName2 + ", platLink2="
				+ platLink2 + ", platName3=" + platName3 + ", platLink3="
				+ platLink3 + ", platName4=" + platName4 + ", platLink4="
				+ platLink4 + ", listPlat=" + listPlat + "]";
	}
}
