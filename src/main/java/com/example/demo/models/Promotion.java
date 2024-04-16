package com.example.demo.models;

import jakarta.persistence.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Promotion")
public class Promotion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @NotNull
    @Column(name = "promotionname")
    private String promotionname;
    @NotBlank
    @Column(name = "promotiontime")
    private String promotiontime;
    @NotBlank
    @Column(name = "conditions")
    private String conditions;
    @NotBlank
    @Column(name = "pronocode")
    private String pronocode;

    public Promotion(int id, String promotionname, String promotiontime, String conditions, String pronocode) {
        this.id = id;
        this.promotionname = promotionname;
        this.promotiontime = promotiontime;
        this.conditions = conditions;
        this.pronocode = pronocode;
    }
    public Promotion(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPromotionname() {
        return promotionname;
    }

    public void setPromotionname(String promotionname) {
        this.promotionname = promotionname;
    }

    public String getPromotiontime() {
        return promotiontime;
    }

    public void setPromotiontime(String promotiontime) {
        this.promotiontime = promotiontime;
    }

    public String getConditions() {
        return conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions;
    }

    public String getPronocode() {
        return pronocode;
    }

    public void setPronocode(String pronocode) {
        this.pronocode = pronocode;
    }
}
