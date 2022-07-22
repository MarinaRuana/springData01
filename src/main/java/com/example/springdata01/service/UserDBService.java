package com.example.springdata01.service;

import com.example.springdata01.model.UserDB;
import com.example.springdata01.repository.IUserDBRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDBService implements IUserDBService{

    @Autowired
    private IUserDBRepo repo;

    @Override
    public Optional<UserDB> getUserByID(long id){
       return repo.findById(id);
    }

    @Override
    public UserDB insertUser(UserDB newUser){
        if(newUser.getId() > 0){
           return null;
           // TODO: throw Exception UserDBAlreadExixts
        }
        return repo.save(newUser);
    }

    @Override
    public void deleteUserDB(long id) {
       if(repo.findById(id).isPresent()){
           repo.deleteById(id);
       }
       // TODO: throw Exception UserDBNotFound
    }

}
