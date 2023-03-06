package com.example.diningAPI.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Table(name="RESTAURANT")
@RequiredArgsConstructor
public class Restaurant {

    @Id
    @GeneratedValue
    @NonNull
    private Long id;

    @Column(name = "NAME")
    @NonNull
    private String name;

    @Column(name = "CUISINE")
    @NonNull
    private String cuisine;

    @Column(name = "LOCATION")
    private String location;

}