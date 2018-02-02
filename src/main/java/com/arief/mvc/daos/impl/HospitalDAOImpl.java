package com.arief.mvc.daos.impl;

import com.arief.mvc.daos.HospitalDAO;
import com.arief.mvc.entity.Hospital;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HospitalDAOImpl implements HospitalDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void save(Hospital h) {
        sessionFactory
                .getCurrentSession()
                .save(h);
    }

    public List<Hospital> getAll() {
        return sessionFactory
                .getCurrentSession()
                .createQuery("from Hospital").list();
    }

    public Hospital getOne(String hospitalId) {
        return sessionFactory
                .getCurrentSession()
                .get(Hospital.class,hospitalId);
    }
}
