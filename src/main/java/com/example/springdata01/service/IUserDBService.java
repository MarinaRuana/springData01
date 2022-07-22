package com.example.springdata01.service;

import com.example.springdata01.model.UserDB;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface IUserDBService {
    UserDB getUserByID(long id);

    UserDB insertUser(UserDB newUser);

    UserDB update(UserDB user);

    UserDB updateParcial(long id, Map<String, String> changes);

    void deleteUserDB(long id);

    List<UserDB> findAll();
}
