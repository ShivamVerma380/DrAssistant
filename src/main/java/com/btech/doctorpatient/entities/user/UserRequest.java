package com.btech.doctorpatient.entities.user;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@Document(collection = "user")
@Component
public class UserRequest {
    
    @Id
    private String email;

    private String password;

    private String name;

    public UserRequest() {
    }

    public UserRequest(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserRequest [email=" + email + ", password=" + password + ", name=" + name + "]";
    }

    
    
    
}
