package com.arief.mvc.daos;

import com.arief.mvc.entity.Doctor;

import java.util.List;

public interface DoctorDAO {
    void save(Doctor d);
    List<Doctor> getAll();
    void delete(Doctor d);
    Doctor getOne(String doctorId);
}
