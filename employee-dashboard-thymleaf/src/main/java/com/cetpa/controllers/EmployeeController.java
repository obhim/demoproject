package com.cetpa.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cetpa.models.Employee;
import com.cetpa.services.EmployeeService;

@Controller
@RequestMapping("employee")
public class EmployeeController 
{
	@Autowired private EmployeeService service;

	@RequestMapping("dashboard")
	public String getEmployeeDashboard(Model model)
	{
		List<Employee> list=service.getList();
		model.addAttribute("elist",list);
		return "employee-dashboard";
	}
	@RequestMapping("add")
	public String getAddEmployeeView()
	{
		return "add-employee";
	}
	@RequestMapping("save-record")
	public String saveEmployeeRecord(Employee emp)
	{
		service.saveRecord(emp);
		return "redirect:dashboard";
	}
	@RequestMapping("delete-record")
	public String deleteEmployeeRecord(int eid)
	{
		service.deleteRecord(eid);
		return "redirect:dashboard";
	}
	@RequestMapping("edit-record")
	public String getEditRecordView(int eid,Model model)
	{
		String [] d=new String[] {"Training","Sales","Accounts","Human Resource","Marketing","Inventroy"};
		List<String> dlist=new ArrayList<String>();
		for(String str:d)
			dlist.add(str);
		Employee emp=service.getRecords(eid);
		model.addAttribute("emp",emp);
		model.addAttribute("dlist",dlist);
		return "edit-employee";
	}
	@RequestMapping("update-record")
	public String updateEmployeeRecord(Employee emp)
	{
		service.updateRecord(emp);
		return "redirect:dashboard";
	}
}
