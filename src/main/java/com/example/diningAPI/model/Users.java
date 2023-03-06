package com.example.diningAPI.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Entity
@Table(name="USERS")
@Getter
@Setter
@RequiredArgsConstructor
public class Users {

    @Column(name = "DISPLAY_NAME")
    private String displayName;

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long Id;

    @Column(name="CITY")
    private String city;

    @Column(name = "STATE")
    private String state;

    @Column(name = "ZIP_CODE")
    private String zipcode;

    @Column(name = "PEANUT_ALLERGY")
    private boolean peanutAllergy;

    @Column(name = "EGG_ALLERGY")
    private boolean eggAllergy;

    @Column(name = "DAIRYALLERGY")
    private boolean dairyAllergy;


}
