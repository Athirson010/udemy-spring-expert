package io.github.athirson010.rest.controller;


import io.github.athirson010.rest.controller.dto.PedidoDTO;
import io.github.athirson010.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {
    @Autowired
    private PedidoService service;
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Long save (@RequestBody PedidoDTO dto){
       return service.salvar(dto).getId();
    }
}
