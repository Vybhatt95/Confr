package com.ex.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by August Duet on 9/7/2017.
 */
@RestController
public class TestController {

    @RequestMapping(path="/test",method=RequestMethod.GET)
    public String getMessage(){
        return "<h1>Hello, World!</h1>";
    }
}
