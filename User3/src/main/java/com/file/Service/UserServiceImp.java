package com.file.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.file.Repository.UserRepository;
import com.file.entity.User;

@Service
public class UserServiceImp implements UserService {
@Autowired
private UserRepository repo;
	@Override
	public List<?> getUser() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}
	@Override
	public User addUser(User user) {
		// TODO Auto-generated method stub
		return repo.save(user);
	}
	
	@Override
	public void deleteUser(Integer id) {
		repo.deleteById(id);
		
	}
	@Override
	public ResponseEntity<?> updatUser(User user, Integer id) {
		  User user1=repo.findById(id).get();
		  if(user1 !=null) {
		  user1.setName(user.getName());
		  user1.setCity(user.getCity());
		 repo.save(user1);
			return  new ResponseEntity<>(HttpStatus.ACCEPTED);
		  }else {
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
}


