package com.rohan.festapp.college.model;

import com.rohan.festapp.committee.model.Committee;
import com.rohan.festapp.users.model.User;
import com.rohan.festapp.utils.models.BaseFields;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "college_to_committee")
public class CollegeToCommittee extends BaseFields {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
/*

    @JoinColumn(name = "com_id" )
    private Committee committee;

    @JoinColumn(name = "col_id")
    private College college;

    @OneToMany
    private Set<User> committeeMembers;
*/

}
