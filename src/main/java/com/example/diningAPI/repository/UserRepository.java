package com.example.diningAPI.repository;
import com.example.diningAPI.model.Users;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<Users,Integer> {

    Optional<Users> findByDisplay(String displayName);
}
