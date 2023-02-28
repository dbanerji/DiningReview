package com.example.diningAPI.model;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name="DININGREVIEW")
@RequiredArgsConstructor
public class DiningReview {

    @Column @Getter @Setter
    private String reviewerName;

    @Id
    @GeneratedValue
    @Getter @Setter
    private Long Id;

    @Column @Getter @Setter
    private int peanutScore;

    @Column @Getter @Setter
    private int eggScore;

    @Column @Getter @Setter
    private int dairyScore;

    @Column @Getter @Setter
    private String commentary;

    @Column @Getter @Setter
    private ReviewStatus status;
}
