package com.nimapInfotech.task.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "product")
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;
  private String pName;
  private String description;
  private double price;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "catagory_id")
  @JsonIgnoreProperties("products")
  private Catagory catagory;

  @Override
  public String toString() {

    return "Product{" +
            "id=" + id +
            ", pName='" + pName + '\'' +
            ", description='" + description + '\'' +
            ", price=" + price +
            ", catagory = " + catagory.getCatagoryName()+
            '}';
  }
}
