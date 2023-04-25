package com.ceiba.libreria.controller;

import com.ceiba.libreria.caseuse.CreateUser;
import com.ceiba.libreria.caseuse.DeleteUser;
import com.ceiba.libreria.caseuse.GetUser;
import com.ceiba.libreria.caseuse.UpdateUser;
import com.ceiba.libreria.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserRestController {

    private GetUser getUser;
    private CreateUser createUser;
    private DeleteUser deleteUser;
    private UpdateUser updateUser;

    public UserRestController(GetUser getUser, CreateUser createUser,
                              DeleteUser deleteUser, UpdateUser updateUser) {
        this.createUser = createUser;
        this.getUser = getUser;
        this.deleteUser = deleteUser;
        this.updateUser = updateUser;
    }

    //create get, update, delete
    @GetMapping
    List<User> get(){
        return getUser.getAll();
    }

    @PostMapping
    ResponseEntity<User> createuser(@RequestBody User user){
        return new ResponseEntity<>(createUser.save(user), HttpStatus.CREATED);
    }

    @DeleteMapping("/id")
    ResponseEntity delete(@PathVariable Long id){
        deleteUser.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/id")
    ResponseEntity<User> replace(@RequestBody User user, @PathVariable Long id){
        return new ResponseEntity<>(updateUser.update(user, id), HttpStatus.OK);
    }
}

