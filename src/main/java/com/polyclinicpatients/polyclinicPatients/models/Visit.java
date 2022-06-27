package com.polyclinicpatients.polyclinicPatients.models;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
public class Visit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_visit;
    private Long id_patient;
    //private Long id_doctor;
    //TODO: добавить конструкторы
    //TODO: сделать связь с моделями Patient, Doctor N:1
    public Long getId_visit() {
        return id_visit;
    }

    public void setId_visit(Long id_visit) {
        this.id_visit = id_visit;
    }

    public Long getId_patient() {
        return id_patient;
    }

    public void setId_patient(Long id_patient) {
        this.id_patient = id_patient;
    }
/*
    public Long getId_doctor() {
        return id_doctor;
    }

    public void setId_doctor(Long id_doctor) {
        this.id_doctor = id_doctor;
    }

 */

    public Date getDate_visit() {
        return date_visit;
    }

    public void setDate_visit(Date date_visit) {
        this.date_visit = date_visit;
    }

    private Date date_visit;
    /*@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "id_patient", nullable = false)
    private Patient patient;

    public Patient getPatient() {
        return patient;
    }
    public void setPatient(Patient patient) {
        this.patient = patient;
    }
    */



}
