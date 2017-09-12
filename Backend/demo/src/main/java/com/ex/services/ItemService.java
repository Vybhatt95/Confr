package com.ex.services;

import com.ex.Dao.itemDao;
import com.ex.Objects.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by jeremy on 9/10/2017.
 */
@Component
public class ItemService implements Service<Item> {

    @Autowired
    itemDao dao;

    @Override
    public Item findOne(Item item) {
        return dao.findOne(item.getitemId());
    }

    @Override
    public Item insert(Item item) {
        return dao.save(item);
    }

    @Override
    public Item delete(Item item) {
        dao.delete(item);
        return item;
    }

    @Override
    public Item update(Item item) {
        return dao.save(item);
    }

    public List<Item> findByItemName(String name){

        List<Item> list = dao.findByItemName(name);
        return list;
    }
}
