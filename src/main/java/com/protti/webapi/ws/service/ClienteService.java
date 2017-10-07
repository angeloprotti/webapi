package com.protti.webapi.ws.service;

import com.protti.webapi.ws.model.Cliente;
import com.protti.webapi.ws.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;


    public Cliente cadastrar(Cliente cliente){

        return clienteRepository.save(cliente);
    }


    public Collection<Cliente> buscarTodos(){

        return clienteRepository.findAll();
    }


    public void excluir(Cliente cliente){

        clienteRepository.delete(cliente);
    }

    public Cliente buscaPorId(Integer id){

        return clienteRepository.findOne(id);
    }

    public Cliente alterar(Cliente cliente){

        return clienteRepository.save(cliente);
    }



}
