package com.example.demo.models;

import jakarta.persistence.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @NotNull
    @Column(name = "name")
    private String name;
    @NotBlank
    @Column(name = "dolznost")
    private String dolznost;
    @NotBlank
    @Column(name = "zp")
    private String zp;
    @NotBlank
    @Column(name = "premiya")
    private String premiya;

    public Employee(int id, String name, String dolznost, String zp, String premiya) {
        this.id = id;
        this.name = name;
        this.dolznost = dolznost;
        this.zp = zp;
        this.premiya = premiya;
    }

    public Employee(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDolznost() {
        return dolznost;
    }

    public void setDolznost(String dolznost) {
        this.dolznost = dolznost;
    }

    public String getZp() {
        return zp;
    }

    public void setZp(String zp) {
        this.zp = zp;
    }

    public String getPremiya() {
        return premiya;
    }

    public void setPremiya(String premiya) {
        this.premiya = premiya;
    }
}
