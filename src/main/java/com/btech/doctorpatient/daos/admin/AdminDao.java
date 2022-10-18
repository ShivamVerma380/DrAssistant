package com.btech.doctorpatient.daos.admin;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.btech.doctorpatient.entities.admin.Admin;

@Component
@Repository
public interface AdminDao extends MongoRepository<Admin, String> {

    public Admin findByEmail(String email);

}

