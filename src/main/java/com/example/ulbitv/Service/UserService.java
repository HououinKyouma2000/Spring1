package com.example.ulbitv.Service;

import com.example.ulbitv.entity.UserEntity;
import com.example.ulbitv.entity.UserNotFoundException;
import com.example.ulbitv.exeption.UserAlreadyExistException;
import com.example.ulbitv.model.User;
import com.example.ulbitv.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public UserEntity registration(UserEntity user) throws UserAlreadyExistException {
        if (userRepo.findByUsername(user.getUsername()) != null) {
            throw new UserAlreadyExistException("Klient uje imeetsya");
        }
        return userRepo.save(user);
    }

    public User getOne(Long id) throws UserNotFoundException {
        UserEntity user =userRepo.findById(id).get();
        if (user==null) {
            throw new UserNotFoundException("Ne nayden");
        }
        return User.toModel(user);
    }

    public Long delete(Long id){
        userRepo.deleteById(id);
        return id;
    }
}
