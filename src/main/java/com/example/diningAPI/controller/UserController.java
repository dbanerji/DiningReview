package com.example.diningAPI.controller;
import com.example.diningAPI.model.Users;
import com.example.diningAPI.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.swing.text.html.Option;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private final UserRepository userRepository;

    public UserController(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/users")
    public Users createNewUser(@RequestBody Users user){
        Users newUser= userRepository.save(user);
        return newUser;
    }

    @GetMapping("/users")
    public Iterable<Users> getAllUsers(){
        return userRepository.findAll();
    }


    @PutMapping("/users/{id}")
    public Users updateUsers(@PathVariable("id") Integer id, @RequestBody Users u) {
        Optional<Users> userToUpdateOptional = this.userRepository.findById(id);
        if (!userToUpdateOptional.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"User does not exist");
        }

        Users userToUpdate = userToUpdateOptional.get();
        userToUpdate.setCity(u.getCity());
        userToUpdate.setState(u.getState());
        userToUpdate.setZipcode(u.getZipcode());
        userToUpdate.setPeanutAllergy(u.isPeanutAllergy());
        userToUpdate.setDairyAllergy(u.isDairyAllergy());
        userToUpdate.setEggAllergy(u.isEggAllergy());

        Users updatedUser = this.userRepository.save(userToUpdate);
        return updatedUser;
    }

        @GetMapping("/users/{displayName}")
        public Optional<Users> getUserByDisplayName(@PathVariable("displayName") String displayName) {
            Optional<Users> usersOptional = userRepository.findByDisplayName(displayName);
            if(!usersOptional.isPresent()){
                throw new ResponseStatusException(HttpStatus.NOT_FOUND,"User does not exist");
            }
            return usersOptional;
        }


}
