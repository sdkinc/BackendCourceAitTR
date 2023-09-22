package spring.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import spring.domain.Event;

@Getter
@Setter
@AllArgsConstructor
public class EventDTO {
  private Integer id;
  private String name;
  private String city;

  public static EventDTO getInstance(Event event){
    return new EventDTO(event.getEvent_id(), event.getName(), event.getCity().getName());
  }
}
