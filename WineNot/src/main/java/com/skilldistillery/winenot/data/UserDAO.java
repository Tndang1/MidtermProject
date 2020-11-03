package com.skilldistillery.winenot.data;

import java.util.List;

import com.skilldistillery.winenot.entities.User;

public interface UserDAO {

	User getUserById(int id);
	List<User> getAllUsers();
	User createUser(User user);
	User updateUser(int id, User user);
	boolean deleteUser(int id);
	
	public boolean disableUser(int id);
	public boolean enableUser(int id);
	
}
