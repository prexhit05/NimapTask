package com.nimapInfotech.task.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;


import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Entity
public class Catagory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String catagoryName;


    @OneToMany(mappedBy = "catagory",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Product> productList = new ArrayList<>();

    @Override
    public String toString() {
        return "Catagory{" +
                "id=" + id +
                ", catagoryName='" + catagoryName + '\'' +
                ", productList=" + productList +
                '}';
    }
}
