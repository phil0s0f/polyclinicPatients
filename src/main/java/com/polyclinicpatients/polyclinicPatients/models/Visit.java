package com.polyclinicpatients.polyclinicPatients.models;

import javax.persistence.*;

@Entity
@Table(name = "visit")
public class Visit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_visit;
    //private Long id_patient;
    //private Long id_doctor;
    private String date_visit;
    private String time_visit;
    //@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @ManyToOne(fetch = FetchType.EAGER)
    private Patient patient;
    //@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @ManyToOne(fetch = FetchType.EAGER)
    private Doctor doctor;
    public Visit() {
    }

    public Visit(String date_visit, String time_visit, Patient patient, Doctor doctor) {
        this.date_visit = date_visit;
        this.time_visit = time_visit;
        this.patient = patient;
        this.doctor = doctor;
    }

    public String getTime_visit() {
        return time_visit;
    }

    public void setTime_visit(String time_visit) {
        this.time_visit = time_visit;
    }

    //TODO: добавить конструкторы
    //TODO: сделать связь с моделями Patient, Doctor N:1
    public Long getId_visit() {
        return id_visit;
    }
    public void setId_visit(Long id_visit) {
        this.id_visit = id_visit;
    }

    public String getDate_visit() {
        return date_visit;
    }
    public void setDate_visit(String date_visit) {
        this.date_visit = date_visit;
    }
    public Patient getPatient() {
        return patient;
    }
    public void setPatient(Patient patient) {
        this.patient = patient;
    }
    public Doctor getDoctor() {
        return doctor;
    }
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}
