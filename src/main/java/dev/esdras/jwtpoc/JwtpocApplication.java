package dev.esdras.jwtpoc;

import dev.esdras.jwtpoc.model.Cliente;
import dev.esdras.jwtpoc.model.enums.Profile;
import dev.esdras.jwtpoc.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;

@SpringBootApplication
public class JwtpocApplication implements CommandLineRunner {

	@Autowired
	private ClienteService clienteService;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(JwtpocApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Cliente esdras = new Cliente("Esdras", "bzr4@icloud.com", "segredo");
		Cliente erika = new Cliente("Erika", "erika@icloud.com", "carpediem");
		erika.addPerfil(Profile.ADMIN);

		Arrays.asList(esdras, erika).forEach(cliente -> clienteService.salvar(cliente));
	}
}
