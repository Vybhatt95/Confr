package com.ex.web;

import com.ex.Objects.Item;
import com.ex.Objects.Lists;
import com.ex.Objects.User;
import com.ex.services.ItemService;
import com.ex.services.ListService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by jeremy on 9/10/2017.
 */
@RestController
@RequestMapping(path="/lists")
public class ListsController {

    @Autowired
    ListService lService;

//    @Autowired
//    ItemService iService;

//    @RequestMapping(path="/",method = RequestMethod.POST,
//            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//    public String getAllLists(@RequestBody Lists li, HttpSession session){
//        ObjectMapper mapper = new ObjectMapper();
//        User u = (User)session.getAttribute("user");
//        String ret = null;
//        //List<Lists> l = lService.findAllById(u.getuserId());
//        List<Lists> l = lService.findAllById(u);
//        try{
//            ret = mapper.writeValueAsString(l);
//        }catch (JsonProcessingException e){
//            e.printStackTrace();
//        }
//        return ret;
//    }

    @RequestMapping(path="/new", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE )
    public String makeNewList(@RequestBody Lists li, HttpSession session){

        ObjectMapper mapper = new ObjectMapper();
        User u = (User)session.getAttribute("user");
        String ret = null;
        Lists list = new Lists();
        list.setlistName(li.getlistName());
        list.setUser(u);
        //list.setuserId(4);
        lService.insert(list);
        try{
            ret = mapper.writeValueAsString(list);
        }catch (JsonProcessingException e){
            e.printStackTrace();
        }

        return ret;

    }

    @RequestMapping(path="/additem", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE )
    public String addItemToList(@RequestBody Item i,@RequestBody Lists l, HttpSession session){
        ObjectMapper mapper = new ObjectMapper();
        User u = (User)session.getAttribute("user");
        String ret = null;
        List<Item> itms = l.getItems();
        itms.add(i);
        l.setItems(itms);
        lService.update(l);
        try{
            ret = mapper.writeValueAsString(l);
        }catch (JsonProcessingException e){
            e.printStackTrace();
        }

        return ret;
    }

    @RequestMapping(path="/compare", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE )
    public String compareLists(@RequestBody List l){
        return null;
    }


}
