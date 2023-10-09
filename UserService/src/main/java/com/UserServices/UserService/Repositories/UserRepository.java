package com.UserServices.UserService.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.UserServices.UserService.Entities.User;

public interface UserRepository extends JpaRepository<User, String>
{
    
}
