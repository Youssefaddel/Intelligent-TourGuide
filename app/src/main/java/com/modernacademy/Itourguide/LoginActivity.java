package com.modernacademy.Itourguide;


import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import static android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP;


public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "LoginActivity";
    private static final String URL_FOR_LOGIN = "https://XXX.XXX.X.XX/android_login_example/login.php";
    //  ProgressDialog progressDialog;
    private EditText loginInputEmail, loginInputPassword;
    private Button btnlogin;
    private Button btnLinkSignup;

    private FirebaseAuth mAuth;
    Button btnregister;
    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();

        loginInputEmail = findViewById(R.id.login_input_email);
        loginInputPassword = findViewById(R.id.login_input_password);

        btnlogin = findViewById(R.id.btn_login);
        btnregister = findViewById(R.id.btn_link_signup);

        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
//                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            }
        });

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signin();
            }
        });

    }

    private void signin() {
        String email = loginInputEmail.getText().toString();
        String password = loginInputPassword.getText().toString();

        if (email.isEmpty()) {
            loginInputEmail.setError("Email is required");
            loginInputPassword.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            loginInputEmail.setError("Please enter a valid email");
            loginInputEmail.requestFocus();
            return;
        }
        if (password.isEmpty()) {
            loginInputPassword.setError("Password is required");
            loginInputPassword.requestFocus();
            return;
        }
        if (password.length() < 6) {
            loginInputPassword.setError("Minimum lenght of password should be 6");
            loginInputPassword.requestFocus();
            return;
        }

        loginUser();
    }


    private void loginUser() {
        String email = loginInputEmail.getText().toString();
        String password = loginInputPassword.getText().toString();

        mAuth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d("TESTING","sign In Successful:" + task.isSuccessful());

                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {
                            Log.w("TESTING","signInWithEmail:failed",task.getException());
                            Toast.makeText(LoginActivity.this,"E-mail or Password is not correct or There's no Internet Connection !!",Toast.LENGTH_SHORT).show();
                        } else {
                            Intent i = new Intent(LoginActivity.this,Draweractivity.class);
                            startActivity(i);
                            Toast.makeText(LoginActivity.this,"Login Successfully",Toast.LENGTH_SHORT).show();
                            finish();

                        }

                    }
                });
    }
}