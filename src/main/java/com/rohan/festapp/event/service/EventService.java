package com.rohan.festapp.event.service;

import com.rohan.festapp.event.model.Event;
import com.rohan.festapp.event.repository.EventRepo;
import com.rohan.festapp.utils.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;

@Service
public class EventService {
    @Autowired
    private EventRepo eventRepo;


    public Event createEvent(Event e){
        return this.eventRepo.save(e);
    }

    public Event findById(Long id){
        return this.eventRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("event", "id", id));
    }

    public Iterator<Event> getAll(){
        return this.eventRepo.findAll().iterator();
    }

    public void deleteEvent(long id){
        Event c = this.eventRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("event", "id", id));
        c.setDeleted((byte) 1);
        this.eventRepo.save(c);

    }

}
