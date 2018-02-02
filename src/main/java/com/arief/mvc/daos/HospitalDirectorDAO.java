package com.arief.mvc.daos;

import com.arief.mvc.entity.HospitalDirector;

import java.util.List;

public interface HospitalDirectorDAO {
    void save(HospitalDirector hd);
    List<HospitalDirector> getAll();
    HospitalDirector getOne(int directorId);
    void delete(HospitalDirector hd);
}
