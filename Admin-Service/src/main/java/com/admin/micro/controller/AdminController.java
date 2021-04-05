package com.admin.micro.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.admin.micro.dto.LoginDto;
import com.admin.micro.entity.Admin;
import com.admin.micro.service.AdminService;

@RestController
@RequestMapping(value="/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/getAllAdmin")
	public List<Admin> getAllAdmins(){
		return adminService.getAllAdmin(); 
	}
	
	@PostMapping("/saveAdmin")
	public Admin saveAdmin(@RequestBody Admin admin) {
		return adminService.saveAdmin(admin);
	}
	
	@GetMapping("/getUser")
	public List<Object> getFirstProduct() {
		String url="http://localhost:8082/user/getAllUsers";
		   Object[] objects= restTemplate.getForObject(url, Object[].class);
		   return Arrays.asList(objects);
		}
	
	@PostMapping("/login")
	public LoginDto login(@RequestBody LoginDto login) {
		return adminService.login(login);
	}
}
