package dev.esdras.jwtpoc.services;

import dev.esdras.jwtpoc.model.Cliente;
import dev.esdras.jwtpoc.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService implements IClienteService {

    @Autowired
    private ClienteRepository repository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    @Override
    public Cliente salvar(Cliente cliente) {
        cliente.setSenha(passwordEncoder.encode(cliente.getSenha()));
        return repository.save(cliente);
    }

    @Override
    public List<Cliente> buscarTodos() {
        return repository.findAll();
    }

    @Override
    public Cliente buscarPorEmail(String email) {
        return repository.findByEmail(email);
    }
}
