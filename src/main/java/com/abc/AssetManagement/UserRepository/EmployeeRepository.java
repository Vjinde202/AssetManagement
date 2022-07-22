package com.abc.AssetManagement.UserRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abc.AssetManagement.UserEntity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository< Employee,Integer>,CustomUserRepository{

}
