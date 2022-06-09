package io.github.athirson010.configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//para buscar uma classe fora do pacote, usamos a anotação @CompontentScan(basePackages = {"",""})
public class MinhaConfiguration {

    @Value("${application.name}")
    private String applicationName;

    //caso eu criar uma bean com o mesmo tipo, e desejo pegar somente 1 tenho que adicionar duas anotações
    //@Autowired para injetar e o @Qualifer("nome da bean")

    //classe de configuração mapear conexão, ou que inicia junto a aplicação junto a @Bean (metodo)

    //Components genericamente é o pai das são Controllers, Repository ou services
    //caso eu tiver uma classe que não se encaixa em nenhum posso colocar o component (classe)
    @Bean(name = "appNameDevelopment")
    public CommandLineRunner execute(){
        return args -> {
            System.out.println("Iniciando configuração de " + applicationName +"!" );
        };
    }
    //O CommandLineRunner é utilizado para executar tarefas quando o servidor inicializa
    //Para usar uma configuração específica de bean para o ambiente, usamos o @Profile

}
