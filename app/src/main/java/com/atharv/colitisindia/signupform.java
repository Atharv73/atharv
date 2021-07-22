package com.atharv.colitisindia;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class signupform extends AppCompatActivity {
    EditText editTextTextPersonName2;
    EditText editTextTextPersonName3;
    EditText editTextTextPersonName4;
    EditText editTextTextPersonName5;
    TextView textView;
    TextView textView5;
    RadioButton radioButton5;
    RadioButton radioButton6;
    RadioButton radioButton7;

    Button button5;
    Button button4;
    RadioGroup radioGroup1;
    private FirebaseAuth firebaseAuth;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signupform);

        editTextTextPersonName2 = findViewById(R.id.editTextTextPersonName2);
        editTextTextPersonName3 = findViewById(R.id.editTextTextPersonName3);
        editTextTextPersonName4 = findViewById(R.id.editTextTextPersonName4);
        editTextTextPersonName5 = findViewById(R.id.editTextTextPersonName5);
        textView = findViewById(R.id.textView);
        textView = findViewById(R.id.textView);
        textView5 = findViewById(R.id.textView5);
        radioButton5 = findViewById(R.id.radioButton5);
        radioButton6 = findViewById(R.id.radioButton6);
        radioButton7 = findViewById(R.id.radioButton7);

        button5 = findViewById(R.id.button5);
        button4 = findViewById(R.id.button4);
        radioGroup1 = findViewById(R.id.radiogroup1);

       firebaseAuth = FirebaseAuth.getInstance();



        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fullname = editTextTextPersonName2.getText().toString();
                String contactnumber = editTextTextPersonName3.getText().toString();
                String email = editTextTextPersonName4.getText().toString();
                String type = editTextTextPersonName5.getText().toString();




                if (fullname.isEmpty()) {
                    Toast.makeText(signupform.this, "Please enter your full name ", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (contactnumber.isEmpty()) {
                    Toast.makeText(signupform.this, "Please enter contact number", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (email.isEmpty()) {
                    Toast.makeText(signupform.this, "Please enter email adress", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (type.isEmpty()) {
                    Toast.makeText(signupform.this, "Please enter type of Colitis" ,  Toast.LENGTH_SHORT).show();
                    return;
                }

              //radio group listener add kar


                String password = "12345678";
                firebaseAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(signupform.this , new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(signupform.this, "Registration is Successful . Password reset link will be sent to your registered email address .   ", Toast.LENGTH_LONG).show();
                                    startActivity(new Intent(signupform.this , login2pg.class));



                                } else {
                                    Toast.makeText(signupform.this, "Registeration Failed", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });



            }
        });
    }
}




