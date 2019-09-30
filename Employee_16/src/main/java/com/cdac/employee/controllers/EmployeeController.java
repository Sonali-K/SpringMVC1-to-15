package com.cdac.employee.controllers;


import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.cdac.employee.bean.Employee;
import com.cdac.employee.service.IEmployeeService;
import com.cdac.employee.validator.EmployeeValidator;


@Controller
public class EmployeeController {
//private static String UPLOAD_DIRECTORY = "/home/sonali/images";
	
	@Autowired
	private EmployeeValidator employeeValidator;
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
	    binder.addValidators(employeeValidator);
	}

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
	public String save(@ModelAttribute("employee") @Validated Employee employee,BindingResult result){
	
		if (result.hasErrors()) {
            return "employeeForm";
        } 
		else {
        	employeeService.save(employee);    
            return "redirect:/viewemp";
      
		}
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
	
	
	@RequestMapping("/viewempDataTable")
//  @ResponseBody
  public String viewStudentDataTable(Model model, Locale locale) throws JsonGenerationException, JsonMappingException, IOException{
		List<Employee> list=employeeService.getEmployees();
      ObjectMapper mapper = new ObjectMapper();
      model.addAttribute("employeeList", mapper.writeValueAsString(employeeService.getEmployees()));
      return "viewDataTable";    
  }
	
    

	
}
