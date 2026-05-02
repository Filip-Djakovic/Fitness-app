package org.unibl.etf.ipback.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.unibl.etf.ipback.entities.UserAccountEntity;
import org.unibl.etf.ipback.service.UserAccountService;

import java.util.List;

@RestController
@RequestMapping("/users_account")
public class UserAccountController {
    @Autowired
    private UserAccountService userAccountService;
    @PostMapping
    public ResponseEntity<?> login(@RequestBody UserAccountEntity userAccountEntity){
        UserAccountEntity user = userAccountService.getOneUser(userAccountEntity);
        if (user != null) {
            if(user.getIsActivated() == 1){
                System.out.println("Izvrsilo se");
                return ResponseEntity.status(HttpStatus.valueOf(200)).build();
            }
            else{
                if(user.getIsActivated() == 2 || user.getIsActivated()==3)
                    return ResponseEntity.status(HttpStatus.valueOf(451)).build();
                return ResponseEntity.status(HttpStatus.valueOf(401)).build();
            }
        }
        else
            return ResponseEntity.status(HttpStatusCode.valueOf(404)).build();
    }
    @PostMapping("/new_acc")
    public ResponseEntity<?> createAcc(@RequestBody UserAccountEntity userAccountEntity){
        UserAccountEntity user = userAccountService.createUserAcc(userAccountEntity);
        if (user != null){
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        else
            return ResponseEntity.status(HttpStatusCode.valueOf(409)).build();
    }
    @GetMapping
    public List<UserAccountEntity> getAll(){
        return userAccountService.getAll();
    }

    @DeleteMapping
    public ResponseEntity<?> deleteAcc(@RequestBody UserAccountEntity userAccountEntity){
        userAccountService.deleteUserAcc(userAccountEntity);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping
    public ResponseEntity<?> updateAcc(@RequestBody UserAccountEntity userAccountEntity){
        userAccountService.updateUserAcc(userAccountEntity);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @PostMapping("/activate")
    public ResponseEntity<?> activate(@RequestBody UserAccountEntity userAccountEntity){
        UserAccountEntity user = userAccountService.getOneUser(userAccountEntity);

        if(user != null){
            return ResponseEntity.status(HttpStatus.valueOf(200)).build();
        }
        else
            return ResponseEntity.status(HttpStatusCode.valueOf(409)).build();
    }
    @PostMapping("/advice_user")
    public ResponseEntity<?> loginAdvicer(@RequestBody UserAccountEntity userAccountEntity){
        UserAccountEntity user = userAccountService.getOneUser(userAccountEntity);
        if (user != null) {
            if(user.getIsActivated() == 2){
                System.out.println("Izvrsilo se");
                return ResponseEntity.status(HttpStatus.valueOf(200)).build();
            }
            else
                return ResponseEntity.status(HttpStatus.valueOf(401)).build();
        }
        else
            return ResponseEntity.status(HttpStatusCode.valueOf(404)).build();
    }

    @PostMapping("/admin_user")
    public ResponseEntity<?> loginAdmin(@RequestBody UserAccountEntity userAccountEntity){
        UserAccountEntity user = userAccountService.getOneUser(userAccountEntity);
        if (user != null) {
            if(user.getIsActivated() == 3){
                System.out.println("Izvrsilo se");
                return ResponseEntity.status(HttpStatus.valueOf(200)).build();
            }
            else
                return ResponseEntity.status(HttpStatus.valueOf(401)).build();
        }
        else
            return ResponseEntity.status(HttpStatusCode.valueOf(404)).build();
    }
}
