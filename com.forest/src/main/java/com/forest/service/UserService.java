package com.forest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.fms.exceptions.InvalidOperation;
import com.forest.model.User;
import com.forest.repository.UserRepository;
@Service
public class UserService {
	@Autowired
	private UserRepository userrepository;
	
	public String login(User user) {
		String userName=user.getUserName();
		User loginUser=userrepository.findById(userName).get();
		if(loginUser==null)
		{
			try {
			throw new InvalidOperation("Please enter correct details");
			}
			catch(InvalidOperation ie)
			{
				System.out.println(ie);
			}
		}
		else
		{
			String pwd=loginUser.getUserPassword();
			String uname=loginUser.getUserName();
			if(pwd.equals(user.getUserPassword()) && uname.equalsIgnoreCase(user.getUserName()))
			{
				String str=loginUser.getUserName()+" has successfully logged in";
				return str;
			}
		}
		return null;
	}
	
	public User insertUser(User user) {
		if(user!=null)
		{
			return userrepository.save(user);
		}
		else
		{
			throw new InvalidOperation("user not added");
		}
	}
	public boolean deleteAdminbyName(String userName) {
		if(userName!=null) {
			userrepository.deleteById(userName);
			return true;
		}
		else
		{
			throw new InvalidOperation("User deleted");
		}
	}
	
	public String logout(User user) {
		return  user.getUserName()+ " has logged out successfully";
	}
	


}
