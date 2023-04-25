package com.ceiba.libreria.component;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class ComponentTwoImplement implements ComponentDependency {
    @Override
    public void saludar() {
        System.out.println("hola desde el componente 2");
    }
}
