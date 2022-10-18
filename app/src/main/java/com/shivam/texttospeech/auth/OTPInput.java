package com.shivam.texttospeech.auth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.card.MaterialCardView;
import com.shivam.texttospeech.MainActivity;
import com.shivam.texttospeech.R;

public class OTPInput extends AppCompatActivity {

    EditText otpInput;

    Button verifyOTP;
    String inputOtp="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otpinput);

        otpInput = findViewById(R.id.etOTP);

        verifyOTP = findViewById(R.id.btnVerifyOtp);

        verifyOTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputOtp = otpInput.getText().toString();
                if(inputOtp.isEmpty() || inputOtp.length()!=6){
                    Toast.makeText(getApplicationContext(),"Please enter correct otp",Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent intent = getIntent();
                    String otp = intent.getStringExtra("otp");
                    String email = intent.getStringExtra("email");
                    if(otp.equals(inputOtp)){
                        Toast.makeText(getApplicationContext(),email+" verified successfully!!",Toast.LENGTH_SHORT).show();
                        Intent intent1 = new Intent(OTPInput.this, MainActivity.class);
                        startActivity(intent1);
                        finish();
                    }else{
                        Toast.makeText(getApplicationContext(),"Please enter correct otp!!",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
}