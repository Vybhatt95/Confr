package com.ex.web;

import com.ex.Objects.User;
import com.ex.services.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Created by jeremy on 9/8/2017.
 */
@RestController
@RequestMapping(path="/users")
public class UserController {


    @Autowired
    UserService service;


    @RequestMapping(path="/register", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String registerUser(@RequestBody User user){
        ObjectMapper mapper = new ObjectMapper();
        service.insert(user);
        String ret = null;

        try{
            ret = mapper.writeValueAsString(user);
        }catch (JsonProcessingException e){
            e.printStackTrace();
        }
        return ret;
    }

    @RequestMapping(path="/user/{id}", method={RequestMethod.GET, RequestMethod.POST}
            , consumes="*/*", produces= MediaType.APPLICATION_JSON_VALUE)
    public String getOne(@PathVariable Integer id){
        ObjectMapper mapper = new ObjectMapper();
        User u = service.findById(id);
        String ret = null;

        try{
            ret = mapper.writeValueAsString(u);
        }catch (JsonProcessingException e){
            e.printStackTrace();
        }
        return ret;
    }

    @RequestMapping(path="/login", method={RequestMethod.GET, RequestMethod.POST}
            , consumes="*/*", produces= MediaType.APPLICATION_JSON_VALUE)
    public String loginUser(@RequestBody String username, @RequestBody String password){
        ObjectMapper mapper = new ObjectMapper();
        String str = null;
        return str;

    }
}
