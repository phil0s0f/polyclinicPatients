package com.polyclinicpatients.polyclinicPatients.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_patient;
    private String fio;
    private String male;
    private Date birth_date;
    private String adres;
    private String polis;

    public Patient() {
    }

    public Patient(String fio, String male, Date birth_date, String adres, String polis) {
        this.fio = fio;
        this.male = male;
        this.birth_date = birth_date;
        this.adres = adres;
        this.polis = polis;
    }

    //TODO: сделать связь с моделью Visit 1:N
    public Long getId_patient() {
        return id_patient;
    }

    public void setId_patient(Long id_patient) {
        this.id_patient = id_patient;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getMale() {
        return male;
    }

    public void setMale(String male) {
        this.male = male;
    }

    public Date getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getPolis() {
        return polis;
    }

    public void setPolis(String polis) {
        this.polis = polis;
    }
}
