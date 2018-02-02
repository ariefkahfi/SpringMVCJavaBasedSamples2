package com.arief.mvc.entity;

import javax.persistence.*;

@Entity
@Table(name = "hospital_director")
public class HospitalDirector {

    @Id
    @Column(name = "director_id")
    @GeneratedValue
    private int directorId;

    @Column(name = "director_name")
    private String directorName;


    @OneToOne
    @JoinColumn(name = "hospital_id",unique = true)
    private Hospital hospital;

    @Override
    public String toString() {
        return "HospitalDirector{" +
                "directorId=" + directorId +
                ", directorName='" + directorName + '\'' +
                '}';
    }

    public int getDirectorId() {
        return directorId;
    }

    public void setDirectorId(int directorId) {
        this.directorId = directorId;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }
}
