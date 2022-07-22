package com.example.springdata01.controller;

import com.example.springdata01.model.UserDB;
import com.example.springdata01.service.UserDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class UserDBController {

    @Autowired
    private UserDBService service;

    @GetMapping("/{id}")
    public ResponseEntity<UserDB> buscaPorId(@PathVariable long id){
        return ResponseEntity.ok(service.getUserByID(id));
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<UserDB> buscaPorEmail(@PathVariable String email){
        return ResponseEntity.ok(service.findByEmail(email));
    }

    @PostMapping
    public ResponseEntity<UserDB> insertUserDB(@RequestBody UserDB newUser){
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
        service.deleteUserDB(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserDB>> findAllUserDB(){
        return ResponseEntity.ok(service.findAll());
    }

    @PutMapping
    public ResponseEntity<UserDB> updateUserDB(@RequestBody UserDB user) {
        return ResponseEntity.ok(service.update(user));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<UserDB> updateUserDB(@PathVariable long id, @RequestBody Map<String, String> changes) {
        return ResponseEntity.ok(service.updateParcial(id, changes));
    }
}
