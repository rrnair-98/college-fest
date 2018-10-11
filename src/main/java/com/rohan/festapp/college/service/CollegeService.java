package com.rohan.festapp.college.service;

import com.rohan.festapp.college.model.College;
import com.rohan.festapp.college.repository.CollegeRepo;
import com.rohan.festapp.utils.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;

@Service
public class CollegeService {

    @Autowired
    private CollegeRepo collegeRepo;
    /**
     * This method creates and returns an instance of a colleg
     * @param college:College -> The college that must be persisted
     * @return College
     */
    public College createCollege(College college){
        return this.collegeRepo.save(college);
    }

    /**
     * Returns a college given an id
     * @param collegeId:Long -> the id of the college you wish to read
     * @return College
     */
    public College getCollege(long collegeId){
        return this.collegeRepo.findById(collegeId).orElseThrow(() -> new ResourceNotFoundException("college", "id", collegeId));
    }


    /**
     * Updates college information
     * @param collegeId:Long -> The id of the college to be updated
     * @param updatedCollege:College -> An instance of college containing updated data
     * @return College
     */
    public College updateCollege(long collegeId, College updatedCollege){
        College current = this.collegeRepo.findById(collegeId).orElseThrow(() -> new ResourceNotFoundException("college", "id", collegeId));
        current.updateCollegeData(updatedCollege);
        return this.collegeRepo.save(current);
    }


    /**
     * Soft deletes a college
     * @param collegeId:Long -> The id of the college you wish to delete
     */
    public void deleteCollege(long collegeId){
        College toBeDeleted = this.collegeRepo.findById(collegeId).orElseThrow(()-> new ResourceNotFoundException("college", "id", collegeId));
        toBeDeleted.setDeleted((byte)1);
        this.collegeRepo.save(toBeDeleted);
    }

    /**
     * Returns all colleges in the database
     * @return Iterator<College>
     */
    public Iterator<College> getAllColleges(){
        return this.collegeRepo.findAll().iterator();
    }

    /**
     * Returns all colleges with specified name
     * @param collegeName:String -> The name of the college
     * @return Iterator<College>
     */
    public Iterator<College> filterByName(String collegeName){
        return this.collegeRepo.findAllByName(collegeName);
    }

    /**
     * Filters colleges by address
     * @param address:String -> The address to filter this list by
     * @return Iterator<College>
     */
    public Iterator<College> filterByAddress(String address){
        return this.collegeRepo.findAllByAddress(address);
    }

    /**
     * Filters colleges by postalCode
     * @param postalCode:Integer -> The postal code to filter this list by
     * @return Iterator<College>
     */
    public Iterator<College> filterByPincode(Integer postalCode){
        return this.collegeRepo.findAllByPostalCode(postalCode);
    }


}
