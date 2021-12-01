package com.example.entregadecomida;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PerfilUsuario extends AppCompatActivity implements View.OnClickListener {
Button btnEditar, btnEliminar, btnMostrar, btnSalir;
TextView nombre;
int id=0;
Usuario u;
daoUsuario dao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_usuario);
        nombre=(TextView)findViewById(R.id.txtNombreUsuario);
        btnEditar=(Button)findViewById(R.id.btnEditarPerf);
        btnEliminar=(Button)findViewById(R.id.btnEliminarPerf);
        btnMostrar=(Button)findViewById(R.id.btnMostrarPerf);
        btnSalir=(Button)findViewById(R.id.btnSalirPerf);
        btnEditar.setOnClickListener(this);
        btnEliminar.setOnClickListener(this);
        btnMostrar.setOnClickListener(this);
        btnSalir.setOnClickListener(this);

        Bundle b = getIntent().getExtras();
        id=b.getInt("id");
        dao=new daoUsuario(this);
        u=dao.getUsuariobyID(id);
        nombre.setText(u.getNombres()+" "+u.getApellidos());

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnEditarPerf:
                Intent a=new Intent(PerfilUsuario.this, actualizarUsuario.class);
                startActivity(a);
                break;
            case R.id.btnEliminarPerf:
                break;
            case R.id.btnMostrarPerf:
                Intent b=new Intent(PerfilUsuario.this, MostarUsuarios.class);
                startActivity(b);
                break;
            case R.id.btnSalirPerf:
                Intent c=new Intent(PerfilUsuario.this, login.class);
                startActivity(c);
                break;
        }
    }
}