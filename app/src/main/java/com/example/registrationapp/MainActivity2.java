package com.example.registrationapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {


    private EditText firstname;
    private EditText lastname;
    private EditText email;
    private EditText password;
    private Button register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        firstname = findViewById(R.id.first);
        lastname = findViewById(R.id.last);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        register = findViewById(R.id.registerbtn);

        register.setOnClickListener(v -> {
            checkData();
        });
    }
    boolean isEmail(EditText text){
        CharSequence email = text.getText().toString();
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }

    boolean isEmpty(EditText text){
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }


    void checkData(){
        if(isEmail(email) == false){
            email.setError ("Enter valid email!") ;
        }
        if(isEmpty(password)){
            password.setError("Password is Required");
        }
        if(isEmpty(firstname)){
            firstname.setError("firstname is Required");
        }
        if(isEmpty(lastname)){
            lastname.setError("lastname is Required");
        }
        if(isEmail(email) == true && !isEmpty(password) && !isEmpty(firstname) && !isEmpty(lastname)){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Are you sure");
            builder.setPositiveButton("Yes, I am sure", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    email.setText("");
                    password.setText("");
                    firstname.setText("");
                    lastname.setText("");
                }
            });
            //builder.setPositiveButton("Yes, I am sure", null);
            builder.setNegativeButton("No", null);
            builder.create().show();
        }
    }
}