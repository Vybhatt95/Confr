package com.ex.web;

import com.ex.Objects.Item;
import com.ex.Objects.Store_Front;
import com.ex.services.ItemService;
import com.ex.services.StoreService;
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

    @Autowired
    StoreService store_service;

    @RequestMapping(path="/search",method = RequestMethod.POST,
        consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String searchForItem(@RequestBody Item i){
        ObjectMapper mapper = new ObjectMapper();
        List<Item> list = service.findByItemName(i.getitemName());
        String ret = null;
        try{
            ret = mapper.writeValueAsString(list);
        }catch (JsonProcessingException e){
            e.printStackTrace();
        }
        return ret;
    }

    @RequestMapping(path="/all",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String getAllItems(){
        ObjectMapper mapper = new ObjectMapper();
        List<Item> list = service.findAll();
        String ret = null;

        try{
            ret = mapper.writeValueAsString(list);
        }catch (JsonProcessingException e){
            e.printStackTrace();
        }

        return ret;
    }

    @RequestMapping(path="/updateitem", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String updaateItem(@RequestBody Item i){
        ObjectMapper mapper = new ObjectMapper();
        Item j = service.findOne(i);
        j.setitemPrice(i.getitemPrice());
        service.update(j);
        String ret = null;
        try{
            ret = mapper.writeValueAsString(j);
        }catch (JsonProcessingException e){
            e.printStackTrace();
        }
        return ret;
    }

    @RequestMapping(path="/stores", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String getStores(){
        ObjectMapper mapper = new ObjectMapper();
        String ret = null;
        try{
            ret = mapper.writeValueAsString(store_service.findAll());
        }catch (JsonProcessingException e){
            e.printStackTrace();
        }

        return ret;
    }

    @RequestMapping(path="/createstore", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void createStore(@RequestBody Store_Front sf){
        ObjectMapper mapper = new ObjectMapper();
        store_service.insert(sf);

    }
}
