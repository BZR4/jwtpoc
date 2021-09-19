package dev.esdras.jwtpoc.services;

import dev.esdras.jwtpoc.model.Cliente;
import dev.esdras.jwtpoc.security.SecureUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private ClienteService clienteService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Cliente cliente = clienteService.buscarPorEmail(email);

        if (cliente == null) {
            throw new UsernameNotFoundException(email);
        }
        return new SecureUser(cliente.getId(), cliente.getEmail(), cliente.getSenha(), cliente.getPerfis());
    }
}
