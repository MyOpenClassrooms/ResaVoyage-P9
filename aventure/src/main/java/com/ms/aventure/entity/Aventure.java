package com.ms.aventure.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "aventure")
public class Aventure implements Serializable {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(name="title")
    private String title;


    @Column(name = "description")
    private String description;


    @Column(name = "nbparticipant")
    private Integer nbparticipant;


    @Column(name = "location")
    private String location;


    @Column(name = "price")
    private Integer price;


    @Column(name = "image")
    private String image;


    @Column(name = "category_id")
    private String category_id;


    @JsonManagedReference
    @OneToMany(mappedBy = "aventure", targetEntity = Session.class, cascade = {CascadeType.MERGE, CascadeType.REMOVE})
    private List<Session> sessions = new ArrayList<>(0);


    public Aventure(String title, String description, Integer nbparticipant, String location, Integer price, String image) {
        this.title = title;
        this.description = description;
        this.nbparticipant = nbparticipant;
        this.location = location;
        this.price = price;
        this.image = image;
    }

    public Aventure() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getNbparticipant() {
        return nbparticipant;
    }

    public void setNbparticipant(Integer nbparticipant) {
        this.nbparticipant = nbparticipant;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public List<Session> getSessions() {
        return sessions;
    }

    public void setSessions(List<Session> sessions) {
        this.sessions = sessions;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    @Override
    public String toString() {
        return "Aventure{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", nbparticipant=" + nbparticipant +
                ", location='" + location + '\'' +
                ", price=" + price +
                ", image='" + image + '\'' +
                '}';
    }
}
