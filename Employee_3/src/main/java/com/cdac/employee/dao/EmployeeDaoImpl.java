package com.cdac.employee.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.cdac.employee.bean.Employee;

public class EmployeeDaoImpl implements IEmployeeDao{
	@Autowired
	JdbcTemplate template;    
	public void setTemplate(JdbcTemplate template) {    
		this.template = template;    
	}
	
	@Override
	public int save(Employee e) {
		// TODO Auto-generated method stub
		String sql="insert into EmployeeData1(name,dob) "
				+ "values('"+e.getName()+"','"+e.getDob()+"')";    
		System.out.println(sql);
		return template.update(sql);
	}

}
