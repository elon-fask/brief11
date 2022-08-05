
package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import domain.Employee;
import service.EmployeeService;

@RestController // class controller
public class EmployeeController  {

	@Autowired
	private EmployeeService employeeService; // get the bean which is auto-generated || we will use employeeService for each
	
	// display list of employees
	@GetMapping("/")
	// this method will be executed when user sends GET requests to "/"
	// "https://localhost:8080/"	
	public String viewHomePage(Model model) {

		// set all employees data as "listEmployees"
		model.addAttribute("listEmployees", employeeService.getAllEmpployees()); // we use this attribute "listEmployee" to perform server-side rendering of the HTML with using Thymeleaf.
		
		return "index"; // shows the index.html template
	}
	
	// show NewEmployeeForm
	@GetMapping("/showNewEmployeeForm")
	// this methode will be executed when user sends GET Reauests to "/NewEmloyeeForem"
	// "https://localhost:8080/NewEmployeeForm"
	public String showNewEmployeeForm(Model model) {
		Employee employee = new Employee();
		
		// we use this attribute "employee" to perform server-side rendering of the html with using Thymeleaf 
		model.addAttribute("employee", employee); // set employee object as "employee"
	
		return "new_employee"; // shows the addEmployee.html template
	}
	
	// add an employee
	@PostMapping("/")
	// this method will be executed when user sends POST Requests to "/saveEmployee" || "https://localhost:8080/saceEmployee" 
	public String saveEmployee(@ModelAttribute("employee") Employee employee) throws Exception {
		// @ModelAttribute binds the object called "employee" of request body from the POST request into the employee parameter of the saveEmployee() method.
		employeeService.saveEmployee(employee);
		
		return "redirect:/dashboard"; // after save the employee data to database, redirect to "/"
	}
	
	@GetMapping("/updateForm/{id}")
		// "https://localhost:8080/Update/{ employee's id}"
	public String updateForm(@PathVariable(value = "id") long id, Model model) throws Exception {
			// @PathVariable binds the {id} which the path of GET request contains into the id parameter of showUpdateForm() method
		Employee employee = employeeService.getEmployeeById(id);
		
		model.addAttribute("employee", employee); // set employee data as "employee"
		
		return "updateEmployee"; // shows the updateEmployee.html template
	}
	
	@GetMapping("/delete/{id}")
	// "https://localhost:8080/delete/{employee's id}"
	public String deleteEmployeeById(@PathVariable(value = "id") long id, Model model) throws Exception {
		employeeService.deleteEmployeeById(id);
		
		return "redirect:/"; // after deleting the employee data from the database, redirect to "/"
	}
	
}
