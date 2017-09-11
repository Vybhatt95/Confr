package com.p2.data;


import java.io.Serializable;

public interface Dao<T> {
    T findOne(Serializable id);
}
