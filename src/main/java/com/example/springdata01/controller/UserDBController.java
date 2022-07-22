package com.example.springdata01.controller;

import com.example.springdata01.model.UserDB;
import com.example.springdata01.service.UserDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class UserDBController {

    @Autowired
    private UserDBService service;

    @GetMapping("/{id}")
    public ResponseEntity<UserDB> buscaPorId(@PathVariable long id){
        Optional<UserDB> userFound = service.getUserByID(id);
        if(userFound.isPresent()) {
            return ResponseEntity.ok(userFound.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<UserDB> insertUserDB(@RequestBody UserDB newUser){
        // TODO: Validar se o user já possui ID: Disparar uma Exception
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.insertUser(newUser));
        // @PostMapping()
        //	public ResponseEntity<User> salvar(@Valid @RequestBody User user, UriComponentsBuilder uriBuilder) {
        //		//esta URI sinaliza ao cliente o caminho a ser usado para recuperar o recurso que esta sendo criado.
        //		URI uri = uriBuilder
        //				.path("/user/{id}")
        //				.buildAndExpand(user.getId())
        //				.toUri();
        //		return ResponseEntity.created(uri).body(id);
        //	}
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserDB(@PathVariable long id){
       Optional<UserDB> userFound = service.getUserByID(id);

       if(userFound.isPresent()){
           service.deleteUserDB(id);
           return ResponseEntity.noContent().build();
       }
       return ResponseEntity.notFound().build();
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserDB>> findAllUserDB(){
        return ResponseEntity.ok(service.findAll());
    }
}
