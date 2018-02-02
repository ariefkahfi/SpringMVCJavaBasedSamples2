package com.arief.mvc.daos.impl;

import com.arief.mvc.daos.HospitalDirectorDAO;
import com.arief.mvc.entity.HospitalDirector;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HospitalDirectorDAOImpl implements HospitalDirectorDAO{

    @Autowired
    private SessionFactory sessionFactory;

    public void save(HospitalDirector hd) {
        sessionFactory
                .getCurrentSession()
                .save(hd);
    }

    public List<HospitalDirector> getAll() {
        return sessionFactory
                .getCurrentSession()
                .createQuery("from HospitalDirector").list();
    }

    public HospitalDirector getOne(int directorId) {
        return sessionFactory
                .getCurrentSession()
                .get(HospitalDirector.class,directorId);
    }

    public void delete(HospitalDirector hd) {
        sessionFactory
                .getCurrentSession()
                .delete(hd);
    }
}
