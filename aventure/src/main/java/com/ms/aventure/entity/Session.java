package com.ms.aventure.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "session")
public class Session implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonBackReference
    @ManyToOne(targetEntity = Aventure.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "aventure_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Aventure aventure;

    @NotNull
    @Column(name = "aventure_id")
    private Integer aventureId;

    @NotNull
    @Column(name = "startdate")
    private Date startdate;

    @NotNull
    @Column(name = "enddate")
    private Date enddate;

    public Session(@NotNull Date startdate, @NotNull Date enddate) {
        this.startdate = startdate;
        this.enddate = enddate;
    }

    public Session() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Aventure getAventure() {
        return aventure;
    }

    public void setAventure(Aventure aventure) {
        this.aventure = aventure;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    @Override
    public String toString() {
        return "Session{" +
                "id=" + id +
                ", startdate=" + startdate +
                ", enddate=" + enddate +
                '}';
    }
}
