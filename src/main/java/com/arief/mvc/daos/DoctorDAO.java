package com.arief.mvc.daos;

import com.arief.mvc.entity.Doctor;

import java.util.List;

public interface DoctorDAO {
    void save(Doctor d);
    List<Doctor> getAll();
    Doctor getOne(String doctorId);
}
