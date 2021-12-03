package com.example.entregadecomida;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class actualizarUsuario extends AppCompatActivity implements View.OnClickListener {

    EditText actNombres, actApellidos, actUsuario, actPassword;
    Button btnActualizar, btnCancelar;
    int id = 0;
    Usuario u;
    daoUsuario dao;
    Intent x;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar_usuario);

        actNombres = (EditText) findViewById(R.id.txtNombreReg);
        actApellidos = (EditText) findViewById(R.id.txtApellidoReg);
        actUsuario = (EditText) findViewById(R.id.txtUsuarioReg);
        actPassword = (EditText) findViewById(R.id.txtContraseñaReg);
        btnActualizar = (Button) findViewById(R.id.btnEditActualizar);
        btnCancelar = (Button) findViewById(R.id.btnCancelarReg);
        btnActualizar.setOnClickListener(this);
        btnCancelar.setOnClickListener(this);

        Bundle b = getIntent().getExtras();
        id = b.getInt("id");
        dao = new daoUsuario(this);
        u = dao.getUsuariobyID(id);
        actUsuario.setText(u.getUsuario());
        actPassword.setText(u.getPassword());
        actNombres.setText(u.getNombres());
        actApellidos.setText(u.getApellidos());


    }

    public void onClick(View view){

        switch (view.getId()){

            case R.id.btnEditActualizar:
                u.setUsuario(actUsuario.getText().toString());
                u.setPassword(actPassword.getText().toString());
                u.setNombres(actNombres.getText().toString());
                u.setApellidos(actApellidos.getText().toString());

                if(!u.isNull()){

                    Toast.makeText(this, "ERROR: Campos Vacios", Toast.LENGTH_SHORT).show();

                }
                else if (dao.updateUsuario(u)){

                    Toast.makeText(this, "Actualización Exitosa!", Toast.LENGTH_SHORT).show();
                    Intent x = new Intent(actualizarUsuario.this, PerfilUsuario.class);
                    x.putExtra("id", u.getId());
                    startActivity(x);
                    finish();

                }
                else {

                    Toast.makeText(this, "Error al Actualizar", Toast.LENGTH_SHORT).show();
                    
                }
                break;

            case R.id.btnCancelarReg:
                Intent z = new Intent(actualizarUsuario.this, PerfilUsuario.class);
                z.putExtra("id", u.getId());
                startActivity(z);
                finish();
                break;
        }

    }

}