package spring.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import spring.domain.City;
import spring.domain.Event;

@Getter
@Setter
@AllArgsConstructor
public class EventDTO {
  private Integer id;
  private String name;
  private City city;

  public static EventDTO getInstance(Event event){
    return new EventDTO(event.getId(), event.getName(), event.getCity());
  }
}
