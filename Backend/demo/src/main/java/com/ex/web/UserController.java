package com.ex.web;

import com.ex.Objects.User;
import com.ex.services.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

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
    public String loginUser(@RequestBody User user, HttpSession session){
        ObjectMapper mapper = new ObjectMapper();
        User u = service.loginUser(user.getuserName(),user.getPassWord());
        String ret = null;
        if(u != null){
            session.setAttribute("user",u);
        }

        try{
            ret = mapper.writeValueAsString(u);
        } catch (JsonProcessingException e){
            e.printStackTrace();
        }

        return ret;

    }

    @RequestMapping(path="/password", method={RequestMethod.GET, RequestMethod.POST}
            , consumes="*/*", produces= MediaType.APPLICATION_JSON_VALUE)
    public String updatePassword(@RequestBody User user, HttpSession session){
        ObjectMapper mapper = new ObjectMapper();
        User u = (User)session.getAttribute("user");
        String ret = null;
        u.setPassWord(user.getPassWord());
        u = service.update(u);
        try{
            ret = mapper.writeValueAsString(u);
        } catch (JsonProcessingException e){
            e.printStackTrace();
        }

        return ret;
    }



}
