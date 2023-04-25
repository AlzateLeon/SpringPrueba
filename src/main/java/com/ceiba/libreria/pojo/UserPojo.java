package com.ceiba.libreria.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.ConstructorBinding;

@ConfigurationProperties(prefix = "user")
@Getter
@Setter
@AllArgsConstructor
public class UserPojo {

    private String mail;
    private String password;
    private String age;

}






