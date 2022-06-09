package io.github.athirson010;

import io.github.athirson010.configuration.MinhaConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class VendasApplication {


    public static void main(String[] args) {
        //nome da classe com a anotação + args dos parametros
        SpringApplication.run(VendasApplication.class, args);

    }
}
