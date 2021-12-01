package com.example.entregadecomida;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity implements View.OnClickListener{
EditText user, pass;
Button btnIngresar, btnRegistrarse;
daoUsuario dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        user=(EditText)findViewById(R.id.txtUsuarioLog);
        pass=(EditText)findViewById(R.id.txtPasswordLog);
        btnIngresar=(Button)findViewById(R.id.btnIngresar);
        btnRegistrarse=(Button)findViewById(R.id.btnRegistrarse);

        btnIngresar.setOnClickListener(this);
        btnRegistrarse.setOnClickListener(this);

        dao=new daoUsuario(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnIngresar:
                String u=user.getText().toString();
                String p=pass.getText().toString();
                if (u.equals("")&&p.equals("")){
                    Toast.makeText(this,"Error: Campos vacios",Toast.LENGTH_LONG).show();
                }
                else if (dao.login(u,p)==1) {
                    Usuario ux=dao.getUsuario(u,p);
                    Toast.makeText(this,"¡Bienvenido!",Toast.LENGTH_LONG).show();
                    Intent i2=new Intent(login.this, PerfilUsuario.class);
                    i2.putExtra("id",ux.getId());
                    startActivity(i2);
                    finish();
                }
                else{
                    Toast.makeText(this,"¡Usuario y/o contraseña incorrectos!",Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.btnRegistrarse:
                Intent i=new Intent(login.this, RegistrarUsuario.class);
                startActivity(i);
                break;
        }
    }
}