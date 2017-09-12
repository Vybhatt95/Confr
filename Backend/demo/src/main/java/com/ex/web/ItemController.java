package com.ex.web;

import com.ex.Objects.Item;
import com.ex.services.ItemService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by jeremy on 9/11/2017.
 */
@RestController
@RequestMapping(path="/item")
public class ItemController {

    @Autowired
    ItemService service;

    @RequestMapping(path="/search",method = RequestMethod.POST,
        consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String searchForItem(@RequestBody String itemname){
        ObjectMapper mapper = new ObjectMapper();
        List<Item> list = service.findByItemName(itemname);
        String ret = null;
        try{
            ret = mapper.writeValueAsString(list);
        }catch (JsonProcessingException e){
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(path="/updateitem", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String updaateItem(@RequestBody Item i){
        return null;
    }
}
