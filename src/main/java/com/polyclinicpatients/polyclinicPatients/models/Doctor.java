package com.polyclinicpatients.polyclinicPatients.models;

import javax.persistence.*;

@Entity
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_doctor;
    private String fio;
    private String spec;
    //TODO: сделать связь с моделью Visit 1:N

    public Long getId_doctor() {
        return id_doctor;
    }

    public void setId_doctor(Long id_doctor) {
        this.id_doctor = id_doctor;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public Doctor() {
    }

    public Doctor(String fio, String spec) {
        this.fio = fio;
        this.spec = spec;
    }
}
