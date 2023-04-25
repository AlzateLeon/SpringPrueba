package com.ceiba.libreria.caseuse;

import com.ceiba.libreria.entity.User;
import com.ceiba.libreria.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class UpdateUser {

    private UserService userService;

    public UpdateUser(UserService userService) {
        this.userService = userService;
    }

    public User update(User use , Long id) {
        return  this.userService.update(use, id);
    }
}
