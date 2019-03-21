package com.ms.aventure.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "session")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Session implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

   // @JsonManagedReference
    @JsonIdentityInfo( generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @ManyToOne(targetEntity = Aventure.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "aventure_id", referencedColumnName = "id", insertable = false, nullable=false)
    private Aventure aventure;

//    @NotNull
//    @Column(name = "aventure_id")
//    private Integer aventureId;

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

//    
//    public Integer getAventureId() {
//		return aventureId;
//	}
//
//	public void setAventureId(Integer aventureId) {
//		this.aventureId = aventureId;
//	}

	@Override
    public String toString() {
        return "Session{" +
                "id=" + id +
                ", startdate=" + startdate +
                ", enddate=" + enddate +
                '}';
    }
}
