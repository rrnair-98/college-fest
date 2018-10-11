package com.rohan.festapp.college.controller;

import com.rohan.festapp.college.model.College;
import com.rohan.festapp.college.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;

@RequestMapping("/api/v1/college/")
@RestController
public class CollegeController {
    @Autowired
    private CollegeService collegeService;

    @GetMapping("{id}")
    public ResponseEntity<College> getCollegeById(@PathVariable("id") Long collegeId){
        College c = this.collegeService.getCollege(collegeId);
        return ResponseEntity.status(200).body(c);
    }

    @GetMapping("all/")
    public ResponseEntity<Iterator<College>> getAllColleges(){
        return ResponseEntity.status(200).body(this.collegeService.getAllColleges());
    }

    @GetMapping("filter/name/{name}")
    public ResponseEntity<Iterator<College>> getCollegesByName(@PathVariable("name") String name){
        return ResponseEntity.status(200).body(this.collegeService.filterByName(name));
    }


    @GetMapping("filter/address/{address}")
    public ResponseEntity<Iterator<College>> getCollegesByAddress(@PathVariable("address") String address){
        return ResponseEntity.status(200).body(this.collegeService.filterByAddress(address));
    }

    @PostMapping("create/")
    public ResponseEntity createCollege(@RequestBody College college){
        this.collegeService.createCollege(college);
        return ResponseEntity.status(200).build();
    }

    @PutMapping("update/{id}/")
    public ResponseEntity updateCollege(@PathVariable("id") Long id, @RequestBody College updatedCollege){
        return ResponseEntity.status(200).body(this.collegeService.updateCollege(id, updatedCollege));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity deleteCollege(@PathVariable("id") Long id){
        this.collegeService.deleteCollege(id);
        return ResponseEntity.status(200).build();
    }

}
