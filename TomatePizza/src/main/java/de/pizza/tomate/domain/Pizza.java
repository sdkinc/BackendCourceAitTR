package de.pizza.tomate.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class Pizza {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="pizza_id")
  private int id;
  private String title;
  private double price;
}
