package io.github.athirson010.service;

import io.github.athirson010.model.Cliente;
import io.github.athirson010.repository.ClienteRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    private ClienteRespository repository;

    //Construtor com a injeção de dependencia, buscando a instância que esta sendo executada.
    @Autowired
    public ClienteService(ClienteRespository respository) {
        this.repository = respository;
    }

    public void save(Cliente cliente){
        validarCliente(cliente);
    }

    private void validarCliente(Cliente cliente) {
        //validação de cliente
    }
}
