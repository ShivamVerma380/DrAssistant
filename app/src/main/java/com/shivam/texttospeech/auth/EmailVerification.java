package com.shivam.texttospeech.auth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.shivam.texttospeech.R;

import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class EmailVerification extends AppCompatActivity {

    EditText emailInput;

    Button sendOTP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_verification);

        getSupportActionBar().hide();

        emailInput = findViewById(R.id.etEmail);

        sendOTP = findViewById(R.id.btnSendOtp);

        sendOTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(emailInput.getText().toString().isEmpty()  || !Patterns.EMAIL_ADDRESS.matcher(emailInput.getText().toString()).matches()){
                    Toast.makeText(getApplicationContext(),"Please Enter valid email address",Toast.LENGTH_SHORT).show();
                }else{
                    OkHttpClient client = new OkHttpClient();

                    Request request = new Request.Builder()
                            .url(getString(R.string.api)+"/verify-email/"+emailInput.getText().toString())
                            .build();
                    client.newCall(request).enqueue(new Callback() {
                        @Override
                        public void onFailure(Call call, IOException e) {
                            e.printStackTrace();

                        }

                        @Override
                        public void onResponse(Call call, Response response) throws IOException {
                            if(response.isSuccessful()){
                                try {
                                    JSONObject jsonObject = new JSONObject(response.body().string());
                                    String message = jsonObject.getString("message");
                                    String otp = jsonObject.getString("otp");
                                    EmailVerification.this.runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            Toast.makeText(getApplicationContext(), "OTP Sent !"+emailInput.getText().toString(), Toast.LENGTH_SHORT).show();
                                            Intent intent = new Intent(EmailVerification.this,OTPInput.class);
                                            intent.putExtra("email",emailInput.getText().toString());
                                            intent.putExtra("otp",otp);
                                            startActivity(intent);
                                        }
                                    });
                                }catch (Exception e){
                                    e.printStackTrace();
                                }
                            }

                        }
                    });
                }
            }
        });

    }
}