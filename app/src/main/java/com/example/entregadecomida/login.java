package com.example.entregadecomida;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class login extends AppCompatActivity implements View.OnClickListener{
EditText user, pass;
Button btnIngresar, btnRegistrarse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        user=(EditText)findViewById(R.id.txtUsuario);
        pass=(EditText)findViewById(R.id.txtPassword);
        btnIngresar=(Button)findViewById(R.id.btnIngresar);
        btnRegistrarse=(Button)findViewById(R.id.btnRegistrarse);

        btnIngresar.setOnClickListener(this);
        btnRegistrarse.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnIngresar:

                break;
            case R.id.btnRegistrarse:
                Intent i=new Intent(login.this, RegistrarUsuario.class);
                startActivity(i);
                break;
        }
    }
}