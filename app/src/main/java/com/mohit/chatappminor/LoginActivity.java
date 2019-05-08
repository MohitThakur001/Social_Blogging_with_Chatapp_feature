package com.mohit.chatappminor;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    EditText email, password;
    Button btn_Login;
    FirebaseAuth auth;
    private ProgressDialog mProgress;
    private Button Signup;
    private Button forgot;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        email = findViewById(R.id.Email);
        password = findViewById(R.id.password);
        btn_Login = findViewById(R.id.btn_Login);
        Signup = (Button) findViewById(R.id.signup);
        forgot = (Button) findViewById(R.id.forgot);
        mProgress = new ProgressDialog(this);


        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                startActivity(new Intent(LoginActivity.this, ForgotPassword.class));
                finish();
            }
        });

        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
                finish();
            }
        });
        auth = FirebaseAuth.getInstance();
        btn_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mProgress.setMessage("Log In, please wait...");
                mProgress.show();
                String txt_email = email.getText().toString();
                String txt_password = password.getText().toString();
                if (TextUtils.isEmpty(txt_email) || TextUtils.isEmpty(txt_password)) {
                    Toast.makeText(LoginActivity.this, "Fill All the Given fields", Toast.LENGTH_SHORT).show();

                } else {


                    auth.signInWithEmailAndPassword(txt_email, txt_password)

                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        Intent intent = new Intent(LoginActivity.this, authandchat.class);
                                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                        startActivity(intent);
                                        finish();
                                    } else {

                                        Toast.makeText(LoginActivity.this, "Authentication Failed", Toast.LENGTH_SHORT).show();

                                    }

                                }
                            });


                }


            }
        });

    }

    @Override
    public void onBackPressed() {
       Intent intent = new Intent(LoginActivity.this,StartActivity.class);
       startActivity(intent);
       this.finish();
    }
}