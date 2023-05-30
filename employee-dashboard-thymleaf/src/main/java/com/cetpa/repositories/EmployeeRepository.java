package com.cetpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cetpa.models.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>
{
	
}
