package spring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import spring.controller.dto.EventDTO;
import spring.domain.City;
import spring.domain.Event;
import spring.repository.CityRepository;
import spring.repository.EventRepository;
import spring.service.EventService;
@SpringBootTest
@ActiveProfiles("test")
public class EventServiceTest {

  @Autowired
  private EventService eventService;

  @Autowired
  private EventRepository eventRepository;

  @Autowired
  private CityRepository cityRepository;

  @BeforeEach
  public void initEach(){
    City city = cityRepository.findByName(DtoClassesTest.CITY);
    if(city==null){
      cityRepository.save(new City(null,DtoClassesTest.CITY));
    }

    Event event = eventRepository.findById(DtoClassesTest.ID).orElse(null);
    if(event==null){
      eventRepository.save(new Event(null,DtoClassesTest.NAME,city));
    }
  }

  @Test
  public void testAddEvent() {
    EventDTO eventDTOin = new EventDTO(null, DtoClassesTest.NAME, DtoClassesTest.CITY);
    EventDTO eventDTOout = eventService.add(eventDTOin);

    Assertions.assertNotNull(eventDTOout.getId());
    Assertions.assertEquals(eventDTOin.getName(), eventDTOout.getName());
    Assertions.assertEquals(eventDTOin.getCity(), eventDTOout.getCity());

    Event event = eventRepository.findById(eventDTOout.getId()).orElse(null);
    City city = cityRepository.findByName(DtoClassesTest.CITY);

    Assertions.assertNotNull(event);
    Assertions.assertEquals(DtoClassesTest.NAME, event.getName());
    Assertions.assertEquals(event.getCity().getCityId(), city.getCityId());

    Assertions.assertNotNull(city);
    Assertions.assertEquals(DtoClassesTest.CITY, city.getName());
  }

  @Test
  public void testUpdateEvent() {
      City city = cityRepository.findByName(DtoClassesTest.CITY);
    EventDTO eventDTOin = EventDTO.getInstance(
        new Event(DtoClassesTest.ID, DtoClassesTest.NAME + "_", city));
    EventDTO eventDTOout = eventService.update(eventDTOin);

    Assertions.assertNotNull(eventDTOout.getId());
    Assertions.assertEquals(eventDTOin.getName(), eventDTOout.getName());
    Assertions.assertEquals(eventDTOin.getCity(), eventDTOout.getCity());

    Event event = eventRepository.findById(eventDTOout.getId()).orElse(null);
    city = cityRepository.findByName(DtoClassesTest.CITY);

    Assertions.assertNotNull(event);
    Assertions.assertEquals(DtoClassesTest.NAME+"_", event.getName());
    Assertions.assertEquals(event.getCity().getCityId(), city.getCityId());

    Assertions.assertNotNull(city);
    Assertions.assertEquals(DtoClassesTest.CITY, city.getName());
  }
}
