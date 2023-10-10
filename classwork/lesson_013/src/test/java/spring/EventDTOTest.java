package spring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import spring.controller.dto.EventDTO;
import spring.domain.City;
import spring.domain.Event;

public class EventDTOTest {
  public static final String NAME = "Concert";
  public static final String CITY = "Berlin";
  private static final int ID = 1;
  @Test
  public void TestAdd(){

  }
  @Test
  public void testEventDTO(){
    City city = new City(ID, CITY);
    Event event = new Event(ID,NAME,city);
    EventDTO eventDTO = EventDTO.getInstance(event);

    Assertions.assertEquals(ID,eventDTO.getId());
    Assertions.assertEquals(NAME,eventDTO.getName());
    Assertions.assertEquals(CITY,eventDTO.getCity());
  }
}
