package com.cetpa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cetpa.models.Employee;
import com.cetpa.repositories.EmployeeRepository;

@Service
public  class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository repo;

	public List<Employee> getList() {
		return repo.findAll();
	}

	public void saveRecord(Employee emp) {
		repo.save(emp);
	}

	public void deleteRecord(int eid) {

		repo.deleteById(eid);
	}

	public Employee getRecords(int eid) {

		return repo.findById(eid).orElse(null);
	}

	public void updateRecord(Employee nemp) {
		repo.save(nemp);
	}

}
