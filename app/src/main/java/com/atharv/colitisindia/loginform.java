package com.atharv.colitisindia;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class loginform extends AppCompatActivity {
    EditText editTextTextPersonName;
    EditText editTextTextPassword3;
    Button button7;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginform);
        editTextTextPassword3 = findViewById(R.id.editTextTextPassword3);
        editTextTextPersonName = findViewById(R.id.editTextTextPersonName);
        button7 = findViewById(R.id.button7);
        firebaseAuth = FirebaseAuth.getInstance();

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = editTextTextPersonName.getText().toString();
                String password = editTextTextPassword3.getText().toString();

                if(email.isEmpty()){
                    Toast.makeText(loginform.this, "Enter email address", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(password.isEmpty()){
                    Toast.makeText(loginform.this, "Enter password", Toast.LENGTH_SHORT).show();
                    return;
                }


                firebaseAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(loginform.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(loginform.this, "LOGIN COMPLETED", Toast.LENGTH_SHORT).show();



                                } else {
                                    Toast.makeText(loginform.this, "LOGIN FAILED", Toast.LENGTH_SHORT).show();

                                }
                            }
                        });


            }
        });


    }
}