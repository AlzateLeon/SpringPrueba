package com.ceiba.libreria.caseuse;

import com.ceiba.libreria.entity.User;
import com.ceiba.libreria.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class GetUserImplement implements  GetUser {

    private UserService userService;

    public GetUserImplement(UserService userService) {
        this.userService = userService;
    }

    @Override
    public List<User> getAll() {
        return userService.getAllusers();
    }
}
