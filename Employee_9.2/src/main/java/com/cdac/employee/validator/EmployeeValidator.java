package com.cdac.employee.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.cdac.employee.bean.Employee;

@Component
public class EmployeeValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Employee.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
	    ValidationUtils.rejectIfEmpty(errors, "name", "Employee.name.empty");
	    ValidationUtils.rejectIfEmpty(errors, "dob", "Employee.dob.empty");
	    ValidationUtils.rejectIfEmpty(errors, "gender", "Employee.gender.empty");
		
	}

}
