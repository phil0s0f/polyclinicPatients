package com.polyclinicpatients.polyclinicPatients.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idp;
    private String fio;
    private String male;
    //private Date birth_date;
    private String birth_date;
    private String adres;
    private String polis;
    /*@OneToMany(fetch = FetchType.EAGER,mappedBy = "patient")
    private Set<Visit> visits;
     */
    public Patient() {
    }
    public Patient(String fio, String male, String birth_date, String adres, String polis) {
        this.fio = fio;
        this.male = male;
        this.birth_date = birth_date;
        this.adres = adres;
        this.polis = polis;
    }
    //TODO: сделать связь с моделью Visit 1:N
    public Long getIdp() {
        return idp;
    }
    public void setIdp(Long idp) {
        this.idp = idp;
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
    public String getBirth_date() {
        return birth_date;
    }
    public void setBirth_date(String birth_date) {
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
