package org.unibl.etf.ipback.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.unibl.etf.ipback.entities.UserEntity;
import org.unibl.etf.ipback.service.EmailService;
import org.unibl.etf.ipback.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private EmailService emailService;

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody UserEntity userEntity){

        if(userService.createUser(userEntity) != null)
            return ResponseEntity.status(HttpStatusCode.valueOf(201)).build();
        else
            return ResponseEntity.status(HttpStatusCode.valueOf(409)).build();
    }
    @GetMapping
    public List<UserEntity> getAll(){
        return userService.getAll();
    }

    @GetMapping("/user/{id}")
    public UserEntity getOneUser(@PathVariable Integer id){
        UserEntity user = userService.getUserById(id);
        user.getUserAccount().setIsActivated(1);
        userService.updateUser(user);
        return user;
    }

    @PostMapping("/activate")
    public ResponseEntity<?> activateUserAccount(@RequestBody UserEntity userEntity){
         UserEntity user = userService.getUserByUsername(userEntity.getUserAccount().getUsername());

         emailService.sendMail("filip.djakovic@student.etf.unibl.org","Click to link: "
         +"http://localhost:8080/users/user/"+user.getId());

         return ResponseEntity.status(HttpStatusCode.valueOf(200)).build();
    }
    @GetMapping("/user_n/{username}")
    public UserEntity getUserByUsername(@PathVariable String username){
        return userService.getUserByUsername(username);
    }
    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody UserEntity userEntity){
        userService.updateUser(userEntity);
        return ResponseEntity.status(HttpStatusCode.valueOf(200)).build();
    }
}
