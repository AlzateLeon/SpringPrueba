package com.ceiba.libreria.bean;

public class MyBeanWithPropertiesImplements implements MyBeanWithProperties {

    private String name;
    private String surName;

    public MyBeanWithPropertiesImplements(String name, String surName) {
        this.name = name;
        this.surName = surName;
    }

    @Override
    public String function() {
        return "nombre: " + name + "apellido: " + surName ;
    }
}
