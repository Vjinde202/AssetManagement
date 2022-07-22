package com.abc.AssetManagement.UserWeb;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.AssetManagement.UserDTO.LoginDTO;
import com.abc.AssetManagement.UserDTO.LoginResponseDTO;
import com.abc.AssetManagement.UserEntity.Employee;
import com.abc.AssetManagement.UserException.InvalidUserException;
import com.abc.AssetManagement.UserException.WrongUserOrPasswordException;
import com.abc.AssetManagement.UserService.EmployeeService;

@RestController
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("/employee")
	public Employee doLogin(@RequestBody LoginDTO loginObj,HttpServletRequest req) throws InvalidUserException,WrongUserOrPasswordException{
		String username = loginObj.getUsername();
		String password = loginObj.getPassword();
		if(employeeService.validateentry(username)&&employeeService.validateentry(password)) {
			Employee role =  employeeService.login(username, password);
			if( employeeService.verifyforRegistration(username, password)) {
			
				if(role.getRole()!=null)
				{
				
					// generate new session 
					HttpSession session = req.getSession(true);
					
					session.setAttribute("role", role.getRole());
					session.setAttribute("username",role.getUsername());
					session.setAttribute("password",role.getPassword());
					
					return role;
					
				
				
				}
				else
				{
			
				throw new InvalidUserException("","");
				}
			
			  }
			else
			{
			
			throw new WrongUserOrPasswordException(username,password);
			}
			
			
		}
		else
		{
		
			throw new InvalidUserException("","");
		}
	}
	@GetMapping("/employee/logout")
	public String doLogout(HttpServletRequest req)
	{
		HttpSession session = req.getSession(false);
		String role = (String)session.getAttribute("role");
		if(role!=null)
		{
			String msg = (String)session.getAttribute("username")+"("+role+")"+"logged out successfully";
			session.invalidate();
			return msg;
		}
		else return "cannot logout";
		
	}
	
	
	

}
