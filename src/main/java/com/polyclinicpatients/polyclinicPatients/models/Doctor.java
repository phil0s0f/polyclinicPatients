package com.polyclinicpatients.polyclinicPatients.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "doctor")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idd;
    private String fio;
    private String spec;
    /*@OneToMany(fetch = FetchType.EAGER,mappedBy = "patient")
    private Set<Visit> visits;
     */
    public Doctor() {
    }
    public Doctor(String fio, String spec) {
        this.fio = fio;
        this.spec = spec;
    }
    //TODO: сделать связь с моделью Visit 1:N (возможно не нужна)
    public Long getIdd() {
        return idd;
    }
    public void setIdd(Long idd) {
        this.idd = idd;
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
}
