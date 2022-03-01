package com.example.ulbitv.model;

import com.example.ulbitv.entity.UserEntity;

public class User {
    private Long id;
    private String username;

    public static User toModel (UserEntity entity){
        User model =new User();
        model.setId(entity.getId());
        model.setUsername(entity.getUsername());
        return  model;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
