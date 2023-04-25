package com.ceiba.libreria.component;

import org.springframework.stereotype.Component;

@Component
public class ComponentImplement implements ComponentDependency {
    @Override
    public void saludar() {
        System.out.println("hola mundoooo");
    }
}
