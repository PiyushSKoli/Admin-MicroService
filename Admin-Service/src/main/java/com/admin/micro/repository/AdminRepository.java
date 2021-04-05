package com.admin.micro.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.admin.micro.entity.Admin;

@Repository
public interface AdminRepository extends MongoRepository<Admin,String> {


	Admin findByEmailAndPasswordAndRole(String email, String password, String role);

}
