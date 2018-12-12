package com.soft.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.soft.app.model.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long>{
	
	@Query("SELECT u FROM User u where u.email=?1 AND u.password=?2")
	public User getUserByEmailAndPassword(String email,String password);
	
	@Query("SELECT u FROM User u where u.email=?1")
	public User getUserByUsername(String email);

}
