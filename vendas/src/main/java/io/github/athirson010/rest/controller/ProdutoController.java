package io.github.athirson010.rest.controller;


import io.github.athirson010.model.entity.Cliente;
import io.github.athirson010.model.entity.Produto;
import io.github.athirson010.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @PostMapping
    @ResponseStatus(CREATED)
    public Produto salvarProduto(@RequestBody Produto produto ){
        return service.save(produto);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody Produto produto){
       service.atualizar(id, produto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable Long id){
       service.deletar(id);
    }

    @GetMapping("/{id}")
    public Produto getById(@PathVariable Long id){
        return service.findById(id);
    }

    @GetMapping()
    public List<Produto> pesquisar(Produto filtro){
        return (service.findAll(filtro));
    }
}