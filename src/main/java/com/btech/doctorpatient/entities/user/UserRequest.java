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

    private String phone;

    private String address;

    private String gender;

    private String bloodGroup;

    private String height;

    private String weight;


    public UserRequest() {
    }

    

    public UserRequest(String email, String password, String name, String phone, String address, String gender,
            String bloodGroup, String height, String weight) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.gender = gender;
        this.bloodGroup = bloodGroup;
        this.height = height;
        this.weight = weight;
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



    public String getPhone() {
        return phone;
    }



    public void setPhone(String phone) {
        this.phone = phone;
    }



    public String getAddress() {
        return address;
    }



    public void setAddress(String address) {
        this.address = address;
    }



    public String getGender() {
        return gender;
    }



    public void setGender(String gender) {
        this.gender = gender;
    }



    public String getBloodGroup() {
        return bloodGroup;
    }



    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }



    public String getHeight() {
        return height;
    }



    public void setHeight(String height) {
        this.height = height;
    }



    public String getWeight() {
        return weight;
    }



    public void setWeight(String weight) {
        this.weight = weight;
    }



    @Override
    public String toString() {
        return "UserRequest [email=" + email + ", password=" + password + ", name=" + name + ", phone=" + phone
                + ", address=" + address + ", gender=" + gender + ", bloodGroup=" + bloodGroup + ", height=" + height
                + ", weight=" + weight + "]";
    }

    

    
    
    
}
