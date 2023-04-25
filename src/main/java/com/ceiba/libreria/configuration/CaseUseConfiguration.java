package com.ceiba.libreria.configuration;

import com.ceiba.libreria.caseuse.GetUser;
import com.ceiba.libreria.caseuse.GetUserImplement;
import com.ceiba.libreria.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CaseUseConfiguration {

    @Bean
    GetUser getUser(UserService userService){
        return new GetUserImplement(userService);
    }
}
