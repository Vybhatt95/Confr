package com.ex.services;

import com.ex.Dao.store_FrontDao;
import com.ex.Objects.Store_Front;
import org.apache.catalina.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by jeremy on 9/13/2017.
 */
@Component
public class StoreService implements Service<Store_Front> {

    @Autowired
    store_FrontDao dao;

    @Override
    public Store_Front findOne(Store_Front store_front) {
        return dao.findOne(store_front.getstoreId());
    }

    @Override
    public Store_Front insert(Store_Front store_front) {
        dao.save(store_front);
        return store_front;
    }

    @Override
    public Store_Front delete(Store_Front store_front) {
        dao.delete(store_front);
        return store_front;
    }

    @Override
    public Store_Front update(Store_Front store_front) {
        dao.save(store_front);
        return store_front;
    }

    public List<Store_Front> findAll(){
        return dao.findAll();
    }

}
