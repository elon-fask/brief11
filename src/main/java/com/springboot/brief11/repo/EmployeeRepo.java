package com.springboot.brief11.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.brief11.entity.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {
		
		//This will be AUTO IMPLEMENTED by Spring into a Bean

}
