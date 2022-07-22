package com.abc.AssetManagement.UserRepository;

import com.abc.AssetManagement.UserEntity.Employee;

public interface CustomUserRepository {
	public Employee verifyUser(String username,String password);
	public boolean verifyEntries(String username, String password);

}
