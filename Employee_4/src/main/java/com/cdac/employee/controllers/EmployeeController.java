package com.cdac.employee.controllers;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.cdac.employee.bean.Employee;
import com.cdac.employee.service.IEmployeeService;


@Controller
public class EmployeeController {
//private static String UPLOAD_DIRECTORY = "/home/sonali/images";
@Autowired
 private IEmployeeService employeeService;
@Autowired
public void setEmployeeService(IEmployeeService employeeService) {
	this.employeeService = employeeService;
}

	@RequestMapping("employeeForm")
	public String showForm(Model m) {
		m.addAttribute("employee",new Employee());
		return "employeeForm";
	}
	@RequestMapping(value="/save",method = RequestMethod.POST)    
	public String save(@ModelAttribute("employee") Employee employee){
	
			employeeService.save(employee); 
			
			return "redirect:/viewemp";
		}
	
	  
	
	@RequestMapping("/viewemp")    
	public String viewEmp(Model m){
		List<Employee> list=employeeService.getEmployees();
		m.addAttribute("list",list);  
		return "viewemp";    
	}
	
	@RequestMapping(value="/deletemp/{id}",method = RequestMethod.GET)    
	public String delete(@PathVariable int id){    
		employeeService.delete(id);    
		return "redirect:/viewemp";    
	}
	
	@RequestMapping(value="/empedit/{id}")    
	public String edit(@PathVariable int id, Model m){    
		Employee e=employeeService.getEmployeeById(id);    
		m.addAttribute("command",e);  
		return "empedit";    
	
	}
	
	@RequestMapping(value="/editsave",method = RequestMethod.POST)    
	public String editsave(@ModelAttribute("employee") Employee employee){
		employeeService.update(employee);    
		return "redirect:/viewemp";    
	}
	
}
