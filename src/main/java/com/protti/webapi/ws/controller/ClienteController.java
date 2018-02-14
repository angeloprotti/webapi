package com.protti.webapi.ws.controller;

import com.protti.webapi.ws.model.Cliente;
import com.protti.webapi.ws.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/auth")
public class ClienteController {

    @Autowired
    ClienteService clienteService;


    @RequestMapping(method=RequestMethod.POST, value="/clientes",
            consumes= MediaType.APPLICATION_JSON_VALUE,
            produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cliente> cadastrarCliente(@RequestBody Cliente cliente){

        Cliente clienteCadastrado = clienteService.cadastrar(cliente);

        return new ResponseEntity<>(clienteCadastrado, HttpStatus.CREATED);
    }

    //SEARCH CLIENTES
    @RequestMapping(method=RequestMethod.GET, value="/clientes", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<Cliente>> buscarTodosClientes(){

        Collection<Cliente> clientesBuscados = clienteService.buscarTodos();

        return new ResponseEntity<>(clientesBuscados, HttpStatus.OK);
    }

    //SEARCH CLIENTE DETAIL
    @RequestMapping(method=RequestMethod.GET, value="/clientes/{id}", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cliente> buscarCliente(@PathVariable Integer id){

        Cliente clienteEncontrado = clienteService.buscaPorId(id);

        if(clienteEncontrado==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(clienteEncontrado, HttpStatus.OK);
    }


    //DELETE CLIENTES
    @RequestMapping(method=RequestMethod.DELETE, value="/clientes/{id}")
    public ResponseEntity<Collection<Cliente>> excluirCliente(@PathVariable Integer id){

        Cliente clienteEncontrado = clienteService.buscaPorId(id);

        if(clienteEncontrado==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        clienteService.excluir(clienteEncontrado);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //UPDATE CLIENTE
    @RequestMapping(method=RequestMethod.PUT, value="/clientes",
            consumes= MediaType.APPLICATION_JSON_VALUE,
            produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cliente> alterarCliente(@RequestBody Cliente cliente){

        Cliente clienteAlterado = clienteService.alterar(cliente);

        return new ResponseEntity<>(clienteAlterado, HttpStatus.OK);
    }



}
