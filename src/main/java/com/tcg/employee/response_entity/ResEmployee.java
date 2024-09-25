package com.tcg.employee.response_entity;

public class ResEmployee {
	private long empId;
	private String empName;
	private ResponseAddress address;
	private ResponseQualification qualification;

	public ResEmployee() {

	}

	public ResEmployee(long empId, String empName, ResponseAddress address, ResponseQualification qualification) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.address = address;
		this.qualification = qualification;
	}

	public long getEmpId() {
		return empId;
	}

	public void setEmpId(long empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public ResponseAddress getAddress() {
		return address;
	}

	public void setAddress(ResponseAddress address) {
		this.address = address;
	}

	public ResponseQualification getQualification() {
		return qualification;
	}

	public void setQualification(ResponseQualification qualification) {
		this.qualification = qualification;
	}

}
