package com.abc.AssetManagement.UserService;

import java.util.List;

import org.springframework.stereotype.Service;

import com.abc.AssetManagement.UserEntity.Employee;
import com.abc.AssetManagement.UserException.InvalidUserException;

@Service
public interface EmployeeService {
	public Employee login(String username,String password) throws InvalidUserException;
	public boolean validateentry(String data);

	public boolean verifyforRegistration(String username,String password);
	public Employee getEmployee(int id);/*throws InvalidUserException;*/
}
