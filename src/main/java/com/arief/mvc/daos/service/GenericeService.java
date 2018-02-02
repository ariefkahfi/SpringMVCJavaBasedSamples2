package com.arief.mvc.daos.service;

import java.io.Serializable;
import java.util.List;

public interface GenericeService<T , ID extends Serializable> {
    void save(T t);
    List<T> getAll();
    T getOne(ID id);
    void delete(T t);
}
