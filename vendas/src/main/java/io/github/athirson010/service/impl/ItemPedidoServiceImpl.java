package io.github.athirson010.service.impl;

import io.github.athirson010.model.entity.ItemPedido;
import io.github.athirson010.repository.ItemPedidoRepository;
import io.github.athirson010.service.ItemPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemPedidoServiceImpl implements ItemPedidoService {
    @Autowired
    private ItemPedidoRepository repository;

    @Override
    public void saveAll(List<ItemPedido> itemsPedido) {
        repository.saveAll(itemsPedido);
    }
}
