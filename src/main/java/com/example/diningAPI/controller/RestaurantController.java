package com.example.diningAPI.controller;

import com.example.diningAPI.model.Restaurant;
import com.example.diningAPI.repository.DiningReviewRepository;
import com.example.diningAPI.repository.RestaurantRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

public class RestaurantController {

    private final RestaurantRepository restaurantRepository;
    private final DiningReviewRepository diningReviewRepository;

    public RestaurantController(RestaurantRepository restaurantRepository, final DiningReviewRepository diningReviewRepository){
        this.restaurantRepository = restaurantRepository;
        this.diningReviewRepository = diningReviewRepository;
    }

    @PostMapping("/restaurant")
    public Restaurant createNewRestaurant(@RequestBody Restaurant restaurant){
        if(restaurantRepository.existByName(restaurant.getName())&& restaurantRepository.existsByLocation(restaurant.getLocation())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Restaurant with this name or location exists already!");
        }
        return restaurantRepository.save(restaurant);
    }

    @GetMapping("/restaurant/{id}")
    public Optional<Restaurant> getRestaurantById(@RequestBody Long id){
        if(restaurantRepository.findById(id).isEmpty()) throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"The restaurant does not exist");
        return restaurantRepository.findById(id);
    }

    @GetMapping("/restaurant/search/{id}")
    public List<Restaurant> getRestaurantByLocationAndAllergy(@PathVariable("id")Long id){
        Optional<Restaurant> restaurantOptional = restaurantRepository.findById(id);
        Restaurant restaurant = restaurantOptional.get();
        String location = restaurant.getLocation();
        if(!restaurantRepository.existsByLocation(location) && diningReviewRepository.allergyScoreExistsForRestaurant(id)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Restaurant with this location does not exist or no allergy score found for this restaurant");
        }

        return restaurantRepository.findByLocationAndAllergy(location);

    }


}
