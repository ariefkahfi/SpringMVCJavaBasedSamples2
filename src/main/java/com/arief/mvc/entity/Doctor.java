package com.arief.mvc.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "doctor")
public class Doctor {

    @Id
    @Column(name = "doctor_id")
    private String doctorId;

    @Column(name = "doctor_name")
    private String doctorName;

    @ManyToMany
    @JoinTable(name = "hospital_doctor",
            joinColumns = {@JoinColumn(name = "hospital_id")},
            inverseJoinColumns = {@JoinColumn(name = "doctor_id")}
    )
    private List<Hospital> hospitalList;


    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public List<Hospital> getHospitalList() {
        return hospitalList;
    }

    public void setHospitalList(List<Hospital> hospitalList) {
        this.hospitalList = hospitalList;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "doctorId='" + doctorId + '\'' +
                ", doctorName='" + doctorName + '\'' +
                '}';
    }
}
