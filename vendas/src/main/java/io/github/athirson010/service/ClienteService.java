package io.github.athirson010.service;

import io.github.athirson010.model.entity.Cliente;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ClienteService  {
    Cliente salvarCliente(Cliente cliente);


    Cliente atualizar(Long id, Cliente cliente);

    List<Cliente> findAll(Cliente filtro);

    void deletar(Long id);

    Cliente findById(Long id);
}
