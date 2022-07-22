package com.example.springdata01.repository;

import com.example.springdata01.model.UserDB;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  IUserDBRepo extends CrudRepository<UserDB, Long> {
    UserDB findByEmail(String email);
}
