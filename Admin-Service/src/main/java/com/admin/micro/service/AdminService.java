package com.admin.micro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.micro.dto.LoginDto;
import com.admin.micro.entity.Admin;
import com.admin.micro.repository.AdminRepository;

@Service
public class AdminService {

	@Autowired
	private AdminRepository adminRepository;
	
	public List<Admin> getAllAdmin(){
		return adminRepository.findAll();
	}
	
	public Admin saveAdmin(Admin admin) {
		admin.setRole("Admin");
		return adminRepository.save(admin);
	}
	
	public LoginDto login(LoginDto loginDto) {
		Admin admin=adminRepository.findByEmailAndPasswordAndRole(loginDto.getEmail(),loginDto.getPassword(),loginDto.getRole());
		LoginDto dto=new LoginDto();
		if(admin!= null) {
			dto.setEmail(loginDto.getEmail());
			dto.setPassword(loginDto.getPassword());
			dto.setRole(admin.getRole());
			dto.setMsg("Login Successfully");
		}else {
			dto.setEmail(loginDto.getEmail());
			dto.setPassword(loginDto.getPassword());
			dto.setRole(null);
			dto.setMsg("Login Faild");
		}
		return dto;
	}
}
