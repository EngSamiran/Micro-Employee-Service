package com.tcg.employee.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcg.employee.entity.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {

}
