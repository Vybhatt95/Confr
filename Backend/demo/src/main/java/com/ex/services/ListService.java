package com.ex.services;

import com.ex.Dao.itemDao;
import com.ex.Dao.listsDao;
import com.ex.Objects.Item;
import com.ex.Objects.Lists;
import com.ex.Objects.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jeremy on 9/10/2017.
 */
@Component
public class ListService implements Service<Lists> {

    @Autowired
    listsDao dao;

    @Autowired
    itemDao iDao;

    @Override
    public Lists findOne(Lists lists) {
        return dao.findOne(lists.getlistId());
    }

    @Override
    public Lists insert(Lists lists) {
        return dao.save(lists);
    }

    @Override
    public Lists delete(Lists lists) {
        Lists ret = findOne(lists);
        dao.delete(lists);
        return ret;
    }

    @Override
    public Lists update(Lists lists) {
        return dao.save(lists);
    }

    public List<Item> compareLists(Lists lists){
        List<Item> better = new ArrayList<>();
        for(Item i: lists.getItems()){
            List<Item> samename = iDao.findByItemName(i.getitemName());
            for(Item j: samename){
                if(j.getitemPrice() < i.getitemPrice()){
                    better.add(j);
                }
            }
        }

        return better;

    }

    public List<Lists> findAllLists(){
        List<Lists> list = dao.findAll();
        return list;
    }

    public double listAverage(List<Lists> list){
        double sum = 0;

        for(Lists l : list){
            sum += l.getlistTotal();
        }

        return sum/(double)list.size();
    }

    public double allAverage(){
        List<Lists> list = dao.findAll();
        double sum = 0;
        for(Lists l: list){
            sum += l.getlistTotal();
        }

        return sum/(double)list.size();
    }
}
