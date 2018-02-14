package com.protti.webapi.ws.service;


import com.protti.webapi.ws.model.Users;
import com.protti.webapi.ws.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;


    public Users save(Users user) {
        return usersRepository.save(user);
    }

    public Users searchUser(String username) {
        return usersRepository.searchUser(username);
    }
}
