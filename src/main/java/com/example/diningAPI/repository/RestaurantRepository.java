package com.example.diningAPI.repository;

import com.example.diningAPI.model.Restaurant;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface RestaurantRepository extends CrudRepository<Restaurant,Long> {
    boolean existsByLocation(String location);
    boolean existByName(String name);

    List<Restaurant> findByLocationAndAllergy(String location);
}
