package com.admin.micro.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "admin")
public class Admin {

	@Id
	private String id;
	
	private String name;
	
	private String surname;
	
	private String email;
	
	private String password;
	
	private String role;
	
}
