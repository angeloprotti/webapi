package com.protti.webapi.ws.controller;

import com.protti.webapi.ws.model.Cliente;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


@RestController
public class ClienteController {


    Map<Integer,Cliente> clientes;
    Integer proximoId = 1;


    private Cliente cadastrar(Cliente cliente){

        if(clientes==null){
            clientes = new HashMap<>();
        }

        cliente.setId(proximoId);
        proximoId++;

        clientes.put(cliente.getId(),cliente);

        return cliente;

    }


    private Collection<Cliente> buscarTodos(){
        return clientes.values();
    }


    public void excluir(Cliente cliente){
        clientes.remove(cliente.getId());
    }

    private Cliente buscaPorId(Integer id){
        return clientes.get(id);
    }

    private Cliente alterar(Cliente cliente){
        clientes.put(cliente.getId(),cliente);
        return cliente;
    }


    @RequestMapping(method=RequestMethod.POST, value="/clientes",
            consumes= MediaType.APPLICATION_JSON_VALUE,
            produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cliente> cadastrarCliente(@RequestBody Cliente cliente){

        Cliente clienteCadastrado = cadastrar(cliente);

        return new ResponseEntity<>(clienteCadastrado, HttpStatus.CREATED);
    }

    //SEARCH CLIENTES
    @RequestMapping(method=RequestMethod.GET, value="/clientes", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<Cliente>> buscarTodosCliente(){

        Collection<Cliente> clientesBuscados = buscarTodos();

        return new ResponseEntity<>(clientesBuscados, HttpStatus.OK);
    }

    //DELETE CLIENTES
    @RequestMapping(method=RequestMethod.DELETE, value="/clientes/{id}")
    public ResponseEntity<Collection<Cliente>> excluirCliente(@PathVariable Integer id){

        Cliente clienteEncontrado = buscaPorId(id);

        if(clienteEncontrado==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        excluir(clienteEncontrado);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //UPDATE CLIENTE
    @RequestMapping(method=RequestMethod.PUT, value="/clientes",
            consumes= MediaType.APPLICATION_JSON_VALUE,
            produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cliente> alterarCliente(@RequestBody Cliente cliente){

        Cliente clienteAlterado = alterar(cliente);

        return new ResponseEntity<>(clienteAlterado, HttpStatus.OK);
    }



}
