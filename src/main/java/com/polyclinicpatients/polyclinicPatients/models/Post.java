package com.polyclinicpatients.polyclinicPatients.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String tetle;

    public Post() {
    }

    public Post(String tetle, String anounce, String full_text) {
        this.tetle = tetle;
        this.anounce = anounce;
        this.full_text = full_text;
    }

    private String anounce;
    private String full_text;
    private int views;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTetle() {
        return tetle;
    }

    public void setTetle(String tetle) {
        this.tetle = tetle;
    }

    public String getAnounce() {
        return anounce;
    }

    public void setAnounce(String anounce) {
        this.anounce = anounce;
    }

    public String getFull_text() {
        return full_text;
    }

    public void setFull_text(String full_text) {
        this.full_text = full_text;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }
}
