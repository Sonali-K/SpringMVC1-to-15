package com.cdac.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
