package com.cdac.employee.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cdac.employee.bean.Employee;

@Controller
public class EmployeeController {
	
	@RequestMapping("employeeForm")
	public String showForm(Model m) {
		m.addAttribute("employee",new Employee());
		return "employeeForm";
	}

}
