package com.rohan.festapp.event.controller;

import com.rohan.festapp.event.model.Event;
import com.rohan.festapp.event.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;

@RestController
@RequestMapping("api/v1/event/")
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping("{id}")
    public ResponseEntity<Event> getEventById(@PathVariable("id") Long id){
        return ResponseEntity.status(200).body(this.eventService.findById(id));
    }

    @GetMapping("all/")
    public ResponseEntity<Iterator<Event>> getAllEvents(){
        return ResponseEntity.status(200).body(this.eventService.getAll());
    }

    @PostMapping("create/")
    public ResponseEntity createEvent(@RequestBody Event e){
        this.eventService.createEvent(e);
        return ResponseEntity.status(200).build();
    }
}
