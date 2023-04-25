package com.ceiba.libreria.caseuse;

import com.ceiba.libreria.entity.User;
import com.ceiba.libreria.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class DeleteUser {

    private UserService userService;

    public DeleteUser(UserService userService) {
        this.userService = userService;
    }

    public void delete(Long id) {
        this.userService.delete(id);
    }
}
