package com.example.user.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DonorReg extends AppCompatActivity {
    DatabaseHelper db;
    EditText mTextUsername;
    EditText mTextPassword;
    EditText mTextCnfPassword;
    EditText bloodGroup;
    EditText contact;
    EditText address;
    Button mButtonRegister;
    TextView mTextViewLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        db = new DatabaseHelper(this);
        mTextUsername = (EditText)findViewById(R.id.edittext_username);
        mTextPassword = (EditText)findViewById(R.id.edittext_password);
        mTextCnfPassword = (EditText)findViewById(R.id.edittext_cnf_password);
        bloodGroup = (EditText)findViewById(R.id.bloodGroup);
        contact = (EditText)findViewById(R.id.Contact);
        address = (EditText)findViewById(R.id.Address);
        mButtonRegister = (Button)findViewById(R.id.button_register);
        mTextViewLogin = (TextView)findViewById(R.id.textview_login);
        mTextViewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent LoginIntent = new Intent(DonorReg.this,DonorLogin.class);
                startActivity(LoginIntent);
            }
        });

        mButtonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = mTextUsername.getText().toString().trim();//trim extra space kete day.
                String pwd = mTextPassword.getText().toString().trim();
                String cnf_pwd = mTextCnfPassword.getText().toString().trim();
                String bg = bloodGroup.getText().toString().trim();//trim extra space kete day.
                String ct = contact.getText().toString().trim();
                String ad = address.getText().toString().trim();
                if(pwd.equals(cnf_pwd)){
                    long val = db.addDonor(user, pwd, bg, ct, ad);
                    if(val > 0){
                        Toast.makeText(DonorReg.this,"You have registered",Toast.LENGTH_SHORT).show();
                        Intent moveToLogin = new Intent(DonorReg.this,DonorLogin.class);
                        startActivity(moveToLogin);
                    }
                    else{
                        Toast.makeText(DonorReg.this,"Registration Error",Toast.LENGTH_SHORT).show();
                    }

                }
                else{
                    Toast.makeText(DonorReg.this,"Password is not matching",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}