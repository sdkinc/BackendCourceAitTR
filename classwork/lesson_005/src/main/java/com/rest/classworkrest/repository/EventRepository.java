package com.rest.classworkrest.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.rest.classworkrest.domain.Event;

@Repository
public class EventRepository {

  static List<Event> events = new ArrayList<>(Arrays.asList(
      new Event("Opera", "London"),
      new Event("Violin concert", "NY"),
      new Event("Jazz concert", "Berlin"),
      new Event("Art exhibition", "London"),
      new Event("Royal Variety Show", "Paris")
  ));

  public List<Event> findAll() {
    return events;
  }

//  public Event save(Event event) {
//    Event newEvent = new Event(event.getName(), event.getCity());
//    events.add(newEvent);
//    return newEvent;
//  }

  public Event save(Event event) {
    if (event.getId() == null) {
      // add new Event
      Event newEvent = new Event(event.getName(), event.getCity());
      events.add(newEvent);
      return newEvent;
    } else {
      // update Event by id
      Event updEvent = findById(event.getId());
      if (updEvent != null) {
        updEvent.setName(event.getName());
        updEvent.setCity(event.getCity());
        return updEvent;
      }
      return null;
    }
  }

  public Event findById(int id) {
    for (Event event : events) {
      if (event.getId() == id) {
        return event;
      }
    }
    return null;
  }

  public Event remove(int id) {
    Event event = findById(id);
    if (event != null) {
      events.remove(event);
      return event;
    }
    return null;
  }
}
