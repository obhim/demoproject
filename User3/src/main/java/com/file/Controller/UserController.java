package com.file.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.file.Service.UserService;
import com.file.entity.User;

//put rest controller insted of controller
@RestController
public class UserController {
	@Autowired
	private UserService service;
	
	@GetMapping("/getUser")
	public List<?> getUser(){
		return service.getUser();
		
	}
	@PostMapping("/addUser")
	public User addUser(@RequestBody User user) {
		return service.addUser(user);
		
	}
	@DeleteMapping("/deleteUser/{id}")
	public void deleteUser(@PathVariable ("id")Integer id) {
		service.deleteUser(id);
	}
	@PutMapping("/editUser/{id}")
	public ResponseEntity<?> updatUser(@RequestBody User user,@PathVariable("id") Integer id) {
		return service.updatUser(user,id);
		
	}
	

}
