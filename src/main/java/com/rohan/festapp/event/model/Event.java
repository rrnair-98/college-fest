package com.rohan.festapp.event.model;

import com.rohan.festapp.utils.models.BaseFields;
import org.hibernate.annotations.Where;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.Date;

@Entity
@Where(clause = "deleted <> 1")
public class Event extends BaseFields {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Double price;

    private Integer teamSize;

    /*
    Mapper
     */
    @Column(length = 300)
    private String description;

    @Column(length = 300)
    private String information;

    @Column(nullable = false )
    @Temporal(TemporalType.TIMESTAMP)
    private Date scheduledDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getTeamSize() {
        return teamSize;
    }

    public void setTeamSize(Integer teamSize) {
        this.teamSize = teamSize;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }
}
