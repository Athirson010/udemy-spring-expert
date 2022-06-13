package io.github.athirson010.service.impl;

import io.github.athirson010.model.entity.Cliente;
import io.github.athirson010.repository.ClientesRespository;
import io.github.athirson010.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {
    private ClientesRespository repository;

    //Construtor com a injeção de dependencia, buscando a instância que esta sendo executada.
    @Autowired
    public ClienteServiceImpl(ClientesRespository respository) {
        this.repository = respository;
    }


    //precisa explicitar que ele vai fazer uma transação na base de dados
    public Cliente salvarCliente(Cliente cliente){
        return repository.save(cliente);
    }
    public Cliente atualizar(Long id, Cliente cliente){
        cliente.setId(id);
        if(repository.existsById(id)){
            repository.save(cliente);
            return cliente;
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    public void deletar(Cliente cliente){
        repository.delete(cliente);
    }

    public void deletar(Long id){
        repository.deleteById(id);
    }
    public List<Cliente> buscarPeloNome(String nome) {
        return repository.findByNomeLike(nome);
    }

    public List<Cliente> obterTodos(){
        return repository.findAll();
    }

    public Cliente findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado!"));
    }

    public List<Cliente> findAll(Cliente filtro) {
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnoreNullValues()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example example = Example.of(filtro, matcher);

        return repository.findAll(example);
    }
}
