package com.rohan.festapp.college.repository;

import com.rohan.festapp.college.model.College;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Iterator;

public interface CollegeRepo extends CrudRepository<College,Long> {
    Iterator<College> findAllByName(String collegeName);
    Iterator<College> findAllByAddress(String address);
    Iterator<College> findAllByPostalCode(Integer postalCode);
}
