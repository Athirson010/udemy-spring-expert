package io.github.athirson010;

import io.github.athirson010.model.entity.Cliente;
import io.github.athirson010.repository.ClientesRespository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class VendasApplication {

    @Bean
    public CommandLineRunner init(ClientesRespository clienteRepository) {
        return args -> {
            clienteRepository.save(new Cliente("Athirson"));
            clienteRepository.save(new Cliente("Juninho"));
            clienteRepository.save(new Cliente("Bahiano"));
            clienteRepository.deleteById(3L);
            clienteRepository.findAll().forEach(cliente -> System.out.println(cliente.toString()));

        };
    }

    public static void main(String[] args) {
        //nome da classe com a anotação + args dos parametros
        SpringApplication.run(VendasApplication.class, args);


    }
}
