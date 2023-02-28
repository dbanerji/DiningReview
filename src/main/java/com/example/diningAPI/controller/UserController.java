package com.example.diningAPI.controller;
import com.example.diningAPI.model.Users;
import com.example.diningAPI.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.swing.text.html.Option;
import java.util.Optional;

@RestController
public class UserController {

    private final UserRepository userRepository;

    public UserController(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping
    public Users createNewUser(Users user){
        Users newUser= userRepository.save(user);
        return newUser;
    }

    @PutMapping
    public Users updateUsers(@PathVariable("id") Integer id, @RequestBody Users u) {
        Optional<Users> userToUpdateOptional = this.userRepository.findById(id);
        if (!userToUpdateOptional.isPresent()) {
            return null;
        }
        Users userToUpdate = userToUpdateOptional.get();
        if (userToUpdate.getCity() != null) {
            userToUpdate.setCity(u.getCity());
        }
        if (userToUpdate.getId() != null) {
            userToUpdate.setId(u.getId());
        }
        if (userToUpdate.getZipcode() != null) {
            userToUpdate.setZipcode(u.getZipcode());
        }
        Users updatedUser = this.userRepository.save(userToUpdate);
        return updatedUser;
    }

        public Optional<Users> getUsertByDisplayName(@PathVariable("displayName") String displayName) {
            Optional<Users> usersOptional = userRepository.findByDisplay(displayName);
            if(!usersOptional.isPresent()){
                throw new ResponseStatusException(HttpStatus.NOT_FOUND,"User does not exist");
            }
            return usersOptional;
        }


}
