package spring.service;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.controller.dto.EventDTO;
import spring.domain.Event;
import java.util.List;
import spring.repository.EventRepository;

@Service
public class EventService {
    static final Logger log = LoggerFactory.getLogger(EventService.class);

    @Autowired
    private EventRepository eventRepository;

    public List<EventDTO> findAll() {
        List<Event> events = eventRepository.findAll();
        List<EventDTO> result = new ArrayList<>();
        for (Event e: events) {
            result.add(EventDTO.getInstance(e));
        }
        log.info("Reading all records from event table");
        return result;
    }

    public EventDTO add(EventDTO e) {
        Event event = new Event(e.getName(),e.getCity());
        event = eventRepository.save(event);
        EventDTO eventDTO = EventDTO.getInstance(event);
        log.info("Adding {} to event table", eventDTO.toString());
        return eventDTO;
    }

    public EventDTO findById(Integer id) {
        Event event =eventRepository.findById(id).orElse(null);
        if(event!=null){
            EventDTO eventDTO = EventDTO.getInstance(event);
            log.info("Reading record from event table by id {}", eventDTO.getId());
            return eventDTO;
        }
        log.error("Not found event by requested id {}",id);
        return null;
    }

    public EventDTO update(EventDTO e) {
        Event event = eventRepository.findById(e.getId()).orElse(null);
        if(event!=null){
            event.setName(e.getName());
            event.setCity(e.getCity());
            event = eventRepository.save(event);
            EventDTO eventDTO =EventDTO.getInstance(event);
            log.info("Updating record in event table by id {}", eventDTO.getId());
            return eventDTO;
        }
        log.error("Not found event by requested id {}",e.getId());
        return null;

    }

    public EventDTO delete(Integer id) {
        Event event = eventRepository.findById(id).orElse(null);
        if(event !=null){
            eventRepository.delete(event);
            EventDTO eventDTO = EventDTO.getInstance(event);
            log.info("Deleting record in event table by id {}", id);
            return eventDTO;
        }
        log.error("Not found event by requested id {}",id);
        return null;
    }
}
