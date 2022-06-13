package io.github.athirson010.service;

import io.github.athirson010.model.entity.Produto;

import java.util.List;
public interface ProdutoService {

    List<Produto> findAll(Produto filtro);

    Produto findById(Long id);

    void deletar(Long id);

    Produto atualizar(Long id, Produto produto);

    Produto save(Produto produto);
}
