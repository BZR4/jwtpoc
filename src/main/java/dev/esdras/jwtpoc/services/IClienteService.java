package dev.esdras.jwtpoc.services;

import dev.esdras.jwtpoc.model.Cliente;

import java.util.List;

public interface IClienteService {
    Cliente salvar(Cliente cliente);
    List<Cliente> buscarTodos();
    Cliente buscarPorEmail(String email);
}
