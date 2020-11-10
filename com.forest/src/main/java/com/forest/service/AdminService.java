package com.forest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.fms.exceptions.InvalidOperation;
import com.cg.fms.utility.ValidateAdmin;
import com.forest.model.Admin;
import com.forest.repository.AdminRepository;
@Service
public class AdminService {
	@Autowired
	private AdminRepository adminRepository;
	
	public Admin getAdminById(Integer id) {
		try {
			return adminRepository.findById(id).get();
		}
		catch(InvalidOperation ie)
		{
			ie.printStackTrace();
			return null;
		}
	}
	public Admin insertAdmin(Admin admin) {
		
		String name=admin.getAdminName();
		
		if(name.matches(ValidateAdmin.nameregex) && admin.getAdminPassword().matches(ValidateAdmin.passwordregex))
		{
			return adminRepository.save(admin);
		}
		
		else{
			
			throw new InvalidOperation("Admin not inserted");
		}
	
	}
	public Admin updateAdmin(Admin admin) {
		if(admin!=null && admin.getAdminName().matches(ValidateAdmin.nameregex) && admin.getAdminPassword().matches(ValidateAdmin.passwordregex))
		{
			adminRepository.save(admin);
			return admin;
		}
		else
		{
			throw new InvalidOperation("Admin not updated");
			
		}
	}
	public boolean deleteAdminbyId(Integer id) {
		try {
			adminRepository.deleteById(id);
			return true;
		}
		catch(InvalidOperation ie)
		{
			throw new InvalidOperation("Admin not deleted");
		}
	
	}
	public List<Admin> getAllAdmins() {
		List<Admin> adminlist=new ArrayList<>();
		adminRepository.findAll().forEach(admin->adminlist.add(admin));
		return adminlist;
	}
	
}
