package io.github.athirson010.service;

import io.github.athirson010.model.entity.Pedido;
import io.github.athirson010.model.entity.Produto;
import io.github.athirson010.rest.controller.dto.PedidoDTO;

public interface PedidoService {
    Pedido salvar(PedidoDTO dto);
}
