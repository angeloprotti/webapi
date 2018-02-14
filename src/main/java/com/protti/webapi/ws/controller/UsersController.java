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

@RestController
public class UsersController {

    @Autowired
    private UsersService usersService;

    @RequestMapping(value = "/users/save", method = RequestMethod.POST, consumes= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Users> registerUsers(@RequestBody Users user){

            Users userSaved = usersService.save(user);

            return new ResponseEntity<Users>(userSaved, HttpStatus.OK);
    }

}
