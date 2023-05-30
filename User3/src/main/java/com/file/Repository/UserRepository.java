package com.file.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.file.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>{

}
