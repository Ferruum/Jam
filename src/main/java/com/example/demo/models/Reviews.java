package com.example.demo.models;

import jakarta.persistence.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Reviews")
public class Reviews {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @NotNull
    @Column(name = "namecut")
    private String namecut;
    @NotBlank
    @Column(name = "clientname")
    private String clientname;
    @NotBlank
    @Column(name = "raiting")
    private String raiting;
    @NotBlank
    @Column(name = "comment")
    private String comment;

    public Reviews(int id, String namecut, String clientname, String raiting, String comment) {
        this.id = id;
        this.namecut = namecut;
        this.clientname = clientname;
        this.raiting = raiting;
        this.comment = comment;
    }
    public Reviews(){}
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamecut() {
        return namecut;
    }

    public void setNamecut(String namecut) {
        this.namecut = namecut;
    }

    public String getClientname() {
        return clientname;
    }

    public void setClientname(String clientname) {
        this.clientname = clientname;
    }

    public String getRaiting() {
        return raiting;
    }

    public void setRaiting(String raiting) {
        this.raiting = raiting;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
