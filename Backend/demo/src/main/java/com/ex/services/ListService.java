package com.ex.services;

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
        dao.delete(lists);
        return lists;
    }

    @Override
    public Lists update(Lists lists) {
        return dao.save(lists);
    }


}
