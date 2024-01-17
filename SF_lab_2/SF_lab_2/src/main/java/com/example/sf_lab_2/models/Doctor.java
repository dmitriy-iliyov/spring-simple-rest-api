package com.example.sf_lab_2.models;


public class Doctor {
    private String name;
    private String specification;
    private String number;
    private String email;

    public String getName() {
        return name;
    }

    public String getSpecification() {
        return specification;
    }

    public String getNumber() {
        return number;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString(){
        return "{name : " + this.name + "; specification : " + this.specification + "; number : " + this.number + "; email : " + this.email + "}";
    }
}
