package de.pizza.tomate.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @project IntelliJ IDEA
 * @AUTHOR Oleksandr Zhurba on 10.10.2023.
 **/
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class PizzaBase {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="pizza_base_id")
  private int id;
  private String mame;
  private String description;
  private Double price;
  @ManyToOne
  @JoinColumn(name="pizza_size_id")
  private PizzaSize pizzaSize;

}
