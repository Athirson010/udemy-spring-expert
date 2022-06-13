package io.github.athirson010.rest.controller;


import io.github.athirson010.model.entity.Cliente;
import io.github.athirson010.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    @Autowired
    private ClienteService service;

    //@GetMapping
    //consumes defino que posso receber um objeto em formato JSON ou XML (receber)
    //produces é a forma de retorno da nossa API
    @RequestMapping(
            value = {"/hello/{nome}", "/ola/{nome}"},
            method = RequestMethod.GET)
    @ResponseBody
    public String olaCliente(@PathVariable("nome") String nomeCliente){
        return "Olá "+ nomeCliente;
    }

    @GetMapping("/{id}")
    public Cliente getById(@PathVariable() Long id){
        return service.findById(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente salvarCliente(@RequestBody Cliente cliente){
        return service.salvarCliente(cliente);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable() Long id){
        service.deletar(id);
    }

    @PutMapping("/{id}")
    public Cliente atualizarCliente(@PathVariable Long id,
                                    @RequestBody Cliente cliente){
        return service.atualizar(id, cliente);
    }

    @GetMapping()
    public List<Cliente> pesquisar(Cliente filtro){
        return (service.findAll(filtro));
    }

}
