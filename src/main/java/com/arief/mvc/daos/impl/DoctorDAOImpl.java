package com.arief.mvc.daos.impl;

import com.arief.mvc.daos.DoctorDAO;
import com.arief.mvc.entity.Doctor;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.print.Doc;
import java.util.List;

@Repository
public class DoctorDAOImpl implements DoctorDAO{


    @Autowired
    private SessionFactory sessionFactory;

    public void save(Doctor d) {
        sessionFactory
                .getCurrentSession()
                .save(d);
    }

    public List<Doctor> getAll() {
        return sessionFactory
                .getCurrentSession()
                .createQuery("from Doctor").list();
    }

    public Doctor getOne(String doctorId) {
        return sessionFactory
                .getCurrentSession()
                .get(Doctor.class,doctorId);
    }
}
