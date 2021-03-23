package com.example.loginsignupdb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {

    EditText username,password;
    Button btnlogin;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username=(EditText)findViewById(R.id.username1);
        password=(EditText)findViewById(R.id.password1);
        btnlogin=(Button) findViewById(R.id.btnsignin1);
        DB= new DBHelper(this);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user=username.getText().toString();
                String pass=password.getText().toString();

                if(user.equals("")||pass.equals(""))
                    Toast.makeText(login.this,"Please enter all the fields",Toast.LENGTH_SHORT).show();
            else
                {
                    Boolean checkuserpass=DB.checkusernamepassword(user,pass);
                    if(checkuserpass==true)
                    {
                        Toast.makeText(login.this,"Sign in Successfully",Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(getApplicationContext(),homeActivity.class);
                        startActivity(intent);
                    }else
                    {
                        Toast.makeText(login.this,"Invalid Password",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}