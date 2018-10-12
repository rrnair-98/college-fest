package com.rohan.festapp.users.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rohan.festapp.college.model.CollegeToCommittee;
import com.rohan.festapp.utils.models.BaseFields;

import javax.persistence.*;

@Entity
public class CommitteeMember extends BaseFields {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private User baseUser;

    @JsonIgnore
    @ManyToOne
    private CollegeToCommittee ctc;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getBaseUser() {
        return baseUser;
    }

    public void setBaseUser(User baseUser) {
        this.baseUser = baseUser;
    }

    public CollegeToCommittee getCtc() {
        return ctc;
    }

    public void setCtc(CollegeToCommittee ctc) {
        this.ctc = ctc;
    }
}
