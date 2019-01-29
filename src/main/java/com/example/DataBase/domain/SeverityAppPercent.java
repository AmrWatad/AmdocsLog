package com.example.DataBase.domain;

public class SeverityAppPercent {
	private String percentage;

	//----------------------------------------------getters and setters-------------------------------------------------------------------

	public String getPercentage() {
		return percentage;
	}


	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}
	
	//-----------------------------------------------------constructors------------------------------------------------------------------


	public SeverityAppPercent(String percentage) {
		super();
		this.percentage = percentage;
	}


	public SeverityAppPercent() {
		// TODO Auto-generated constructor stub
	}

}
