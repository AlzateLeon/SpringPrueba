package com.ceiba.libreria.configuration;

import com.ceiba.libreria.bean.MyBeanWithProperties;
import com.ceiba.libreria.bean.MyBeanWithPropertiesImplements;
import com.ceiba.libreria.pojo.UserPojo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@EnableConfigurationProperties(UserPojo.class)
@PropertySource("classpath:connection.properties")
public class GeneralConfiguration {
    @Value("${value.name}")
    private String name;

    @Value("${value.apellido}")
    private String apellido;

    @Value("${jdbc.url}")
    private String jdbc;

    @Bean
    public MyBeanWithProperties function(){
        return new MyBeanWithPropertiesImplements(name, apellido);
    }
}
