package com.example.demo.models;

import jakarta.persistence.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Inventory")
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @NotNull
    @Column(name = "name")
    private String name;
    @NotBlank
    @Column(name = "type")
    private String type;
    @NotBlank
    @Column(name = "bladelength")
    private String bladelength;
    @NotBlank
    @Column(name = "price")
    private String price;

    public Inventory(int id, String name, String type, String bladelength, String price) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.bladelength = bladelength;
        this.price = price;
    }

    public Inventory(){}

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBladelength() {
        return bladelength;
    }

    public void setBladelength(String bladelength) {
        this.bladelength = bladelength;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
