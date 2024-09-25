package com.tcg.employee.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name = "Employee")
@Entity(name = "Employee")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EmployeeIdGenerator")
	@SequenceGenerator(name = "EmployeeIdGenerator", initialValue = 100, allocationSize = 1, sequenceName = "EmployeeId_seq")
	@Column(name = "empId", nullable = false)
	private long empId;

	@Column(name="empName", length=200, nullable=false)
	private String empName;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
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
	
	
	
	
}
