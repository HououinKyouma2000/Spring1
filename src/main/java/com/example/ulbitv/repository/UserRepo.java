package com.example.ulbitv.repository;

import com.example.ulbitv.entity.UserEntity;
import org.apache.catalina.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<UserEntity,Long> {
    UserEntity findByUsername(String username);
}
