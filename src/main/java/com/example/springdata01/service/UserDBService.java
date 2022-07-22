package com.example.springdata01.service;

import com.example.springdata01.exception.BadRequestException;
import com.example.springdata01.exception.UserNotFoundException;
import com.example.springdata01.model.UserDB;
import com.example.springdata01.repository.IUserDBRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UserDBService implements IUserDBService{

    @Autowired
    private IUserDBRepo repo;

    @Override
    public UserDB getUserByID(long id){
       return repo.findById(id).orElseThrow(() -> new UserNotFoundException("Usuário não encontrado: id" + id));
    }

    @Override
    public UserDB insertUser(UserDB newUser){
        if(newUser.getId() > 0){
           throw new BadRequestException("Usuário não pode ter Id para ser nserido");
        }
        return repo.save(newUser);
    }

    @Override
    public UserDB update(UserDB user) {
        getUserByID(user.getId());
        return repo.save(user);
    }

    @Override
    public UserDB updateParcial(long id, Map<String, String> changes) {
        UserDB userFound = getUserByID(id);
        changes.forEach((atributo, valor) -> {
            switch (atributo){
                case "name" : userFound.setName(valor);
                case "email" : userFound.setEmail(valor);
            }
        });
        return repo.save(userFound);
    }

    @Override
    public void deleteUserDB(long id) {
       UserDB userFound = getUserByID(id);
       repo.delete(userFound);
    }

    @Override
    public List<UserDB> findAll() {
        // Metodo findAll() do CRUD retorna um Iterable, fazer cast para List;
        return (List<UserDB>) repo.findAll();
    }

}
