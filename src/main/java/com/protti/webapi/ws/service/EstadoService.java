package com.protti.webapi.ws.service;


import com.protti.webapi.ws.model.Estado;
import com.protti.webapi.ws.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class EstadoService {

    @Autowired
    EstadoRepository estadoRepository;


    public Estado cadastrar(Estado estado){
        return estadoRepository.save(estado);
    }



    public Collection<Estado> buscarTodos(){

        return estadoRepository.findAll();
    }


    public void excluir(Estado cliente){

        estadoRepository.delete(cliente);
    }

    public Estado buscaPorId(Integer id){

        return estadoRepository.findOne(id);
    }

    public Estado alterar(Estado cliente){

        return estadoRepository.save(cliente);
    }






}
