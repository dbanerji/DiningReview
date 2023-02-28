package com.example.diningAPI.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Entity
@Table(name="USERS")
@RequiredArgsConstructor
public class Users {

    @Column(unique = true)
    @Getter
    @Setter
    @NonNull
    private String displayName;

    @Id
    @GeneratedValue
    @Getter @Setter
    @NonNull
    private Long Id;

    @Column
    @Getter @Setter
    private String city;

    @Column
    @Getter @Setter
    private String state;

    @Column
    @Getter @Setter
    private String zipcode;

    @Column
    @Getter @Setter
    private boolean peanutallergiesreview;

    @Column
    @Getter @Setter
    private boolean eggallergiesreview;

    @Column
    @Getter @Setter
    private boolean dairyallergiesreview;



}
