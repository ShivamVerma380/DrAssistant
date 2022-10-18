package com.btech.doctorpatient.daos.user;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.btech.doctorpatient.entities.user.UserRequest;

@Component
@Repository
public interface UserDao extends MongoRepository<UserRequest,String>{
    
    public UserRequest findByEmail(String email);
}
