package project.dao;

import java.util.List;

import project.beans.User;
import project.exceptions.LoginException;

public interface UserDAO{
	public List<User> getUsers();
	public 	User getUserByName(String uName); //Get Bank User by username. 
	public void checkPass(String username, String pass) throws LoginException;
	public void checkUsername(String username) throws LoginException;
	public void uniqueUsername(String username) throws LoginException;
	public void createUser(User user);
	public void deleteUser(int id);
	public void updateUser(User user);
}
