package osaProjekat.service;

import java.util.List;

import osaProjekat.entity.User;

public interface UserServiceInterface {

	List<User> findAll();
	
	User findOne(Long userId);
	
	User findByUsernameAndPassword(String username, String password);
	
	User findByUsername(String username);
	
	User save(User user);
	
	void remove(Long id);
}