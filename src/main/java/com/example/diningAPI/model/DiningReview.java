package com.example.diningAPI.model;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
@Table(name="DINING_REVIEW")
@RequiredArgsConstructor
public class DiningReview {


    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @Column(name = "REVIEWER_NAME")
    private String reviewerName;

    @Column(name = "RESTAURANT_ID")
    private Long restaurantId;

    @Column(name = "PEANUT_SCORE")
    private int peanutScore;

    @Column(name = "EGG_SCORE")
    private int eggScore;

    @Column(name = "DAIRY_SCORE")
    private int dairyScore;

    @Column(name = "COMMENTARY")
    private String commentary;

    @Column(name = "REVIEW_STATUS")
    @Enumerated(EnumType.STRING)
    private ReviewStatus reviewStatus;
}
