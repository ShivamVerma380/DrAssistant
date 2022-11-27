package com.btech.doctorpatient.services.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.btech.doctorpatient.config.MySecurityConfig;
import com.btech.doctorpatient.daos.user.UserDao;
import com.btech.doctorpatient.entities.user.UserRequest;
import com.btech.doctorpatient.helper.JwtResponse;
import com.btech.doctorpatient.helper.JwtUtil;
import com.btech.doctorpatient.helper.ResponseMessage;
import com.btech.doctorpatient.services.CustomUserDetailsService;

@Component
public class UserService {
    
    @Autowired
    public ResponseMessage responseMessage;

    @Autowired
    public UserDao userDao;

    @Autowired
    public MySecurityConfig mySecurityConfig;

    @Autowired
    public JwtResponse jwtResponse;

    @Autowired
    public CustomUserDetailsService customUserDetailsService;


    @Autowired
    public JwtUtil jwtUtil;

    public ResponseEntity<?> addUser(String email,String password,String name,String phoneNo,String address,String gender,String bloodGroup,String height,String weight) {
        try {
            UserRequest userRequest = userDao.findByEmail(email);
            if(userRequest!=null){
                responseMessage.setMessage("User already exists");
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseMessage);
            }            
            
            userRequest = new UserRequest();
            userRequest.setEmail(email);

            String encoded_password = mySecurityConfig.passwordEncoder().encode(password);

            userRequest.setPassword(encoded_password);
            userRequest.setName(name);
            userRequest.setPhone(phoneNo);
            userRequest.setAddress(address);
            userRequest.setGender(gender);
            userRequest.setBloodGroup(bloodGroup);
            userRequest.setHeight(height);
            userRequest.setWeight(weight);
            userDao.save(userRequest);

            UserDetails userDetails = customUserDetailsService.loadUserByUsername(email);
            String token = jwtUtil.generateToken(userDetails);
           
            jwtResponse.setToken(token);
            jwtResponse.setMessage("User added successfully");
            // responseMessage.setMessage("User saved successfully");
            return ResponseEntity.status(HttpStatus.OK).body(responseMessage);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            responseMessage.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseMessage);
        }
    }

    public ResponseEntity<?> loginUser(String email, String password) {
        try {
            UserRequest  obj= userDao.findByEmail(email);
            if(obj==null){
                responseMessage.setMessage("User does not exist");
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseMessage);
            }
            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
            if(bCryptPasswordEncoder.matches(password, obj.getPassword())){
                UserDetails userDetails = customUserDetailsService.loadUserByUsername(email);
                String token = jwtUtil.generateToken(userDetails);
           
                jwtResponse.setToken(token); 
                // responseMessage.setMessage("User logged In successfully");
                return ResponseEntity.status(HttpStatus.OK).body(jwtResponse);
            }else{
                responseMessage.setMessage("Password is incorrect");
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseMessage);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            responseMessage.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseMessage);
        }
    }
}
