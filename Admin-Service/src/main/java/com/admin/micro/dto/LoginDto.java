package com.admin.micro.dto;


import lombok.Data;

@Data
public class LoginDto {

	private String email;
	private String password;
	private String role;
	private String msg;
}
