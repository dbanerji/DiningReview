package com.example.diningAPI.controller;

import com.example.diningAPI.model.DiningReview;
import com.example.diningAPI.model.Restaurant;
import com.example.diningAPI.model.ReviewStatus;
import com.example.diningAPI.repository.DiningReviewRepository;
import com.example.diningAPI.repository.RestaurantRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
public class DiningReviewController {

    private final DiningReviewRepository diningReviewRepository;

    public DiningReviewController(final DiningReviewRepository diningReviewRepository){
        this.diningReviewRepository = diningReviewRepository;
    }

    @PostMapping("/dining_review")
    public DiningReview createNewReview(@RequestBody DiningReview diningReview){
        return diningReviewRepository.save(diningReview);
    }

    @GetMapping("/dining_review")
    public Iterable<DiningReview> getAllDiningReviews(){
        return diningReviewRepository.findAll();
    }

    @GetMapping("/dining_review/pending")
    public Iterable<DiningReview> getPendingReviews(){
        return diningReviewRepository.findByReviewStatus(ReviewStatus.PENDING);
    }

    @PostMapping("/dining_review/admin_review/{id}")
    public DiningReview approveReview(@PathVariable("id") Integer id){
        Optional<DiningReview> diningReviewOptional = diningReviewRepository.findById(id);
        if(!diningReviewOptional.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No review found with this id!");
        }
        DiningReview diningReviewToUpdate = diningReviewOptional.get();
        diningReviewToUpdate.setReviewStatus(ReviewStatus.ACCEPTED);
        return diningReviewRepository.save(diningReviewToUpdate);
    }

    @PostMapping("/dining_review/admin_review/{id}")
    public DiningReview rejectReview(@PathVariable("id") Integer id){
        Optional<DiningReview> diningReviewOptional = diningReviewRepository.findById(id);
        if(diningReviewOptional.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No review found with this id!");
        }
        DiningReview diningReviewtoUpdate = diningReviewOptional.get();
        diningReviewtoUpdate.setReviewStatus(ReviewStatus.REJECTED);
        return diningReviewRepository.save(diningReviewtoUpdate);
    }

    @GetMapping("/dining_review/accepted_reviews")
    public Iterable<DiningReview> getAllAcceptedReviews(Long restaurantId, ReviewStatus status){

        return diningReviewRepository.findAllApprovedReviews(restaurantId, ReviewStatus.ACCEPTED);
    }

}


