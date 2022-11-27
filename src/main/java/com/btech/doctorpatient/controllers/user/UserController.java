package com.btech.doctorpatient.controllers.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.AccessType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.btech.doctorpatient.helper.ResponseMessage;
import com.btech.doctorpatient.services.user.UserService;

@RestController
public class UserController {
    
    @Autowired
    public UserService userService;

    @Autowired
    public ResponseMessage responseMessage;
    
    @PostMapping("/register-user")
    public ResponseEntity<?> addUser(@RequestParam("email") String email,@RequestParam("password")String password,@RequestParam("name")String name,@RequestParam("phone") String phoneNo,@RequestParam("address") String address,@RequestParam("gender") String gender,@RequestParam("bloodGroup") String bloodGroup,@RequestParam("height") String height,@RequestParam("weight") String weight){
        try {
            return userService.addUser(email, password, name, phoneNo, address, gender, bloodGroup, height, weight);
        } catch (Exception e) {
            // TODO: handle exception
            responseMessage.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseMessage);
        }
    }

    @PostMapping("/login-user")
    public ResponseEntity<?> loginUser(@RequestParam("email") String email,@RequestParam("password") String password){
        try {
            return userService.loginUser(email,password);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            responseMessage.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseMessage);
        }
    }



}
