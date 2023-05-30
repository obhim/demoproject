package com.file.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.file.entity.User;

public interface UserService {

	

	List<?> getUser();

	User addUser(User user);

	void deleteUser(Integer id);

	ResponseEntity<?> updatUser(User user, Integer id);

}
