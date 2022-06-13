package io.github.athirson010.service.impl;

import io.github.athirson010.model.entity.ItemPedido;
import io.github.athirson010.model.entity.Pedido;
import io.github.athirson010.model.entity.Produto;
import io.github.athirson010.repository.PedidoRepository;
import io.github.athirson010.rest.controller.dto.ItemPedidoDTO;
import io.github.athirson010.rest.controller.dto.PedidoDTO;
import io.github.athirson010.service.ClienteService;
import io.github.athirson010.service.ItemPedidoService;
import io.github.athirson010.service.PedidoService;
import io.github.athirson010.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private PedidoRepository repository;
    @Autowired
    private ClienteService clienteService;
    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private ItemPedidoService itemPedidoService;
    @Override
    @Transactional
    public Pedido salvar(PedidoDTO dto) {
        Pedido pedido = new Pedido();
        pedido.setTotal(dto.getTotal());
        pedido.setDataPedido(LocalDate.now());
        pedido.setCliente(clienteService.findById(dto.getCliente()));

        List<ItemPedido> itemsPedido = converterItems(pedido, dto.getItems());
        repository.save(pedido);
        itemPedidoService.saveAll(itemsPedido);
        pedido.setItens(itemsPedido);

        return pedido;
    }

    public List<ItemPedido> converterItems(Pedido pedido, List<ItemPedidoDTO> items){
        if (items.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Não é possivel realizar pedidos sem items.");
        }
        return items.stream().map(itemPedidoDTO -> {
            Produto produto = produtoService.findById(itemPedidoDTO.getProduto());
            ItemPedido itemPedido = new ItemPedido();
            itemPedido.setQuantidade(itemPedidoDTO.getQuantidade());
            itemPedido.setPedido(pedido);
            itemPedido.setProduto(produto);
            return itemPedido;
        } ).collect(Collectors.toList());
    }
}
