package spring.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "events")
public class Event {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String name;

  private Integer city_id;

  public Event() {
  }

  public Event(String name, Integer city_id) {
    this.name = name;
    this.city_id = city_id;
  }

  public Integer getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getCity() {
    return city_id;
  }

  public void setCity(Integer city_id) {
    this.city_id = city_id;
  }

  public void setId(Integer id) {
    this.id = id;
  }
}
