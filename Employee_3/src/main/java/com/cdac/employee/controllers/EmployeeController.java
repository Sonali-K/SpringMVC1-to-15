package com.cdac.employee.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.cdac.employee.bean.Employee;
import com.cdac.employee.service.IEmployeeService;


@Controller
public class EmployeeController {
	
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
	public String save(@ModelAttribute("student") Employee employee){
	
			employeeService.save(employee);    
			return "viewemp";
		}
	}
	

