package com.ceiba.libreria.caseuse;

import com.ceiba.libreria.entity.User;
import com.ceiba.libreria.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class CreateUser  {

    private UserService userService;

    public CreateUser(UserService userService) {
        this.userService = userService;
    }

    public User save(User user) {
      return  this.userService.createUser(user);
    }
}
