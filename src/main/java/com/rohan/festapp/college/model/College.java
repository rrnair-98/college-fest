package com.rohan.festapp.college.model;

import com.rohan.festapp.utils.models.BaseFields;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
}
