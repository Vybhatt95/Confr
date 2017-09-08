package com.ex.services;

/**
 * Created by jeremy on 9/8/2017.
 */
public interface Service<T> {
    T findOne(T t);
    T insert(T t);
    T delete(T t);
    T update(T t);
}
