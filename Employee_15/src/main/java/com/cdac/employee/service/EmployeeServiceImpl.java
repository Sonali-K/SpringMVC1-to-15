package com.cdac.employee.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cdac.employee.bean.Employee;
import com.cdac.employee.dao.IEmployeeDao;

@Service
public class EmployeeServiceImpl implements IEmployeeService{

	@Autowired
	private IEmployeeDao employeeDao;
	@Override
	public int save(Employee e) {
		// TODO Auto-generated method stub
		return employeeDao.save(e);
				
	}
	@Override
	public List<Employee> getEmployees() {
		// TODO Auto-generated method stub
		return employeeDao.getEmployees();
	}
	@Override
	public int update(Employee employee) {
		// TODO Auto-generated method stub
		return employeeDao.update(employee);
	}
	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return employeeDao.delete(id);
	}
	@Override
	public Employee getEmployeeById(int id) {
		// TODO Auto-generated method stub
		return employeeDao.getEmployeeById(id);
	}
	@Override
	public int insertRecords(String title, MultipartFile photo) throws IOException {
		// TODO Auto-generated method stub
		return employeeDao.insertRecords(title,photo);
	}
	
	
	
	

}
