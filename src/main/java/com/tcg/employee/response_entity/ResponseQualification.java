package com.tcg.employee.response_entity;

public class ResponseQualification {
	private long qualificationId;

	private String qualificationName;

	private String universityName;

	private String city;

	public ResponseQualification() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ResponseQualification(long qualificationId, String qualificationName, String universityName, String city) {
		super();
		this.qualificationId = qualificationId;
		this.qualificationName = qualificationName;
		this.universityName = universityName;
		this.city = city;
	}

	public long getQualificationId() {
		return qualificationId;
	}

	public void setQualificationId(long qualificationId) {
		this.qualificationId = qualificationId;
	}

	public String getQualificationName() {
		return qualificationName;
	}

	public void setQualificationName(String qualificationName) {
		this.qualificationName = qualificationName;
	}

	public String getUniversityName() {
		return universityName;
	}

	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
