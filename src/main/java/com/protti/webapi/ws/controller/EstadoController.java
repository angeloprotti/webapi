package com.protti.webapi.ws.controller;


import com.protti.webapi.ws.model.Estado;
import com.protti.webapi.ws.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class EstadoController {


    @Autowired
    EstadoService estadoService;


    @RequestMapping(method= RequestMethod.POST, value="/estados",
            consumes= MediaType.APPLICATION_JSON_VALUE,
            produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Estado> cadastrarCliente(@RequestBody Estado estado){

        Estado estadoCadastrado = estadoService.cadastrar(estado);

        return new ResponseEntity<>(estadoCadastrado, HttpStatus.CREATED);
    }

    //SEARCH ESTADOS
    @RequestMapping(method=RequestMethod.GET, value="/estados", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<Estado>> buscarTodosEstados(){

        Collection<Estado> estadosBuscados = estadoService.buscarTodos();

        return new ResponseEntity<>(estadosBuscados, HttpStatus.OK);
    }

    //SEARCH ESTADO DETAIL
    @RequestMapping(method=RequestMethod.GET, value="/estados/{id}", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Estado> buscarCliente(@PathVariable Integer id){

        Estado estadoEncontrado = estadoService.buscaPorId(id);

        if(estadoEncontrado==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(estadoEncontrado, HttpStatus.OK);
    }


    //DELETE ESTADO
    @RequestMapping(method=RequestMethod.DELETE, value="/estados/{id}")
    public ResponseEntity<Collection<Estado>> excluirEstado(@PathVariable Integer id){

        Estado estadoEncontrado = estadoService.buscaPorId(id);

        if(estadoEncontrado==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        estadoService.excluir(estadoEncontrado);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //UPDATE CLIENTE
    @RequestMapping(method=RequestMethod.PUT, value="/estado",
            consumes= MediaType.APPLICATION_JSON_VALUE,
            produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Estado> alterarEstado(@RequestBody Estado estado){

        Estado estadoAlterado = estadoService.alterar(estado);

        return new ResponseEntity<>(estadoAlterado, HttpStatus.OK);
    }





}
