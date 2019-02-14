package com.example.DataBase.domain;

public class SeverityAppPercent {
	private String percentage;
	private String severity;


	//----------------------------------------------getters and setters-------------------------------------------------------------------

	public String getSeverity() {
		return severity;
	}


	public void setSeverity(String severity) {
		this.severity = severity;
	}


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
	public SeverityAppPercent(String percentage,String severity) {
		//super();
		this.percentage = percentage;
		this.severity=severity;
	}

	public SeverityAppPercent() {
		// TODO Auto-generated constructor stub
	}

}
