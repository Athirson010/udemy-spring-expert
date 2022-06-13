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
        };
    }

    public static void main(String[] args) {
        //nome da classe com a anotação + args dos parametros
        SpringApplication.run(VendasApplication.class, args);


    }
}
