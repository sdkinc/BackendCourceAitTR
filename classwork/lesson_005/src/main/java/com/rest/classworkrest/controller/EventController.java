package com.rest.classworkrest.controller;

import com.rest.classworkrest.domain.Event;
import com.rest.classworkrest.service.EventService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/event")
public class EventController {
  @Autowired
  private EventService eventService;

  @GetMapping("/all")
  public List<Event> findAll(){
    return eventService.findAll();
  }

  @GetMapping("/{id}")
  public Event findById(@PathVariable Integer id){
    return eventService.findById(id);
  }
  @PostMapping("/add")
  public Event add(@RequestBody Event event){
    return eventService.add(event);
  }
  @DeleteMapping("/delete/{id}")
  public Event deleteById(@PathVariable Integer id){
    return eventService.delete(id);
  }
  @PutMapping("/update/{id}")
  public Event updateById(@RequestBody Event event){
    return eventService.update(event);
  }
}
