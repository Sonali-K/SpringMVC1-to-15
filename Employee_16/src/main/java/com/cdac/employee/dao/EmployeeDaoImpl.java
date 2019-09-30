package com.cdac.employee.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;


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
		String sql="insert into EmployeeData1(name,dob,gender) " + "values('"+e.getName()+"','"+e.getDob()+"','"+e.getGender()+"')";    
		System.out.println(sql);
		return template.update(sql);
	}

	
	@Override
	public int update(Employee e) {
		// TODO Auto-generated method stub
		String sql="update EmployeeData1 set name='"+e.getName()+"',dob='"+e.getDob()+"', gender='"+e.getGender()+"' where id="+e.getId()+"";    
		return template.update(sql);
	}

	@Override
	public int delete(int id) {
		String sql="delete from EmployeeData1 where id="+id+"";    
		return template.update(sql);
	}
	
	@Override
	public Employee getEmployeeById(int id) {
		String sql="select * from EmployeeData1 where id=?";    
		return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Employee>(Employee.class));
	}
	
	@Override
	public List<Employee> getEmployees() {
		return template.query("select * from EmployeeData1",new RowMapper<Employee>(){    
			public Employee mapRow(ResultSet rs, int row) throws SQLException {    
				Employee e=new Employee();    
				e.setId(rs.getInt(1));    
				e.setName(rs.getString(2));
				e.setDob(rs.getString(3));
				e.setGender(rs.getString(4));
		
		return e;
	}
		});
	}
	
	
	

}