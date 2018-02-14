package com.protti.webapi.ws.controller;


import com.protti.webapi.ws.model.Users;
import com.protti.webapi.ws.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/*
* Class about system login
* made by Angelo Protti
* */

//RestController used to know it's gonna be a Rest Request(Spring)
@RestController
public class LoginController {

    @Autowired
    private UsersService usersService;


    @RequestMapping(value="/login", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public ResponseEntity<Users> auth(@RequestBody Users user){
//        System.out.println("Server Success " + user.getUsername() + " " + user.getPassword());
        Users authUser = usersService.searchUser(user.getUsername());

        return new ResponseEntity<Users>(authUser, HttpStatus.OK);

    }


}
