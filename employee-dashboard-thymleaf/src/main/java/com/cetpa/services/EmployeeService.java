package com.cetpa.services;

import java.util.List;

import com.cetpa.models.Employee;

public interface EmployeeService 
{
	List<Employee> getList();

	void saveRecord(Employee emp);

	void deleteRecord(int eid);

	Employee getRecords(int eid);

	void updateRecord(Employee emp);
}
