package dev.esdras.jwtpoc.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class HelloJWT {

    @GetMapping("/hellojwt")
    public ResponseEntity<String> helloJwt() {
        return ResponseEntity.ok().body("<h1>Hello JWT</h1>");
    }
}
