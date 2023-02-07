package com.example.learningandroid.models;

public class DataModel {
    private String name;
    private String job;

    public DataModel(String first, String last) {
        this.name = first;
        this.job = last;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
