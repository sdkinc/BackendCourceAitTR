package spring.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "events")
public class Event {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer event_id;
  private String name;
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "cityId")
  private City city;



}
