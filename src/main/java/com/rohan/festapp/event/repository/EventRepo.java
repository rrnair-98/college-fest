package com.rohan.festapp.event.repository;

import com.rohan.festapp.event.model.Event;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.Iterator;

public interface EventRepo extends CrudRepository<Event, Long> {
    Iterator<Event> getAllByScheduledDateBetween(Date startDate, Date endDate);
}
