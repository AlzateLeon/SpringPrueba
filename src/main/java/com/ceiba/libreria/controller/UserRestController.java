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

    private final GetUser getUser;
    private final CreateUser createUser;
    private final DeleteUser deleteUser;
    private final UpdateUser updateUser;

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

    @DeleteMapping("/{id}")
    ResponseEntity delete(@PathVariable Long id){
        deleteUser.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    //PathVariable -> va en la ruta (URL)
    //RequestParam -> ? nombre = valor; en la URL
    //RequestBody -> va en el body

    //patron repositorio -> para no usar una BD especifica

    @PutMapping("/{id}")
    ResponseEntity<User> replace(@RequestBody User user, @PathVariable Long id){
        return new ResponseEntity<>(updateUser.update(user, id), HttpStatus.OK);
    }
}

