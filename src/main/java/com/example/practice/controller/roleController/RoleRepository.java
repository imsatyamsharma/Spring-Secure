package com.example.practice.controller.roleController;

import com.example.practice.models.ERole;
import com.example.practice.models.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RoleRepository extends MongoRepository<Role,String> {
      Optional<Role> findByName(ERole name);
}