package io.github.athirson010.service.impl;

import io.github.athirson010.model.entity.Produto;
import io.github.athirson010.repository.ProdutosRepository;
import io.github.athirson010.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ProdutoServiceImpl implements ProdutoService {
    @Autowired
    private ProdutosRepository repository;

    public ProdutoServiceImpl(ProdutosRepository repository) {
        this.repository = repository;
    }

    public Produto save(Produto produto) {
        return repository.save(produto);
    }
    public Produto atualizar(Long id, Produto produto){
        produto.setId(id);
        if(repository.existsById(id)){
            repository.save(produto);
            return produto;
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    public void deletar(Long id){
        repository.deleteById(id);
    }

    public Produto findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public List<Produto> findAll(Produto filtro) {
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnoreNullValues()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example example = Example.of(filtro, matcher);

        return repository.findAll(example);
    }
}
