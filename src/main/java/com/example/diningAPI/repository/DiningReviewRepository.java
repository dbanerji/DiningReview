package com.example.diningAPI.repository;

import com.example.diningAPI.model.DiningReview;
import com.example.diningAPI.model.Restaurant;
import com.example.diningAPI.model.ReviewStatus;
import org.springframework.data.repository.CrudRepository;

public interface DiningReviewRepository extends CrudRepository<DiningReview,Integer> {

    Iterable<DiningReview> findByReviewStatus(ReviewStatus status);
    Iterable<DiningReview> findAllApprovedReviews(Long restaurantId, ReviewStatus status );
    boolean allergyScoreExistsForRestaurant(Long restaurantId);
}
