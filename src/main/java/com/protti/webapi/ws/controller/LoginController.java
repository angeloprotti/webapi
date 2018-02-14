package com.protti.webapi.ws.controller;


import com.protti.webapi.ws.model.Users;
import com.protti.webapi.ws.service.UsersService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;


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
    public LoginResponse auth(@RequestBody Users user) throws ServletException {

        if(user.getUsername() == null || user.getPassword() == null){
            throw new SecurityException("Username and password required");
        }

        Users authUser = usersService.searchUser(user.getUsername());

        if(authUser == null || !authUser.getPassword().equals(user.getPassword())){
            System.out.println(authUser.getPassword());
            System.out.println(user.getPassword());
            throw new ServletException("Username or password invalid.");
        }


        //TOKEN
        //Using setExpiration to determinate when it expire.
        String token = Jwts.builder().setSubject(authUser.getUsername()).signWith(SignatureAlgorithm.HS512,"states").compact();

        return new LoginResponse(token);

        //return new ResponseEntity<Users>(authUser, HttpStatus.OK);

    }

    public class LoginResponse {

        public String token;

        public LoginResponse(String token){
            this.token = token;
        }

    }


}
