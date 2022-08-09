package com.springboot.brief11.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.brief11.entity.Employee;
import com.springboot.brief11.repo.EmployeeRepo;

@Service // service class
public class EmployeeService {
	
	@Autowired // get the bean which is auto-generated by Spring
	
	EmployeeRepo employeeRepo; // we will use it to handle the data
	
	public List<Employee>getAllEmpployees(){
		return employeeRepo.findAll();
		// find all employees data, then return it
	}

	public void saveEmployee(Employee emp) {
		employeeRepo.save(emp);
		// save employee data to database
	}
	
	// get Employee by Id
	public Employee getEmployeeById(Long id) {
		Employee emp = employeeRepo.getById(id);
		
		if (emp == null) {
			throw new RuntimeException("EMployee not found !!");
		}
		
		return emp;
	}
	
	// delete employee by id
	public String deleteEmployeeById(Long id) {
		Employee emp = employeeRepo.getById(id);
		
		if (emp == null) {
			throw new RuntimeException("Employee not found !!");
		}
		employeeRepo.deleteById(id);
		
		return "Deleted: " +emp.getFirstName()+" "+ emp.getLastName()+ ", Id: "+emp.getId();
	}
	
	
	
}