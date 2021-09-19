package dev.esdras.jwtpoc.controllers;

import dev.esdras.jwtpoc.model.Cliente;
import dev.esdras.jwtpoc.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/v1/clientes")
@RestController
public class ClientController {

    @Autowired
    private ClienteService service;

    @GetMapping("/todos")
    public ResponseEntity<List<Cliente>> findAll() {
        List<Cliente> clientes = service.buscarTodos();
        return ResponseEntity.ok().body(clientes);
    }
}
