package com.rest.classworkrest.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rest.classworkrest.domain.Event;
import com.rest.classworkrest.repository.EventRepository;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public List<Event> findAll() {
        return eventRepository.findAll();
    }

    public Event add(Event event) {
        return eventRepository.save(event);
    }

    public Event findById(Integer id) {
        return eventRepository.findById(id);
    }

    public Event update(Event event) {
        return eventRepository.save(event);
    }

    public Event delete(Integer id) {
        return eventRepository.remove(id);
    }
}
