package com.example.demo.models;

import org.hibernate.annotations.GeneratorType;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;
//import  javax.persistence.Entity;

@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 25, unique = true)
    private String name;

    public Role() {

    }
    public Role( String name) {
        this.name = name;
    }

    public Role(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
