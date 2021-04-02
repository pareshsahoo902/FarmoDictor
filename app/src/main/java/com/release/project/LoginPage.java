package com.release.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginPage extends AppCompatActivity {

    private CardView Login,Regitser;
    private FirebaseAuth mAuth;
    private EditText edit_email , edit_pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        Login = findViewById(R.id.Card_Login);
        Regitser = findViewById(R.id.Card_Register);
        edit_email = findViewById(R.id.Edit_Email);
        edit_pass = findViewById(R.id.Edit_Password);
        mAuth = FirebaseAuth.getInstance();
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();
            }
        });
        Regitser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createUser();
                startActivity(new Intent(LoginPage.this,HomeActivity.class));
            }
        });
    }

    private void loginUser() {
        mAuth.signInWithEmailAndPassword(edit_email.getText().toString().trim(), edit_pass.getText().toString())
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (!task.isSuccessful()) {
                            Toast.makeText(LoginPage.this, "Not a user! Register First", Toast.LENGTH_SHORT).show();
                        } else {
                            startActivity(new Intent(LoginPage.this,HomeActivity.class)
                                    .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK));
                        }
                    }
                });
    }

    private void createUser() {

        mAuth.createUserWithEmailAndPassword(edit_email.getText().toString(),edit_pass.getText().toString())
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            startActivity(new Intent(LoginPage.this,HomeActivity.class)
                                    .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK));

                        }
                        else{
                            Toast.makeText(LoginPage.this, "Check Internet Connection!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });


    }


}