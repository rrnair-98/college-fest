package com.rohan.festapp.committee.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rohan.festapp.college.model.College;
import com.rohan.festapp.utils.models.BaseFields;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Committee extends BaseFields {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

/*
    @JsonIgnore
    @ManyToMany
    @JoinTable(name="college_to_committee", joinColumns = {@JoinColumn(name="com_id")}, inverseJoinColumns = {@JoinColumn(name = "col_id")})
    private Set<College> colleges;
*/


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
/*
    public Set<College> getColleges() {
        return colleges;
    }

    public void setColleges(Set<College> colleges) {
        this.colleges = colleges;
    }*/
}
