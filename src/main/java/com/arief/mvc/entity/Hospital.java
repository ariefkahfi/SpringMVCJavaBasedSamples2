package com.arief.mvc.entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "hospital")
public class Hospital {
    @Id
    @Column(name = "hospital_id")
    private String hospitalId;

    @Column(name = "hospital_name")
    private String hospitalName;

    @Column(name = "hospital_address")
    private String hospitalAddress;

    @ManyToMany(mappedBy = "hospitalList")
    private List<Doctor> doctorList;

    @OneToOne(mappedBy = "hospital")
    private HospitalDirector hospitalDirector;


    public HospitalDirector getHospitalDirector() {
        return hospitalDirector;
    }

    public void setHospitalDirector(HospitalDirector hospitalDirector) {
        this.hospitalDirector = hospitalDirector;
    }

    public String getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(String hospitalId) {
        this.hospitalId = hospitalId;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getHospitalAddress() {
        return hospitalAddress;
    }

    public void setHospitalAddress(String hospitalAddress) {
        this.hospitalAddress = hospitalAddress;
    }

    public List<Doctor> getDoctorList() {
        return doctorList;
    }

    public void setDoctorList(List<Doctor> doctorList) {
        this.doctorList = doctorList;
    }

    @Override
    public String toString() {
        return "Hospital{" +
                "hospitalId='" + hospitalId + '\'' +
                ", hospitalName='" + hospitalName + '\'' +
                ", hospitalAddress='" + hospitalAddress + '\'' +
                '}';
    }
}
