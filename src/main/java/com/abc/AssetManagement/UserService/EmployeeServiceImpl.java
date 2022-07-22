package com.abc.AssetManagement.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.AssetManagement.UserEntity.Employee;
import com.abc.AssetManagement.UserException.InvalidUserException;
import com.abc.AssetManagement.UserRepository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	 EmployeeRepository employeeRepository;

	@Override
	public Employee login(String username, String password) throws InvalidUserException{
		Employee emp = employeeRepository.verifyUser(username, password);
		
		return emp;   
	} 
	public boolean validateentry(String data) {
		return (data!=null)?true:false;
	}
	public boolean verifyforRegistration(String username,String password) {
		if(employeeRepository.verifyEntries(username, password)== true) {
			return true;
		}
		else 
		{
			return false;
		}
		
		
	}
	@Override
	public Employee getEmployee(int id) {
		Employee employee= employeeRepository.findById(id).get();
		return employee;
	}
	

}
