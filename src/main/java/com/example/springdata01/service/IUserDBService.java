package com.example.springdata01.service;

import com.example.springdata01.model.UserDB;

import java.util.List;
import java.util.Optional;

public interface IUserDBService {
    Optional<UserDB> getUserByID(long id);

    UserDB insertUser(UserDB newUser);

    void deleteUserDB(long id);

    List<UserDB> findAll();
}
