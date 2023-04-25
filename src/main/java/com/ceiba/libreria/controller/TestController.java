package com.ceiba.libreria.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping("/")
    @ResponseBody
    public ResponseEntity<String> methodProof(){
        return new ResponseEntity<>("hello from controller, prueba de devTools", HttpStatus.OK);
    }
}
