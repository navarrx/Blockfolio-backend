package com.example.myapp.User;

import org.springframework.data.repository.CrudRepository;
import com.example.myapp.User.User;

public interface UserRepository extends CrudRepository<User, Integer>{
}