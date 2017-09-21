package com.ex.web;

import com.ex.Objects.Item;
import com.ex.Objects.Lists;
import com.ex.Objects.User;
import com.ex.services.ItemService;
import com.ex.services.ListService;
import com.ex.services.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by jeremy on 9/10/2017.
 */
@RestController
@RequestMapping(path="/lists")
public class ListsController {

    @Autowired
    ListService lService;

    @Autowired
    UserService userService;

    @Autowired
    ItemService iService;

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
        //User u = userService.findById(7);
        String ret = null;
        Lists list = new Lists();

        list.setlistName(li.getlistName());
        //list.setUser(u);
        //list.setUserId(4);

        list.setUserId(u.getuserId());
        list.setItems(li.getItems());
        list.setlistTotal(li.getlistTotal());
        lService.insert(list);
        List<Lists> ul = u.getLists();
        ul.add(list);
        u.setLists(ul);
        session.setAttribute("user",u);
        try{
            ret = mapper.writeValueAsString(list);
        }catch (JsonProcessingException e){
            e.printStackTrace();
        }

        return ret;

    }


    @RequestMapping(path="/additem", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE )
    public String addItemToList(@RequestBody String json, HttpSession session){

        ObjectMapper mapper = new ObjectMapper();
        JsonNode root;
        Lists l = null;
        Item i = null;
        try {
            root = mapper.readTree(json);
            JsonNode lnode = root.path("list");
            JsonNode inode = root.path("item");
            l = mapper.treeToValue(lnode,Lists.class);
            l = lService.findOne(l);
            i = mapper.treeToValue(inode,Item.class);
            i = iService.findOne(i);
        }catch (IOException e){
            e.printStackTrace();
        }
//        Lists l = root.path("list");
//        Item i = json.get(1);
        System.out.println(i);
        User u = (User)session.getAttribute("user");
        String ret = null;
        List<Item> itms = l.getItems();
        itms.add(i);
        double price = i.getitemPrice();
        double total = l.getlistTotal();
        total += price;
        l.setItems(itms);
        l.setlistTotal(total);
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

    @RequestMapping(path="/remove", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE )
    public String removeList(@RequestBody Lists l){
        ObjectMapper mapper = new ObjectMapper();
        Lists list = lService.delete(l);
        String ret = null;
        try{
            ret = mapper.writeValueAsString(list);
        }catch(JsonProcessingException e){
            e.printStackTrace();
        }
        return ret;
    }

    @RequestMapping(path="/all", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE )
    public String getAllLists(){
        ObjectMapper mapper = new ObjectMapper();
        List<Lists> list = lService.findAllLists();
        String ret = null;
        try{
            ret = mapper.writeValueAsString(list);
        }catch (JsonProcessingException e){
            e.printStackTrace();
        }

        return ret;
    }

    @RequestMapping(path="/average", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE )
    public String getAverageGraphData(HttpSession session){
        ObjectMapper mapper = new ObjectMapper();
        User u = (User)session.getAttribute("user");
        //User u = userService.findById(1);
        Double ua = lService.listAverage(u.getLists());
        Double avgAll = lService.allAverage();

        ArrayNode arrayNode = mapper.createArrayNode();
        ObjectNode objectNode = mapper.createObjectNode();
        objectNode.put("label","Your Average");
        objectNode.put("value",ua.toString());

        ObjectNode objectNode1 = mapper.createObjectNode();
        objectNode1.put("label","Average of All Lists");
        objectNode1.put("value",avgAll.toString());

        arrayNode.add(objectNode);
        arrayNode.add(objectNode1);
        String ret = null;
        try{
            ret = mapper.writeValueAsString(arrayNode);
        }catch (JsonProcessingException e){
            e.printStackTrace();
        }
        return ret;
    }

}
