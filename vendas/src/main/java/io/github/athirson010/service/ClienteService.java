package io.github.athirson010.service;

import io.github.athirson010.model.entity.Cliente;
import io.github.athirson010.repository.ClientesRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import java.util.List;

@Service
public class ClienteService {
    private ClientesRespository repository;

    //Construtor com a injeção de dependencia, buscando a instância que esta sendo executada.
    @Autowired
    public ClienteService(ClientesRespository respository) {
        this.repository = respository;
    }

    //precisa explicitar que ele vai fazer uma transação na base de dados
    public Cliente salvarCliente(Cliente cliente){
      return repository.save(cliente);
    }
    public Cliente atualizar(Cliente cliente){
        repository.save(cliente);
        return cliente;
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
}
