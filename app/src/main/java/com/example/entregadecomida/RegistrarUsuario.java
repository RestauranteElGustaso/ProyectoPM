package com.example.entregadecomida;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrarUsuario extends AppCompatActivity implements View.OnClickListener{
EditText us, pas, nom, ap;
Button reg, can;
daoUsuario dao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_usuario);
        us=(EditText)findViewById(R.id.txtUsuarioReg);
        pas=(EditText)findViewById(R.id.txtContraseñaReg);
        nom=(EditText)findViewById(R.id.txtNombreReg);
        ap=(EditText)findViewById(R.id.txtApellidoReg);
        reg=(Button)findViewById(R.id.btnRegistrarse);
        can=(Button)findViewById(R.id.btnRegistrar);

        reg.setOnClickListener(this);
        can.setOnClickListener(this);
        dao=new daoUsuario(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnRegistrar:
                Usuario u=new Usuario();
                u.setUsuario(us.getText().toString());
                u.setPassword(pas.getText().toString());
                u.setNombres(nom.getText().toString());
                u.setApellidos(ap.getText().toString());

                if (!u.isNull()){
                    Toast.makeText(this,"Error: Campos vacios",Toast.LENGTH_LONG).show();
                }
                else if(dao.insertUsuario(u)){
                    Toast.makeText(this,"¡Registro Exitoso!",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(this,"¡El usuario ya existe!",Toast.LENGTH_LONG).show();
                }

                break;
            case R.id.btnCancelarReg:
                Intent i=new Intent(RegistrarUsuario.this,login.class);
                startActivity(i);
                finish();
                break;
        }
    }
}