package com.rohan.festapp.college.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rohan.festapp.committee.model.Committee;
import com.rohan.festapp.utils.models.BaseFields;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Set;

@Entity
@Where(clause = "deleted <> 1")
public class College extends BaseFields {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    @Column(unique = true, length = 30)
    private String name;
    @Column(columnDefinition = "VARCHAR(350)")
    private String address;


    private Integer postalCode;

/*    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    @JoinTable(name="college_to_committee", joinColumns = {@JoinColumn(name="col_id")}, inverseJoinColumns = {@JoinColumn(name = "com_id")})
    private Set<Committee> committees;*/

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void updateCollegeData(College updatedCollege){
        this.name = updatedCollege.name;
        this.address = updatedCollege.address;
        this.postalCode = updatedCollege.postalCode;
    }


    public Integer getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(Integer postalCode) {
        this.postalCode = postalCode;
    }

/*    public Set<Committee> getCommittees() {
        return committees;
    }

    public void setCommittees(Set<Committee> committees) {
        this.committees = committees;
    }*/
}
