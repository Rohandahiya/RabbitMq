package com.example.rabbitMQ;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class User implements Serializable {

    private String name;

    private Integer age;

    @JsonProperty(value = "EeeMail")
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}