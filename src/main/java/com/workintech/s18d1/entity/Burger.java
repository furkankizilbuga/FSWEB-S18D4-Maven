package com.workintech.s18d1.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="burger")
public class Burger {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private String name;
    private Double price;

    @Column(name = "is_vegan")
    private Boolean isVegan;

    @Column(name = "bread_type")
    @Enumerated(EnumType.STRING)
    private BreadType breadType;

    private String contents;



}
