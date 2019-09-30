package com.cdac.employee.dao;

import java.util.List;



import com.cdac.employee.bean.Employee;

public interface IEmployeeDao {
	public int save(Employee e);
	
	public List<Employee> getEmployees();
	public int update(Employee employee);
	public int delete(int id);
	public Employee getEmployeeById(int id);


	

}
