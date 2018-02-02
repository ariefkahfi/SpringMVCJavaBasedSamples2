package com.arief.mvc.daos;

import com.arief.mvc.entity.Hospital;

import java.util.List;

public interface HospitalDAO {
    void save(Hospital h);
    List<Hospital> getAll();
    Hospital getOne(String hospitalId);
}
