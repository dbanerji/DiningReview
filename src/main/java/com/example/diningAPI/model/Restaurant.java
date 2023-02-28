package com.example.diningAPI.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="RESTAURANT")
@RequiredArgsConstructor
public class Restaurant {

    @Id
    @GeneratedValue
    @Getter
    @Setter
    @NonNull
    private Long id;

    @Column
    @Getter
    @Setter
    @NonNull
    private String name;

    @Column
    @Getter
    @Setter
    @NonNull
    private String cuisine;

    @Column
    @Getter
    @Setter
    private int peanutAllergyScore;

    @Column
    @Getter
    @Setter
    private int eggAllergyScore;

    @Column
    @Getter
    @Setter
    private int dairyAllergyScore;

    @Column
    @Getter
    @Setter
    private int overallScore;

}
