package com.abc.AssetManagement.UserRepository;


import java.util.List;

import javax.persistence.EntityManager;



import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import com.abc.AssetManagement.UserEntity.Employee;



public class CustomUserRepositoryImpl implements CustomUserRepository{
	
	@Autowired
	EntityManager jpa;
	
	@Override
	public Employee verifyUser(String username, String password){
		Session spring = jpa.unwrap(Session.class);
		
		String query = "from Employee e where username =:enteredUsername and password =:enteredPassword";
		
		Query<Employee> q = spring.createQuery(query);
		q.setParameter("enteredUsername", username);
		q.setParameter("enteredPassword", password);
		
		List<Employee> output =  q.getResultList();
		System.out.println(output);
		if(output.size()!=0) {
		return output.get(0); 
		}
		else
		{
			return null;
		}
			
		
		
		
	} 
	@Override
	public boolean verifyEntries(String username, String password) {
		Session spring = jpa.unwrap(Session.class);
		
		String query1 = "select username from Employee e where username=:enteredUsername";
		String query2 = "select username from Employee e where password=:enteredPassword";
		Query<String> u = spring.createQuery(query1);
		Query<String> p = spring.createQuery(query2);
		u.setParameter("enteredUsername", username);
		p.setParameter("enteredPassword", password);
		
		List<String> uOutput =  u.getResultList();
		List<String> pOutput =  p.getResultList();
		boolean status = false;
		if(uOutput.size()!=pOutput.size())
		{
			
			return status;
			
			
		}
		else
		{
			
			return status = true;
			
		}
		
	} 

}
