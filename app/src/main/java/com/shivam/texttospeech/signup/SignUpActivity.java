package com.shivam.texttospeech.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.shivam.texttospeech.R;

public class SignUpActivity extends AppCompatActivity {

    private EditText userName,password,sex,address,phoneNo,bloodGroup,height,weight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        userName = findViewById(R.id.userName);
        password = findViewById(R.id.password);
        sex = findViewById(R.id.sex);
        address = findViewById(R.id.address);
        phoneNo = findViewById(R.id.phoneNumber);
        bloodGroup = findViewById(R.id.bloodGroup);
        height = findViewById(R.id.height);
        weight = findViewById(R.id.weight);




    }
}