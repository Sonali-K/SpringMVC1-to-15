package com.cdac.employee.dao;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;


import com.cdac.employee.bean.Employee;

public interface IEmployeeDao {
	public int save(Employee e);
	
	public List<Employee> getEmployees();
	public int update(Employee employee);
	public int delete(int id);
	public Employee getEmployeeById(int id);

	public int insertRecords(String title, MultipartFile photo) throws IOException;

	

}
